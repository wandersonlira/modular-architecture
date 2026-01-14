# 3️⃣ Camadas dentro do Domínio (DDD)

O domínio costuma ser dividido em:

1️⃣ Entities
2️⃣ Value Objects
3️⃣ Aggregates
4️⃣ Domain Services
5️⃣ Domain Events
6️⃣ Factories (opcional)
7️⃣ Repositories (interfaces)

Vamos detalhar cada um.


# 4️⃣ Entities
O que são

Objetos com identidade própria, que continuam sendo o mesmo ao longo do tempo.

📌 Exemplo:

Cliente

Pedido

Usuário

Conta Bancária

Mesmo que seus dados mudem, a entidade é a mesma.

Características

✔ Possui ID
✔ Possui comportamento
✔ Protege suas regras

❌ Não é apenas um “anemic model” (get/set)

Exemplo conceitual:
class Pedido {
private PedidoId id;
private Status status;

    public void confirmar() {
        if (status != Status.CRIADO) {
            throw new RegraDeNegocioException("Pedido inválido");
        }
        status = Status.CONFIRMADO;
    }
}


💡 Regra importante:
➡️ Regras que pertencem à entidade ficam dentro dela

# 5️⃣ Value Objects
O que são

Objetos imutáveis, sem identidade, definidos apenas por seus valores.

📌 Exemplo:

CPF

Dinheiro

Endereço

Email

Características

✔ Imutável
✔ Comparado por valor
✔ Contém validação

Exemplo:
class Email {
private final String valor;

    public Email(String valor) {
        if (!valor.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.valor = valor;
    }
}


📌 Dois Email("a@a.com") são iguais → mesmo valor

# 6️⃣ Aggregates e Aggregate Root
O que é um Aggregate

Um conjunto de entidades e value objects que formam uma fronteira de consistência.

Aggregate Root

É a porta de entrada do aggregate.

📌 Exemplo:

Pedido (root)

Itens do Pedido

Endereço de Entrega

🚫 Regra:

Nada fora do aggregate pode alterar objetos internos diretamente.

Exemplo mental:
Pedido
├─ ItensPedido
├─ EndereçoEntrega


✔ Tudo passa pelo Pedido


# 7️⃣ Domain Services
Quando usar

Quando uma regra de negócio:

Não pertence claramente a uma entidade

Envolve múltiplas entidades

📌 Exemplo:

Transferência entre contas

Cálculo complexo envolvendo vários aggregates

Exemplo:
class TransferenciaService {

    public void transferir(Conta origem, Conta destino, Dinheiro valor) {
        origem.debitar(valor);
        destino.creditar(valor);
    }
}


⚠️ Não confundir com Application Service


# 8️⃣ Domain Events
O que são

Eventos que representam algo que aconteceu no domínio.

📌 Exemplo:

PedidoConfirmado

ClienteCadastrado

PagamentoAprovado

Por que usar

✔ Desacoplamento
✔ Comunicação entre partes do domínio
✔ Integrações futuras

Exemplo:
class PedidoConfirmado {
private final PedidoId pedidoId;
}


# 9️⃣ Repositories (Interfaces)
Papel no Domínio

O domínio define a abstração, não a implementação.

📌 Exemplo:

interface PedidoRepository {
Pedido buscarPorId(PedidoId id);
void salvar(Pedido pedido);
}


❗ Implementação fica na infraestrutura


# 🔟 SOLID aplicado ao Domínio
S — Single Responsibility

Cada entidade tem uma responsabilidade clara

O — Open/Closed

Você adiciona comportamento sem modificar regras existentes

L — Liskov

Entidades respeitam contratos

I — Interface Segregation

Repositórios pequenos e focados

D — Dependency Inversion

Domínio define interfaces, infraestrutura implementa


# 3️⃣ Camadas dentro do Domínio (DDD)

O domínio costuma ser dividido em:

1️⃣ Entities
2️⃣ Value Objects
3️⃣ Aggregates
4️⃣ Domain Services
5️⃣ Domain Events
6️⃣ Factories (opcional)
7️⃣ Repositories (interfaces)


Estou estudando sobre Clean Architeture, DDD e SOLID. Me explique informações detalhadas sobre a parte do dominio. 
