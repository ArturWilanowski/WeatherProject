package pl.arturwilanowski.models.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    //ta metoda jest odpowiedzialna za polaczenie ze stronka, pobranie i przeczytanie i zapisac do StringBuildera
    public static String makeHttpRequest(String url){

        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL urlClass = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) urlClass.openConnection();
            InputStream inputStream = connection.getInputStream();

            int read = 0;
            while ((read = inputStream.read()) != -1){
                stringBuilder.append((char)read);           //<--- zapisujemy tekst w StringBuilderze
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();            //<--- zwraca tekst tej temp. pogody
    }

}
