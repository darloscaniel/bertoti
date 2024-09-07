## Engenharia de Software - Professor Giuliano Bertoti

### Atividade 1: 08/08/2024

We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

* O que é engenharia de Software?


Engenharia de Software é o processo de planejar, desenhar e aplicar software utilizando princípios de engenharia, com foco na criação de sistemas sustentáveis, escaláveis e eficientes a curto e longo prazo. Isso envolve a adoção de metodologias estruturadas que garantem a eficiência, organização e fácil manutenção do software, enquanto asseguram que ele atenda às necessidades atuais e possa crescer em tamanho e complexidade sem comprometer a funcionalidade e o desempenho do sistema. Além disso, o rigoroso controle de qualidade e as práticas que permitem a evolução contínua do software são essenciais para seu desenvolvimento em larga escala.

### Atividade 2: 12/08/2024

* O que são Trade Offs?

Trade Off é um conceito que se baseia em uma "troca equivalente" dentro da engenharia de software, essa troca esta aplicada a diversos exemplos:

  * *Desempenho e Manutenção:*  Melhorar o desempenho de um software pode exigir otimizações complexas e código menos intuitivo, o que pode tornar o sistema mais difícil de entender e manter. Em contrapartida, escrever código mais limpo e simples pode facilitar a manutenção, mas pode não ser o mais eficiente em termos de desempenho.
  
  * *Segurança e Experiência do Usuário:* Implementar medidas de segurança rigorosas pode proteger melhor o sistema contra ameaças, mas também pode tornar a experiência do usuário mais complicada, como exigir autenticações adicionais ou restringir o acesso a determinadas funcionalidades. Por outro lado, focar na facilidade de uso pode comprometer alguns aspectos da segurança.
  
  * *Funcionalidade e Desenvolvimento:* Adicionar mais funcionalidades a um software pode aumentar o valor para o usuário, mas isso pode também estender o tempo de desenvolvimento. Se houver uma necessidade urgente de lançamento, pode ser necessário reduzir o escopo das funcionalidades para atender aos prazos.

###  Atividade 3 - 19/08/2024

* Criar um novo exemplo de classes e realizar testes automatizados.

**Arquivo: Carros.java**

```java
package org.example;

//Criada a claasse Carros
//A classe criada possui os atributos definidos como privados

public class Carros{

    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private double preco;

    //Criado o metodo construtor, definido como publico

    public Carros (String modelo, String marca, String placa, String cor, double preco){

        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.preco = preco;

    }

    //Métodos de acesso e modificação

    public double getPreco() {
        return preco;
    }

    public void setPreco() {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
```

**Arquivo: Concessionaria.java**

```java
package org.example;

import java.util.LinkedList;
import java.util.List;

// Classe Concessionaria que gerencia uma lista de carros
public class Concessionaria {

    // Lista privada de objetos do tipo Carros que armazena os carros cadastrados na concessionária

    private List<Carros> carros = new LinkedList<Carros>();

    // Metodo para cadastrar um carro na lista
    public void cadastrarCarro(Carros carro){
        // Adiciona o objeto carro na lista de carros
        carros.add(carro);
    }

    // Metodo que busca carros na lista pelo modelo informado
    public List<Carros> buscarCarros(String modelo){

        // Lista que armazenará os carros encontrados que correspondem ao modelo
        List<Carros> carroEncontrado = new LinkedList<Carros>();

        for(Carros carro : carros) {
            // Verifica se o modelo do carro atual é igual ao modelo procurado
            if(carro.getModelo().equals(modelo)) {
                // Se for igual, adiciona o carro à lista de carros encontrados
                carroEncontrado.add(carro);
            }
        }
        // Retorna a lista de carros encontrados (pode ser vazia se nenhum carro corresponder ao modelo)
        return carroEncontrado;
    }

    // Metodo que retorna a lista completa de carros cadastrados
    public List<Carros> getCarros() {
        return carros;
    }
}

```

**Arquivo: CarrosTest.java**

```java
package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para a classe Carros utilizando JUnit 5
class CarrosTest {

    // Metodo de teste que verifica o funcionamento do cadastro e da busca de carros
    @Test
    void test() {

        // Criação de uma instância da classe Concessionaria, que será testada
        Concessionaria concessionaria = new Concessionaria();

        // Criação de dois objetos Carros com atributos como modelo, marca, placa, cor e preço
        Carros Onix = new Carros("Onix", "Chevrolet", "1234-ABC", "vermelho", 17000.00);
        Carros Uno = new Carros("Astra", "Chevrolet", "4321-ABC", "branco", 9000.00);

        // Cadastro dos carros na concessionária
        concessionaria.cadastrarCarro(Onix);
        concessionaria.cadastrarCarro(Uno);

        // Verifica se o número de carros cadastrados é igual a 2
        assertEquals(concessionaria.getCarros().size(), 2);

        // Busca um carro pelo modelo "Onix" e armazena o resultado na lista veiculos
        List<Carros> veiculos = concessionaria.buscarCarros("Onix");

        // Verifica se o primeiro carro encontrado tem o mesmo modelo do carro Onix
        assertEquals(veiculos.get(0).getModelo(), Onix.getModelo());
    }
}

```
