# Finalizado
# FarmaciaSoft

## Sobre o Projeto
Aplicação Desktop referente ao projeto final do [Curso developer TI - Full stack](https://www.devtisul.com.br/).

Projeto destinado a fins de testes e performance melhor no desenvolvimento em Java.

Estou usando linguagem Java, com banco de dados MySQL, juntamente com a API Swing do pacote de API'S do Java.

## Estruturado pelo modelo Layers. 
- BO - Business Object: Regras referente aos Objetos.
- DAO - Data Access Object: Camada responsável por alterações no Banco de Dados.
- Entity: Camada responsável por criação das entidades usadas.
- Service: Ponte para o package da view.
### Pacotes usados:
- farmaciasoft
- - core
- - - bo
- - - dao
- - - - connection
- - - entity
- - - service
- - - util
- - - - exception
- - view

## UML

Possuindo 5 entidades chave: Pessoa, Cliente, Funcionário, Fornecedor e Produtos.

![DiagramasCurso](https://user-images.githubusercontent.com/89923975/182263361-977c9a0c-fb46-45ca-a300-2f7403c138d5.jpg)

## Funcionalidades do sistema

- Aba de Boas Vindas.
- Aba de Cadastro de Cliente.
- Aba de Cadastro de Fornecedor.
- Aba de Cadastro de Funcionário.
- Aba de Cadastro de Produtos.

## Aba de Boas Vindas

Função: Mensagem de Boas Vindas

![image](https://user-images.githubusercontent.com/89923975/191285891-9395308e-c899-4097-9242-b5ce30a25c2e.png)

## Aba Cliente

Função Botões: Buscador por ID, Cadastrar Novo cliente, Editar, Limpar formulário, Atualização da tabela, Deletar, Opção de Cancelar.

![image](https://user-images.githubusercontent.com/89923975/191285978-fb62f5f0-a9fa-4229-bf60-9f3df114a635.png)

### Como Utilizar

- Botão Novo: Habilita os campos para preenchimento.
- Botão Editar: Quando tiver procurado por ID e quiser habilitar os campos para alteração.
- Botão Cancelar: Quando quiser trancar os campos de preenchimento.
- Botão Deletar: Fica habilitado após clicar em uma linha da tabela para deletar o Cliente selecionado.
- Botão Salvar Cadastro: Capta os dados dos campos de preenchimento e salva no Banco De Dados.
- Botão Limpar Formulário: Limpa os campos de preenchimento sem precisar apagar um a um.
- Botão Atualizar Tabela: Primeira vez clicado mostra os dados da Tabela, clicando novamente após um cadastro irá atualizar a Tabela.
- Botão Ok : Inserido o ID no campo respectivo irá puxar todas as informações do ID selecionado para os respectivos campos.

## Aba Funcionário

Função: Buscador por ID, Cadastrar Novo Funcionario, Editar, Limpar formulário, Atualização da tabela, Deletar, Opção de Cancelar.

![image](https://user-images.githubusercontent.com/89923975/191286057-21582e4f-8816-4823-b3df-b2bd1e14f879.png)

### Como Utilizar

- Botão Novo: Habilita os campos para preenchimento.
- Botão Editar: Quando tiver procurado por ID e quiser habilitar os campos para alteração.
- Botão Cancelar: Quando quiser trancar os campos de preenchimento.
- Botão Deletar: Fica habilitado após clicar em uma linha da tabela para deletar o Funcinário selecionado.
- Botão Salvar Cadastro: Capta os dados dos campos de preenchimento e salva no Banco De Dados.
- Botão Limpar Formulário: Limpa os campos de preenchimento sem precisar apagar um a um.
- Botão Atualizar Tabela: Primeira vez clicado mostra os dados da Tabela, clicando novamente após um cadastro irá atualizar a Tabela.
- Botão Ok : Inserido o ID no campo respectivo irá puxar todas as informações do ID selecionado para os respectivos campos.

## Aba Fornecedor

Função Botões: Buscador por ID, Cadastrar Novo Fornecedor, Editar, Limpar formulário, Atualização da tabela, Deletar, Opção de Cancelar.

![image](https://user-images.githubusercontent.com/89923975/191286148-313ac016-2672-44ba-8c9c-0542d408f59b.png)

### Como Utilizar

- Botão Novo: Habilita os campos para preenchimento.
- Botão Editar: Quando tiver procurado por ID e quiser habilitar os campos para alteração.
- Botão Cancelar: Quando quiser trancar os campos de preenchimento.
- Botão Deletar: Fica habilitado após clicar em uma linha da tabela para deletar o Fornecedor selecionado.
- Botão Salvar Cadastro: Capta os dados dos campos de preenchimento e salva no Banco De Dados.
- Botão Limpar Formulário: Limpa os campos de preenchimento sem precisar apagar um a um.
- Botão Atualizar Tabela: Primeira vez clicado mostra os dados da Tabela, clicando novamente após um cadastro irá atualizar a Tabela.
- Botão Ok : Inserido o ID no campo respectivo irá puxar todas as informações do ID selecionado para os respectivos campos.

## Aba Produtos

Função Botões: Buscador por ID, Cadastrar Novo Produto, Editar, Limpar formulário, Atualização da tabela, Deletar, Opção de Cancelar.

![image](https://user-images.githubusercontent.com/89923975/191286238-68a0c54a-ef7a-4cc8-b95b-928017a9e72f.png)

### Como Utilizar

- Botão Novo: Habilita os campos para preenchimento.
- Botão Editar: Quando tiver procurado por ID e quiser habilitar os campos para alteração.
- Botão Cancelar: Quando quiser trancar os campos de preenchimento.
- Botão Deletar: Fica habilitado após clicar em uma linha da tabela para deletar o Produto selecionado.
- Botão Salvar Cadastro: Capta os dados dos campos de preenchimento e salva no Banco De Dados.
- Botão Limpar Formulário: Limpa os campos de preenchimento sem precisar apagar um a um.
- Botão Atualizar Tabela: Primeira vez clicado mostra os dados da Tabela, clicando novamente após um cadastro irá atualizar a Tabela.
- Botão Ok : Inserido o ID no campo respectivo irá puxar todas as informações do ID selecionado para os respectivos campos.
