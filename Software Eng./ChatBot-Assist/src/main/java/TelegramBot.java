import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.ollama4j.exceptions.OllamaBaseException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TelegramBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final OkHttpClient httpClient;
    private final Ollama ollama; // Integração com IA (Gemma2:2b)
    private final ExecutorService executorService;

    public TelegramBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        ollama = new Ollama();
        executorService = Executors.newCachedThreadPool(); // Substituído para permitir múltiplas respostas simultâneas
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Resposta inicial
            sendInitialResponse(chatId);

            // Processamento assíncrono para cada mensagem
            executorService.submit(() -> {
                String response = processRequest(messageText);

                SendMessage message = SendMessage.builder()
                        .chatId(chatId)
                        .text(response)
                        .build();

                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    System.err.println("Erro ao enviar a resposta: " + e.getMessage());
                    e.printStackTrace();
                }
            });
        }
    }

    private void sendInitialResponse(long chatId) {
        String initialResponse = "Estou analisando sua solicitação. Um momento...";
        SendMessage initialMessage = SendMessage.builder()
                .chatId(chatId)
                .text(initialResponse)
                .build();

        try {
            telegramClient.execute(initialMessage);
        } catch (TelegramApiException e) {
            System.err.println("Erro ao enviar resposta inicial: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String processRequest(String messageText) {
        String response;
        try {
            // Cria o prompt usando o PromptBuilder
            String prompt = buildPrompt(messageText);

            // Log do prompt enviado à IA
            System.out.println("Prompt enviado à IA: " + prompt);

            // Obtém a resposta da IA
            String iaResponse = ollama.getOllamaResponse(prompt);

            // Log da resposta completa da IA
            System.out.println("Resposta completa da IA: " + iaResponse);

            // Tenta extrair a marca de carro da resposta
            String carMake = extractCarMake(iaResponse);
            if (carMake != null) {
                // Consulta a API de modelos caso a marca seja encontrada
                response = fetchCarData(carMake);
            } else {
                // Caso a marca não seja identificada, retorna a resposta limpa da IA
                response = cleanResponse(iaResponse);
            }
        } catch (IOException | OllamaBaseException | InterruptedException e) {
            response = "Houve um erro ao processar sua solicitação: " + e.getMessage();
        }
        return response;
    }

    private String cleanResponse(String iaResponse) {
        // Remove possíveis marcadores de instruções
        iaResponse = iaResponse.replaceAll("(?i)\\*\\*Instruções:\\*\\*.*", "");
        iaResponse = iaResponse.replaceAll("(?i)\\*\\*Observação:\\*\\*", ""); // Remove cabeçalhos desnecessários
        iaResponse = iaResponse.replaceAll("\\d+\\.\\s+", ""); // Remove listas numeradas
        return iaResponse.trim(); // Remove espaços extras no início e fim
    }


    private String parseGenericResponse(String iaResponse) {
        String[] lines = iaResponse.split("\n");
        for (String line : lines) {
            if (line.toLowerCase().contains("história") || line.toLowerCase().contains("características")) {
                return line.trim();
            }
        }
        return "Desculpe, não consegui encontrar informações detalhadas. Tente ser mais específico ou pergunte sobre outra marca.";
    }

    private String fetchCarData(String make) throws IOException {
        String apiUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformake/" + make + "?format=json";
        Request request = new Request.Builder().url(apiUrl).build();

        // Log da URL da API
        System.out.println("Consultando a API com a URL: " + apiUrl);

        try (Response apiResponse = httpClient.newCall(request).execute()) {
            if (apiResponse.isSuccessful() && apiResponse.body() != null) {
                String jsonResponse = apiResponse.body().string();

                // Log da resposta da API
                System.out.println("Resposta da API recebida: " + jsonResponse);

                return formatCarData(make, parseCarModels(jsonResponse));
            } else {
                System.err.println("Falha ao consultar a API. Código de status: " + apiResponse.code());
                return "Desculpe, não encontrei modelos da marca " + make + " na base de dados.";
            }
        }
    }

    private String formatCarData(String make, String carModels) {
        if (carModels.isEmpty()) {
            return "🚗 Não encontrei modelos disponíveis para a marca **" + make + "** na base de dados.";
        }
        return "🚗 **Modelos encontrados da marca " + make + ":**\n\n" +
                carModels +
                "\n\n📌 *Se precisar de mais informações, é só perguntar!*";
    }

    private String parseCarModels(String jsonResponse) {
        StringBuilder carModels = new StringBuilder();
        JsonObject responseJson = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray results = responseJson.getAsJsonArray("Results");

        System.out.println("Iniciando parsing dos modelos. Total de resultados: " + results.size());

        if (results.size() == 0) {
            return "";
        }

        for (int i = 0; i < results.size(); i++) {
            JsonObject carModel = results.get(i).getAsJsonObject();
            carModels.append("- ").append(carModel.get("Model_Name").getAsString()).append("\n");
        }

        System.out.println("Modelos de carro extraídos: " + carModels.toString().trim());

        return carModels.toString().trim();
    }

    private String extractCarMake(String iaResponse) {
        try {
            System.out.println("Analisando resposta da IA para extração de marca: " + iaResponse);

            String[] patterns = {
                    "a marca mencionada é",
                    "marca identificada:",
                    "marca de carro mencionada:"
            };

            for (String pattern : patterns) {
                int startIndex = iaResponse.toLowerCase().indexOf(pattern);
                if (startIndex != -1) {
                    String extractedMake = iaResponse.substring(startIndex + pattern.length()).trim().split("\\s")[0];
                    System.out.println("Marca extraída com sucesso: " + extractedMake);
                    return extractedMake.replaceAll("[^a-zA-Z]", "");
                }
            }

            System.out.println("Nenhum padrão correspondente encontrado na resposta da IA.");
        } catch (Exception e) {
            System.err.println("Erro ao extrair a marca: " + e.getMessage());
        }
        return null;
    }

    public String buildPrompt(String userInput) {
        return """
    Você é uma assistente especializada em carros.
    O usuário forneceu a seguinte mensagem: "%s".
    
    Responda com as seguintes instruções:
    1. Sempre mencione a marca de carro identificada no seguinte formato: "A marca de carro mencionada é [NOME DA MARCA]".
    2. Caso não identifique uma marca, peça ao usuário que forneça mais detalhes.
    3. Forneça informações úteis sobre a marca, incluindo modelos populares e características gerais, sempre em parágrafos claros.
    4. Como voce é um assistente evite mostrar logs ao usuario, como "resposta gerada de exemplo".
    """.formatted(userInput);
    }
}
