package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //singleton da conexao - thread safe
    private static final ThreadLocal<Connection> conn = new ThreadLocal<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Obtem conexao com o banco de dados
    public static Connection obterConexao() throws SQLException {
        if (conn.get() == null){
            conn.set(DriverManager
                    .getConnection("jdbc:mysql://localhost/DBPI2?user=root&password=asdf"));
        }
        return conn.get();
    }
    //Fecha a conexao - usado no servlet destroy
    public static void fecharConexao() throws SQLException {
        if(conn.get() != null){
            conn.get().close();
            conn.set(null);
        }
    }
}
