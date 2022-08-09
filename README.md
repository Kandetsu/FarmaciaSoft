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

![image](https://user-images.githubusercontent.com/89923975/183559105-c001c5db-a7cc-4e68-970b-9684dbc7e155.png)

## Aba Cliente

Função Botões: Buscador por ID, Cadastrar Novo cliente, Editar, Limpar formulário, Atualização da tabela, Deletar, Opção de Cancelar.

![image](https://user-images.githubusercontent.com/89923975/183561404-fed5fe13-5d7a-4950-b543-051ac4bcfdbb.png)

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

![image](https://user-images.githubusercontent.com/89923975/183561477-69269b39-1e2a-47a1-836a-949fa289abfa.png)

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

![image](https://user-images.githubusercontent.com/89923975/183561512-8f6121e2-afd6-48be-9cde-dbff73bfc202.png)

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

![image](https://user-images.githubusercontent.com/89923975/183561550-d9823dfe-bfef-41c9-9f20-0c13fc25838e.png)

### Como Utilizar

- Botão Novo: Habilita os campos para preenchimento.
- Botão Editar: Quando tiver procurado por ID e quiser habilitar os campos para alteração.
- Botão Cancelar: Quando quiser trancar os campos de preenchimento.
- Botão Deletar: Fica habilitado após clicar em uma linha da tabela para deletar o Produto selecionado.
- Botão Salvar Cadastro: Capta os dados dos campos de preenchimento e salva no Banco De Dados.
- Botão Limpar Formulário: Limpa os campos de preenchimento sem precisar apagar um a um.
- Botão Atualizar Tabela: Primeira vez clicado mostra os dados da Tabela, clicando novamente após um cadastro irá atualizar a Tabela.
- Botão Ok : Inserido o ID no campo respectivo irá puxar todas as informações do ID selecionado para os respectivos campos.
