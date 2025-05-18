import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    HttpClient client = HttpClient.newHttpClient();

    public ConversationRates BuscaCambio(String moeda) {
        HttpResponse<String> response = null;
        try {
            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/bf88196c88b29dc08662ec0d/latest/"+ moeda);
            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível realizar a consulta!");
        }
        return new Gson().fromJson(response.body(), ConversationRates.class);
    }
}
