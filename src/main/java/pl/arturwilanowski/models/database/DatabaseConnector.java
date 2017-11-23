package pl.arturwilanowski.models.database;

import pl.arturwilanowski.models.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {

    private static DatabaseConnector instance = new DatabaseConnector();    //SINGLETON np.instance

    public static DatabaseConnector getInstance() {
        return instance;                                                 //WYKONA SIE TYLKO RAZ dlatego mozna tutaj
    }                                                                   //wywolac sql

    private Connection connection;                                   //klasa przechowujaca ceche w celu pozniejszych utworzen metody zeby ja wykorzystac

    private DatabaseConnector(){                        //databaseconector - jest tylko polaczeniem z baza danych!
        connect();
    }

    private void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");                  //refleksja w java - psuje obiektowosc
            try {                                               //w tym miejscu tworzy sie polaczenie
                connection = DriverManager.getConnection(Config.MYSQL_LINK, Config.MYSQL_LOGIN, Config.MYSQL_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("It works!");
    }

    public PreparedStatement createStatement(String SQL){

        try {
            return connection.prepareStatement(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
