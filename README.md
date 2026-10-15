# Amabi Fintech

Aplicação de gestão financeira pessoal desenvolvida em equipe como projeto acadêmico da FIAP (Análise e Desenvolvimento de Sistemas), com metodologia ágil. O projeto reúne levantamento de requisitos, prototipação de telas, modelagem de banco de dados e desenvolvimento do front-end e da camada de dados.

## Telas
Protótipo no Figma e versão web com:
- Visão geral (saldo, evolução do saldo, entradas e saídas do mês, próxima meta)
- Área Pix / transferência (contatos frequentes, chaves, limite diário)
- Extrato de conta (busca, filtros, paginação e exportação em PDF)
- Gestão de cartões (fatura atual, limite, bloqueio de cartão)
- Criação de metas financeiras

## Documentação
A pasta `docs/` reúne os trabalhos de requisitos e modelagem do projeto:
- `01-user-stories.pdf`: épico de Gestão de Acesso e Segurança do Correntista, com cinco user stories (cadastro, login, recuperação de senha, biometria e perfil), critérios de aceitação em Gherkin, validação INVEST e priorização.
- `02-modelagem-uml.pdf`: diagrama de contexto, diagrama de casos de uso e refinamento do caso de uso "Efetuar Login", feitos no Astah.
- `03-telas-figma.pdf`: telas da interface criadas no Figma.
- `04-modelo-dados.pdf`: modelo lógico e físico do banco relacional, feitos no Oracle Data Modeler.

## Modelo de dados
Banco relacional com 9 tabelas: usuário, conta, chave Pix, contato Pix, transação, categoria, cartão, fatura e meta financeira, com chaves primárias e estrangeiras definidas no modelo físico (Oracle SQL).

## Tecnologias
- Front-end: HTML, CSS e JavaScript
- Interface: Figma
- Banco de dados: Oracle SQL, Oracle Data Modeler
- Back-end: Java com JDBC e padrão DAO (camada de dados com Oracle)
- Modelagem: UML (Astah)
- Metodologia e controle de versão: Scrum, Git e GitHub

## Minha participação
- Levantamento de requisitos e escrita das user stories
- Modelagem UML (casos de uso)
- Prototipação das telas no Figma
- Desenvolvimento das telas web (HTML, CSS e JavaScript)
- Modelagem lógica e física do banco de dados
- Camada de dados em Java com JDBC e DAO, integrada ao Oracle SQL (Usuario, Conta e Cartao)

## Estrutura do repositório
```
docs/       documentação (user stories, UML, telas e modelo de dados)
dashboard/  telas web
banco-java/ camada de dados em Java (JDBC e DAO)
```

## Status
Projeto acadêmico 
