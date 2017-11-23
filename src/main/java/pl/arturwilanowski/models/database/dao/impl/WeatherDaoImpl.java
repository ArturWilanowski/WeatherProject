package pl.arturwilanowski.models.database.dao.impl;

import pl.arturwilanowski.models.WeatherModel;
import pl.arturwilanowski.models.database.DatabaseConnector;
import pl.arturwilanowski.models.database.dao.WeatherDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherDaoImpl implements WeatherDao {

    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    @Override
    public void saveWeather(WeatherModel model) {
        PreparedStatement statement = databaseConnector.createStatement
                ("INSERT INTO pogodynka (city, temp) VALUES(?, ?);");
        try {
            statement.setString(1, model.getCity());
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
            statement.setString(3,"temp");
            ResultSet set = statement.executeQuery("SELECT temp FROM pogodynka WHERE cityname = ?");
            while (set.next()) {
                int temp = set.getInt("temp");
                System.out.println(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
