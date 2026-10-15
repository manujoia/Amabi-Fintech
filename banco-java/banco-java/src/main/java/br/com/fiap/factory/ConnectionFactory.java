package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // As credenciais ficam fora do código: são lidas de variáveis de ambiente.
    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String senha = System.getenv("DB_PASSWORD");

        if (url == null || usuario == null || senha == null) {
            throw new IllegalStateException(
                "Defina as variáveis de ambiente DB_URL, DB_USER e DB_PASSWORD.");
        }
        return DriverManager.getConnection(url, usuario, senha);
    }

}
