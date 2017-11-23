package pl.arturwilanowski.models;

public class WeatherModel {         //odzwierciedlenie naszej tabeli
                                    //klasa ta da nam odzwierciedlenie tabeli w klasie
    private int id;                 //data acces object - dao - obiekt dostepu do danych - obiekt pozwalajacy manipulowac danymi w swiecie
    private String city;            //dao rozbity na czesc interfejsow i czesc implementacji ze wzgledu na rozne bazy danych i szybki dostep
    private float temp;             //pomaga nam utworzyc polimorfizm

    public WeatherModel(int id, String city, float temp) {
        this.id = id;
        this.city = city;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temp=" + temp +
                '}';
    }
}
