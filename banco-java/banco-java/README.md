# Amabi – Camada de dados (Java + Oracle)

Camada de dados do projeto Amabi Fintech, em Java com JDBC e padrão DAO, integrada ao banco Oracle.

## Estrutura
- `model/`: classes `Usuario`, `Conta` e `Cartao`
- `dao/`: `UsuarioDao`, `ContaDao` e `CartaoDao` (inserir, listar, pesquisar, atualizar e remover)
- `factory/`: `ConnectionFactory` (conexão com o banco)
- `exception/`: exceção para entidade não encontrada
- `view/`: classes de teste que executam as operações pelo console

## Configuração do banco
As credenciais não estão no repositório. Defina as variáveis de ambiente antes de executar:

```
DB_URL=jdbc:oracle:thin:@<host>:<porta>:<sid>
DB_USER=<usuario>
DB_PASSWORD=<senha>
```

No IntelliJ: Run > Edit Configurations > Environment variables.

## Tecnologias
Java, Maven, JDBC (driver ojdbc8), Oracle SQL.
