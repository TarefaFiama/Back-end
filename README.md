# 🎯 Projeto: Sistema de Gerenciamento de Eventos

Este repositório contém uma API desenvolvida para gerenciamento de eventos e participantes.
O objetivo principal é permitir o cadastro de eventos, inscrição de participantes e 
controle de vagas disponíveis.

## 📌 Sobre o Projeto

Este projeto é uma **API REST em Java com Spring Boot** desenvolvida para gerenciar **eventos e participantes**. Ele simula um sistema completo onde é possível:

- Criar e gerenciar eventos com controle de vagas
- Cadastrar participantes
- Realizar inscrições em eventos
- Cancelar inscrições
- Listar participantes de um determinado evento

A aplicação foi desenvolvida com o objetivo de facilitar o processo de **organização de eventos**, permitindo que organizadores controlem vagas disponíveis e acompanhem quem está inscrito em cada atividade.

### 🔧 Funcionalidades principais

- CRUD de eventos e participantes
- Relacionamento entre eventos e participantes (muitos-para-muitos)
- Inscrição em eventos com verificação automática de vagas
- Cancelamento de inscrição
- Listagem de todos os participantes de um evento

## 📁 Organização do Repositório

- Branch principal: `main`
- Branch de desenvolvimento: `develop`
- As funcionalidades foram implementadas de forma colaborativa, com controle de versionamento via Git.
- Cada integrante foi responsável por uma parte específica do projeto, com commits frequentes e uso de branches quando necessário.

## 📁 Estrutura de Pastas do Projeto

- src
- └── main
-    ├── java
-    │   └── com
-    │       └── evento
-    │           └── participar
-    │               ├── controllers
-    │               │   ├── EventoController.java
-    │               │   ├── ParticipanteController.java
-    │               │   └── dtos
-    │               │       ├── EventoDTO.java
-    │               │       └── ParticipanteDTO.java
-    │               ├── entities
-    │               │   ├── Evento.java
-    │               │   └── Participante.java
-    │               ├── repositories
-    │               │   ├── EventoRepository.java
-    │               │   └── ParticipanteRepository.java
-    │               ├── services
-    │               │   ├── EventoService.java
-    │               │   └── ParticipanteService.java
-    │               └── ParticiparApplication.java
-    └── resources
-        └── application.properties

## 👥 Divisão de Tarefas da Equipe

| Pessoa   | Responsabilidades |
|----------|-------------------|
| Pessoa 1: Fernando | Configuração do projeto, entidades `Evento` e `Participante`, modelagem dos relacionamentos |
| Pessoa 2: Caio | Repositórios (Repository), DTOs, camada Service e lógica de inscrição com controle de vagas |
| Pessoa 3: Danielly | Controllers da API e testes com Postman |
| Pessoa 4: Adryan | Organização do repositório no GitHub, criação do `README.md`, e acompanhamento dos commits e divisão de tarefas |

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

    ```
   git clone https://github.com/TarefaFiama/Back-end.git
   cd Back-end

## 🚀 Endpoints

#### 🧪 Testando com Postman
## 📌 Configuração
- **Base URL:** `http://localhost:8080`

### ✅ EVENTOS - `/eventos`

#### ➕ Criar um Evento
- **Método:** `POST`
- **URL:** `/eventos`
- **Body (JSON):**
  ```json
  {
  "nome": "Feira de Tecnologia",
  "descricao": "Evento sobre inovações tecnológicas",
  "vagas": 100
}

#### 📋 Listar Todos os Eventos
- **Método:**  `GET`
- **URL:**  `/eventos`

#### 🔄 Atualizar um Evento
- **Método:**  `PUT`
- **URL:**  `/eventos/{id}`
- **EXEMPLO:**  `/eventos/1`
- **Body (JSON):**
  ```json
  {
  "nome": "Feira de Tecnologia Atualizada",
  "descricao": "Evento atualizado sobre tecnologia",
  "vagas": 120
}

#### ❌ Excluir um Evento
- **Método:**  `DELETE`
- **URL:**  `/eventos/{id}`
- **EXEMPLO:**  `/eventos/1`

#### 👥 Listar Participantes de um Evento
- **Método:**  `GET`
- **URL:**  `/eventos/{id}/participantes`
- **EXEMPLO:**  `/eventos/1/participantes`

#### 👤 PARTICIPANTES - `/participantes`
## ➕ Cadastrar um Participante
- **Método:**  `POST`
- **URL:**  `/participantes`
- **Body (JSON):**
  ```json
  {
  "nome": "João Silva",
  "email": "joao@email.com"
}

#### 📝 Inscrever Participante em um Evento
- **Método:**  `POST`
- **URL:**  `/participantes/{id}/inscricoes/{eventoId}`
- **EXEMPLO:**  `/participantes/1/inscricoes/2`

#### ❌ Cancelar Inscrição do Participante
- **Método:**  `DELETE`
- **URL:**  `/participantes/{id}/inscricoes/{eventoId}`
- **EXEMPLO:**  `/participantes/1/inscricoes/2`

#### 📅 Listar Eventos em que o Participante Está Inscrito
- **Método:**  `GET`
- **URL:**  `/participantes/{id}/eventos`
- **EXEMPLO:**  `/participantes/1/eventos`
