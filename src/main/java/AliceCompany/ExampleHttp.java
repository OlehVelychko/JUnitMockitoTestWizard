package AliceCompany;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public abstract class ExampleHttp {
    public static void main(String[] args) {
        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();

            // Create an HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.google.com"))
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            // Send the request and get a response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the status code and response body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: ");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract HttpClient createHttpClient();
}
