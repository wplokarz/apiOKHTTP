package okhttpClientRequests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.example.okhttpConfig;

import java.io.IOException;

public abstract class ClientRequests {
    private OkHttpClient client = new OkHttpClient();

    public Response sendRequest(String method, String url, RequestBody body) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);

        requestBuilder.method(method, body);
        Request request = requestBuilder.build();
        return client.newCall(request).execute();
    }
    public Response getRequest(String boardID) throws IOException {
        String url = okhttpConfig.url(boardID).toString();
        return sendRequest("GET", url, null);
    }
    public Response postRequest(String boardName) throws IOException {
        String url = okhttpConfig.url("").toString();
        RequestBody body = new FormBody.Builder()
                .add("name", boardName)
                .build();
        return sendRequest("POST", url, body);
    }

    public Response putRequest(String boardID, String boardName) throws IOException {
        String url = okhttpConfig.url(boardID).toString();
        RequestBody body = new FormBody.Builder()
                .add("name", boardName)
                .build();
        return sendRequest("PUT", url, body);
    }

    public Response deleteRequest(String boardID) throws IOException {
        String url = okhttpConfig.url(boardID).toString();
        return sendRequest("DELETE", url, null);
    }

    public static String getValueFromJson(String value, String response) {
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        return jsonObject.get(value).getAsString();
    }
}
