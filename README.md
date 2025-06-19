# poc-consulta-credito
Consulta de Crédito - POC
Este projeto consulta dados armazenados no banco de dados através de dois endpints, um por número 

Para executar o projeto os seguintes passos deverão ser executados.

**Instruções para instalação das ferramentas.** 
 - Instalação do [Java 11 ou superior](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) 
 - Instalação do [Maven](https://maven.apache.org/download.cgi) 
 - Instalação do [Git](https://git-scm.com/downloads) 
 - Instalação do [Lombok](https://projectlombok.org/download) 
 - Instação do [Docker](https://docs.docker.com/engine/install/) para executar o banco de dados.

**Instruções para Configuração do Postgress.**
 -  Executar o comando "docker pull postgres:14.5" para criar o container do Postgres 
 -  Executar o comando "docker run  --ip  127.0.0.1  -h dbserver  -dti  --privileged=true  -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=secreta -d postgres" para iniciar o banco de dados.
 
**Instruções para Configuração do Kafka** 
 -  Executar o comando "docker run --p 9092:9092 -d --name broker apache/kafka:latest" para criar o container do Kafka.
 -  Executar o comando "docker exec --workdir /opt/kafka/bin/ -it broker sh" para acessar o container do Kafka.
 -  Executar o comando "./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic" para criar o tópico.
 
**Instruções para executar o projeto**
 - Entrar na pasta do projeto 
 - Executar o comando "mvn flyway:migrate -Dflyway.configFiles=flyway.properties" para criar a tabela no banco de dados.
 - Executar o comando "mvn install" para instalar as dependencias do projeto.
 - Executar o comando "SPRING_PROFILES_ACTIVE=default,dev mvn spring-boot:run" para iniciar a aplicacao.

 

**Diagrama de Sequência da  Consulta de Crédito**

 ```mermaid
sequenceDiagram
User ->> CreditoResource: consultarPorNumeroNfse()
CreditoResource->> CreditoService: consultarPorNumeroNfse()
CreditoService->> CreditoRepository: consultarPorNumeroNfse()
CreditoRepository--x CreditoService: return
CreditoService->> CreditoMapper: toDto()
CreditoMapper--x CreditoService: return
CreditoService--x CreditoResource: return
CreditoResource--x User: return
