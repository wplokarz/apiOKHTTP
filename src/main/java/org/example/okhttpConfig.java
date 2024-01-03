package org.example;

import okhttp3.HttpUrl;
import io.github.cdimascio.dotenv.Dotenv;
public class okhttpConfig {

    public static HttpUrl url (String boardID) {
        Dotenv dotenv = Dotenv.configure().load();
        String BASE_URL = "https://api.trello.com/1/boards/";
        String apiKey = dotenv.get("API_KEY");
        String token = dotenv.get("TOKEN");
        return HttpUrl.parse(BASE_URL + boardID)
                .newBuilder()
                .addQueryParameter("key", apiKey)
                .addQueryParameter("token", token)
                .build();
    }
}
