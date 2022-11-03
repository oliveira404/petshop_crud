package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource; //alternativa ao Driver manager

    public ConnectionFactory(){
        ComboPooledDataSource comboPool = new ComboPooledDataSource();

        //Se for banco MariaDB usar esse.
        comboPool.setJdbcUrl("jdbc:mariadb://localhost/petshop_db?useTimezone=true&serverTimezone=UTC");

        //Se for Mysql usar esse
        //comboPool.setJdbcUrl("jdbc:mysql://localhost/petshop_crud?useTimezone=true&serverTimezone=UTC");

        //login e senha do seu banco de dados
        comboPool.setUser("igor");
        comboPool.setPassword("0122");

        //limites de conexões ao mesmo tempo
        comboPool.setMaxPoolSize(30);

        //passando os dados de conexões para o jdbc
        this.dataSource = comboPool;
    }

    public Connection recoveryConnection(){
        try{
            System.out.println("Sucess Get Connection");
            return this.dataSource.getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
