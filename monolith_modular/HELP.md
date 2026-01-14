# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.9/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.9/gradle-plugin/packaging-oci-image.html)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

# Sobre Arquitetura Monolítica Modular

## Referência para organização de pastas
***Estrutura interna de um módulo (responsabilidade única)***
```
module_client
│
├── api
├── application
├── domain
├── infrastructure
└── PedidoModuleConfig.java 
```
### Responsabilidades de cada pasta
1. 📁 api (Camada de Entrada)
```
   pedido/api
   ├── PedidoController.java
   ├── PedidoRequest.java
   └── PedidoResponse.java
```
 - **Responsabilidade:**
   - Expor o módulo para o mundo externo (HTTP, REST, etc.)
   - Converter dados de entrada/saída (DTOs)
   - Nunca conter regra de negócio
 - ✔️ Pode conter:
   - Controllers
   - DTOs
   - Mappers simples (DTO ↔ domínio)
 - ❌ Não deve conter:
   - Lógica de negócio
   - Acesso a banco
 
2. 📁 application (Casos de Uso)
```
pedido/application
├── CriarPedidoUseCase.java
├── CancelarPedidoUseCase.java
└── PedidoService.java
```
 - **Responsabilidade:**
    - Orquestrar casos de uso
    - Coordenar domínio, validações e persistência
    - Controlar transações 
 - ✔️ Pode conter:
   - Use cases
   - Services de aplicação
   - Interfaces (ports)
 - ❌ Não deve conter:
   - Código HTTP
   - Detalhes de banco ou framework 
 👉 _Aqui vive o "o que o sistema faz", não o "como"._
 
 3. 📁 domain (Coração do Negócio)
```
pedido/domain
├── Pedido.java
├── PedidoItem.java
├── StatusPedido.java
├── PedidoRepository.java
└── exceptions
```
 - __Responsabilidade:__
   - Regras de negócio puras
   - Entidades, agregados e value objects
   - Contratos (interfaces)
 - ✔️ Pode conter:
   - Entidades
   - Regras invariantes
   - Interfaces de repositório
 - ❌ Não deve conter:
   - Spring
   - JPA annotations (idealmente)
   - Código técnico
👉 _Regra de ouro: domínio não depende de nada._

4. 📁 infrastructure (Detalhes Técnicos)
```
pedido/infrastructure
├── persistence
│   └── PedidoJpaRepository.java
│
├── messaging
└── config
```
 - __Responsabilidade:__
   - Implementar detalhes técnicos
   - Acesso a banco
   - Integrações externas
 - ✔️ Pode conter:
   - JPA repositories
   - Configurações Spring
   - Implementações de interfaces do domínio
 - ❌ Não deve conter:
   - Regras de negócio

5. shared (Compartilhado – com muito cuidado)
```
shared
├── domain
├── exceptions
└── utils
```
 - __Responsabilidade:__
   - Código verdadeiramente genérico
   - Nada específico de negócio
⚠️ _Use com moderação para evitar acoplamento indevido._