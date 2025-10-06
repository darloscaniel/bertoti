# Padrões de Projetos de Sistemas em Java

## Comparação dos Padrões

| Padrão        | Descrição | Técnicas de OO | Antipattern | Aplicação |
|---------------|-----------|----------------|-------------|-----------|
| **Strategy**  | Encapsula uma família de algoritmos e os torna intercambiáveis. | Polimorfismo e encapsulamento | Herança forçada (ex.: subclasses como `Estudante`, `Empresa`, `Comum` obrigadas a sobrescrever métodos, criando hierarquia rígida e acoplamento) | Onde há variação de comportamento. Ex.: Cliente pode trocar a operação `Emprestimo` ou `Saque` em tempo de execução usando `setOperacao()` |
| **Observer**  | Permite que um objeto notifique outros sobre mudanças em seu estado, mantendo-os atualizados. | Interface, composição, polimorfismo | Acoplamento direto (ex.: `ChatGrupo` chamando diretamente métodos específicos dos usuários, dificultando extensibilidade) | Onde há dependência um-para-muitos. Ex.: Notificar clientes ou sistemas externos quando uma operação é realizada ou saldo alterado |
| **Composite** | Permite tratar objetos individuais e composições de objetos com uma interface comum. | Interface, composição, polimorfismo | Falta de abstração (ex.: `Folder` usando `instanceof` e `List<Object>` para diferenciar arquivos e pastas, gerando código repetitivo e rígido) | Onde há estruturas hierárquicas. Ex.: Grupos de clientes, pastas de arquivos ou equipes, permitindo aplicar operações ou notificações uniformemente |
