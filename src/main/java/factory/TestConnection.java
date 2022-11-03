package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection= connectionFactory.recoveryConnection();

        try{
            connection.close();
            System.out.println("Fechando Conexão");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
