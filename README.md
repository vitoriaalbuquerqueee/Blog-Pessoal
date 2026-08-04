readme_content = """# 📝 Blog Pessoal - API RESTful

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=spring-boot" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/PostgreSQL-Render-blue?style=for-the-badge&logo=postgresql" alt="PostgreSQL" />
  <img src="https://img.shields.io/badge/MySQL-Dev-blue?style=for-the-badge&logo=mysql" alt="MySQL" />
  <img src="https://img.shields.io/badge/Deploy-Render-purple?style=for-the-badge&logo=render" alt="Render" />
  <img src="https://img.shields.io/badge/Swagger-OpenAPI3-green?style=for-the-badge&logo=swagger" alt="Swagger" />
</p>

---

## 🌐 Link do Deploy

> 🚀 **API Rodando em Produção:**  
> [https://blog-pessoal-k3fp.onrender.com](https://blog-pessoal-k3fp.onrender.com)

---

## 🎯 Sobre o Projeto

O **Blog Pessoal** é uma API RESTful desenvolvida com **Spring Boot** para gerenciamento de postagens, temas e usuários. O sistema foi projetado seguindo a arquitetura em camadas, aplicando as melhores práticas de desenvolvimento backend em Java, suporte a múltiplos ambientes (Desenvolvimento com MySQL e Produção com PostgreSQL) e documentação interativa com Swagger.

---

## 📊 Arquitetura e Fluxo de Dados

```mermaid
graph TD
    Client[📱/💻 Cliente / Front-end] -->|HTTP Request| Controller[🎮 Controller Layer]
    Controller -->|DTO / Business Logic| Service[⚙️ Service Layer]
    Service -->|Entities| Repository[🗄️ Repository Layer]
    Repository -->|Spring Data JPA| DB[(🛢️ Banco de Dados)]
    
    subgraph Ambientes
        DB -->|Perfil: dev| MySQL[🐬 MySQL - Local]
        DB -->|Perfil: prod| Postgres[🐘 PostgreSQL - Render]
    end
