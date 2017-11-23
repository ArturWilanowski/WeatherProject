package pl.arturwilanowski.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.arturwilanowski.models.WeatherModel;
import pl.arturwilanowski.models.database.DatabaseConnector;
import pl.arturwilanowski.models.database.dao.WeatherDao;
import pl.arturwilanowski.models.database.dao.impl.WeatherDaoImpl;
import pl.arturwilanowski.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    Button buttonHey;                                                                    //wzorzec projektowy - odwrocenie sterowania - programisci coraz mniej wladzy nad kodem.
                                                                                        //coraz wiecej oddajemy freamworkowi. Laczenie przyciskow z naszym kodem
    private WeatherDao weatherDao = new WeatherDaoImpl();                                      //polimorfizm
    private WeatherService weatherService = WeatherService.getService();

    public void initialize(URL location, ResourceBundle resources) {                     //scene to stage
                                                                        //id samo sie inkrementuje, miasto, 5 stopni
        WeatherModel weatherModel = new WeatherModel(0, "Krakow", 5f);

//        weatherDao.saveWeather(weatherModel);
       weatherService.makeCall("Cracow");




    }
}
