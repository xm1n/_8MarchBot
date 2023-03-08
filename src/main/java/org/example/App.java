package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try
        {
            telegramBotsApi.registerBot(new Bot());
            wakeUpDyno();
        }
        catch (Exception e){e.printStackTrace();}
    }
    private static void wakeUpDyno() {
        try {
            while(true) {

                URL url = new URL("https://xm2nbot.herokuapp.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                long responcode = connection.getResponseCode();
                System.out.println("RS CODE:"+responcode);
                if (responcode == HttpURLConnection.HTTP_OK)
                {
                    System.out.println("Working");
                }
                else{
                    System.out.println("GET not working");
                }

                Thread.sleep(60000); //

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

}
