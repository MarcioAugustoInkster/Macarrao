package entra21.java.coneccao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Banco {
    private static Connection coneccao;
    
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coneccao = DriverManager.getConnection("jdbc.mysql://localhost/filme", "root", "");
            
            return coneccao;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void desconectar() {
        if (coneccao != null) {
            try {
                coneccao.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
