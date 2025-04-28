import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/plexplica";
        String user = "daniel";
        String password = "senha123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
