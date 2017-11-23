package pl.arturwilanowski.models.database.dao.impl;

import pl.arturwilanowski.models.WeatherModel;
import pl.arturwilanowski.models.database.DatabaseConnector;
import pl.arturwilanowski.models.database.dao.WeatherDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherDaoImpl implements WeatherDao {         //implementacja dla SQL , dziedziczy to co chcemy
                                                        //jakbym chcial zmienic baze danych to kolejna classa dziedziczaca po weatherDaoImpl i dla logiki danej bazdy danych - innej niz SQL

    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    @Override                                       //uzupelniamy mySQL zeby spelnily logike jaka zaplanowalismy
    public void saveWeather(WeatherModel model) {
        PreparedStatement statement = databaseConnector.createStatement
                ("INSERT INTO pogodynka (city, temp) VALUES(?, ?);");
        try {                                                   //1,2 ze statement
            statement.setString(1, model.getCity());           //indexowanie od 1
            statement.setFloat(2, model.getTemp());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WeatherModel> loadWeather(String city) {

        List<WeatherModel> weatherModels = new ArrayList<WeatherModel>();

        PreparedStatement statement = databaseConnector.createStatement("SELECT * FROM pogodynka " +
                "WHERE cityname = ?");


            WeatherModel model;

        try{
            statement.setString(3,"temp");        //execute - nic nie zwraca a executeQuery - zwraca result seta
            ResultSet set = statement.executeQuery("SELECT temp FROM pogodynka WHERE cityname = ?");       //ResultSet - sprawdzić w dokumentacji.
            while (set.next()) {
                int temp = set.getInt("temp");
                System.out.println(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }       //todo   zapytania typu SELECT - trzeba to zrobic!!!   Oskar - ksiazka kontaktow!
}           //todo zapytanie zeby zwrocilo cala tabele !! trzeba
            //todo dokonczyc zadania z plikow , farmera zrobic idiotoodpornego
            //todo result seta ogarnac
            //todo zaprojektuj widok w scenbuilder gdzie user bedzie mogl wpisac nazwe miasta
            //todo na samej gorze tekst - wyswietlajacy temp! pod tym edit tekst do wpisania nazwy miasta, pod tym przycisk no i id do miast
            //todo weatherController