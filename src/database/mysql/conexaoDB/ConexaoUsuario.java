package database.mysql.conexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUsuario {
    private static String url = "jdbc:mysql://localhost:3306/usuario_biblioteca";
    private static String login = "root";
    private static String senha = "root";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                // Ensure the driver is loaded - optional for newer JDBC drivers
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, login, senha);
                System.out.println("Conectado ao banco de dados.");
            }
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
            return null;
        }
    }

}