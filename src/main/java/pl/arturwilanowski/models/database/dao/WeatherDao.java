package pl.arturwilanowski.models.database.dao;

import pl.arturwilanowski.models.WeatherModel;

import java.util.List;

public interface WeatherDao {

    void saveWeather(WeatherModel model);                 //wiecej nie trzeba podawac bo wszystkie potrzebne rzeczy mamy w klasie weathermodel
    List<WeatherModel> loadWeather(String city);
                                                        //lista od weathermodel bo ma wszystko co nam jest potrzebne i dlatego od niej tworzymy liste

    //jak sie wymysli nowa metode to tutaj!!!

    //m=np. wyswietl mi wszystkie pogody



}
