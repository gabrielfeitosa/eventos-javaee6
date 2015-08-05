# Eventos no JavaEE6

Vamos demonstrar boas práticas para manter um código limpo e como usar os **Events** e **TransactionAttributeType**.

> [Boa Prática] Utilizar o conceito de **Single Responsibility Principle**, um dos princípios do **S.O.L.I.D.**. Este é um acrônimo para **Single responsibility**, **Open-closed**, **Liskov substitution**, **Interface segregation** e **Dependency inversion**.  

O padrão de **Responsabilidade única** é extremamente simples, porém muito ignorado. A regra é muito simples: uma classe só deve ter uma, e somente uma, razão para ser modificada. Opa, quer dizer que a classe só deve ter um método? **NÃO**, o príncipio diz **o que** ela deve fazer e **não como** será feito.  Podemos notar uma outra grande vantagem na utilização da separação de responsabilidade que são os testes unitários. [NOTA] Olhar as classes do pacote [business](https://github.com/gabrielfeitosa/eventos-javaee6/tree/master/src/main/java/com/gabrielfeitosa/business).


#### Events

Eventos permitem a comunicação dos beans sem ter dependência entre eles. Por exemplo, um bean pode definir o evento, outro bean pode executar o evento, e outro bean pode manipular esse evento. Não importa qual o pacote ou camada o bean está, não há **acoplamento de código** na utilização de eventos. 

No exemplo, temos um evento chamado [**NovaCorEvento**](https://github.com/gabrielfeitosa/eventos-javaee6/blob/master/src/main/java/com/gabrielfeitosa/evento/NovaCorEvento.java). 

###### 1. Executando um Event

Para executar um evento é necessário a classe **_javax.enterprise.event.Event_**, ela é a responsável por executar os eventos. Na classe [Orquestrador](https://github.com/gabrielfeitosa/eventos-javaee6/blob/master/src/main/java/com/gabrielfeitosa/service/Orquestrador.java), o _Event_ é injetado através da anotação **_@Inject_**. Então, para executar o evento, é só chamar a classe **_event.fire(NovaCorEvento)_** e passar como parâmetro uma instância do evento a ser executado.

###### 2. Manipulando um Event
Para manipulá-lo, adotaremos o padrão **Observer**, através da anotação **@Observes**. [NOTA] Verificar os métodos dos beans no pacote [business](https://github.com/gabrielfeitosa/eventos-javaee6/tree/master/src/main/java/com/gabrielfeitosa/business).

#### Transações
| TransactionAttributeType| Aberta? Sim |Aberta? Não|
| ------------- |:------------:| -------------:|
| REQUIRED      | Usa          | Cria          |
| REQUIRES_NEW  | Cria         | Cria          |
| NOT_SUPPORTED | Suspende     | Faz nada      |
| SUPPORTS      | Faz nada     | Faz nada      |
| MANDATORY     |Faz nada      | Lança exceção |
| NEVER         |Lança exceção | Faz nada      |

# Conclusão

- Código limpo;
- Coesão;
- Sem acoplamento;
- Responsabilida única;
- Testável;
