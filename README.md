# Livro de Receitas Online :book: :shallow_pan_of_food:
> Este projeto consiste em uma API RESTful para gerenciar receitas e suas categorias.

## Tecnologias utilizadas
<table>
  <tr>
    <td>Java</td>
    <td>Spring Boot</td>
    <td>PostgreSQL</td>
    <td>Insomnia</td>
  </tr>
  <tr>
    <td>1.8</td>
    <td>2.7</td>
    <td>6.21</td>
    <td>2023.2</td>
  </tr>
</table>

## Funcionalidades

### Cadastro de Categoria

<p>Permite o cadastro de uma nova categoria de receita.</p>

+ Identificador único (autogerado).
+ Nome
+ Descrição

<p><strong>Restrições</strong></p>

+ Não é permitido o cadastro de uma categoria com nome duplicado
+ O preenchimento da categoria é obrigatório
+ Campos inválidos não são aceitos

### Listagem de Categorias

<p>Lista todas as categorias cadastradas com seus respectivos campos.</p>

### Exclusão de Categoria
 <p>Permite deletar uma categoria por identificador.</p>
 
<p><strong>Restrições</strong></p>

+ Não é permitido deletar uma categoria caso haja uma receita cadastrada nessa categoria

### Cadastro de receita

<p>Permite o cadastro de uma nova receita.</p>

+ Identificador único (autogerado)
+ Identificador da categoria 
+ Nome
+ Ingredientes
+ Modo de preparo
+ Possui restrições (boolean)

<p><strong>Restrições</strong></p>

+ O id da categoria deve ser válido e já cadastrado
+ Não é permitido o cadastro de uma receita com identificador duplicado
+ Campos inválidos não são aceitos

### Listagem de Receitas

<p>Lista todas as receitas cadastradas com seus respectivos campos.</p>

### Edição de Receita

<p>Permite a edição das informações de uma receita por identificador.</p>

### Exclusão de Receita

<p>Permite deletar uma receita por identificador.</p>

### Listagem de Receitas Conforme Categoria

<p>Lista receitas com a busca de suas respectivas categorias.</p>

## Como Executar o Projeto

1. Certifique-se de ter o PostgreSQL instalado em sua máquina
2. Clone o repositório do projeto com o comando git clone https://github.com/seudominio/nome-do-repositorio.git
3. Acesse a pasta do projeto com o comando cd nome-do-repositorio
4. Abra o arquivo application.properties e configure as informações do seu banco de dados PostgreSQL
5. Execute o projeto com o comando mvn spring-boot:run
6. Acesse a API através da URL http://localhost:8080/api

## Endpoints Disponíveis

### Categorias

+ <strong>GET</strong> "/category": lista todas as categorias cadastradas
+ <strong>GET</strong> "/category/{id}": busca uma categoria pelo id
+ <strong>POST</strong> "/category": cria uma nova categoria
+ <strong>PUT</strong> "/category/{id}": atualiza uma categoria existente
+ <strong>DELETE</strong> "/category/{id}": deleta uma categoria existente

### Receitas

+ <strong>GET</strong> "/recipe": lista todas as receitas cadastradas
+ <strong>GET</strong> "/recipe/{id}": busca uma receita pelo id 
+ <strong>GET</strong> "/recipe/recipeCategory": busca uma receita pela sua categoria
+ <strong>POST</strong> "/recipe": cria uma nova receita
+ <strong>PUT</strong> "/recipe/{id}": atualiza uma receita existente
+ <strong>DELETE</strong> "/recipe/{id}": deleta uma receita existente
