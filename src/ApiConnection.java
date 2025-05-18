import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private final HttpClient client = HttpClient.newHttpClient();

    public ConversionRates fetchRates(String currency) {
        HttpResponse<String> response = null;
        try {
            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/bf88196c88b29dc08662ec0d/latest/"+ currency);
            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionRates.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch currency data.");
        }

    }
}
