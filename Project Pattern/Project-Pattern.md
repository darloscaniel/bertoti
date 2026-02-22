# Padrões de Projeto em Java

## Comparação entre Padrões e Antipadrões

| Padrão | Descrição | Técnicas de OO | Antipadrão | Aplicação |
|--------|------------|----------------|------------|------------|
| **Strategy** | Encapsula uma família de algoritmos e permite trocá-los em tempo de execução. | Interface, composição, polimorfismo | Uso excessivo de `if/else` concentrando todas as variações em uma única classe (ex.: `GameCharacter` com `if/else` para cada tipo de ataque: `"SWORD"`, `"BOW"`, `"MAGIC"`) | Quando há variação de comportamento. Ex.: `GameCharacter` recebe uma `AttackStrategy` e alterna dinamicamente entre `SwordAttack`, `BowAttack` e `MagicAttack` |
| **Observer** | Define uma dependência 1→N onde vários objetos são notificados automaticamente quando outro muda de estado. | Interface, composição, polimorfismo | Acoplamento direto entre classes concretas (ex.: `YouTubeChannel` com referências fixas a `User user1` e `User user2`, chamando `receiveNotification()` diretamente) | Quando múltiplos objetos precisam reagir a mudanças. Ex.: `YouTubeChannel` implementa `Channel` e notifica uma lista de `Subscriber` ao publicar um vídeo, sem conhecer as classes concretas |
| **Composite** | Permite tratar objetos individuais e composições de objetos de maneira uniforme através de uma interface comum. | Interface comum, composição recursiva, polimorfismo | Uso de `instanceof` e `List<Object>` para diferenciar tipos manualmente (ex.: `Order` verificando com `instanceof` se cada item é `Product` ou `Combo`) | Estruturas hierárquicas. Ex.: `Product` e `Combo` implementam `ItemOrder`; um `Combo` pode conter outros `Combo` e `Product`, e `Order` calcula o total uniformemente via `getPrice()` |
| **Adapter** | Converte a interface de uma classe existente para outra interface esperada pelo cliente. | Interface, composição, encapsulamento | Usar herança ao invés de composição no adaptador (ex.: `AdaptadorSDparaUSB extends CartaoSD`, vazando métodos como `formatarCartao()` que não pertencem à interface `Usb`) | Integração entre interfaces incompatíveis. Ex.: `AdaptadorSDparaUSB` recebe um `CartaoSD` por composição e implementa a interface `Usb`, delegando `conectarUsb()` para `conectarCartaoSD()` |

---

## Resumo Conceitual

| Padrão | Problema que resolve | Exemplo no repositório |
|--------|----------------------|------------------------|
| Strategy | Muitos comportamentos variantes controlados por `if/else` | `strategy/` — `AttackStrategy` com `SwordAttack`, `BowAttack`, `MagicAttack` |
| Observer | Atualização automática entre objetos desacoplados | `observer/` — `Channel`/`Subscriber` com `YouTubeChannel` e `User` |
| Composite | Manipulação uniforme de estruturas hierárquicas | `composite/` — `ItemOrder` com `Product`, `Combo` e `Order` |
| Adapter | Comunicação entre interfaces incompatíveis | `adapter/` — `Usb` com `CartaoSD` e `AdaptadorSDparaUSB` |

---

## Exemplo Combinado: MVC com Strategy + Observer + Composite

A pasta `combinated_mvc/` demonstra como os três padrões se integram no padrão MVC:

| Camada MVC | Padrão utilizado | Classes |
|------------|------------------|---------|
| **Controller** | Strategy | `Controller` usa `ActionStrategy` (com `SaveStrategy` e `DeleteStrategy`) para definir comportamento dinâmico |
| **Model** | Observer | `Model` mantém lista de `ViewObserver` e notifica ao mudar de estado via `setState()` |
| **View** | Composite | `Panel` contém uma lista de `ViewComponent` (como `Button`), renderizando recursivamente |
| **View ↔ Model** | Observer | `TextView` implementa `ViewObserver` e é atualizada automaticamente quando o `Model` muda |

### Fluxo:
1. `Controller.handle(model)` executa a `ActionStrategy` selecionada
2. A strategy chama `model.setState(...)`, que altera o estado
3. O `Model` notifica todos os `ViewObserver` registrados (ex.: `TextView`)
4. A `View` composta (`Panel` com `Button`) é renderizada via Composite

---

## Relação com MVC

- **Strategy** → Controller (define comportamento dinâmico via `ActionStrategy`)
- **Observer** → Model notificando View (via `ViewObserver`)
- **Composite** → Estrutura hierárquica da View (`Panel` contendo `Button` e outros `ViewComponent`)
- **Adapter** → Integração entre sistemas ou APIs externas