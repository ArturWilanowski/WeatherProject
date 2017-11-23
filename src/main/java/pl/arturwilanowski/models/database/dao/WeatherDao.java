package pl.arturwilanowski.models.database.dao;

import pl.arturwilanowski.models.WeatherModel;

import java.util.List;

public interface WeatherDao {

    void saveWeather(WeatherModel model);
    List<WeatherModel> loadWeather(String city);

}
