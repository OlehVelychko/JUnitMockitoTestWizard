package AliceCompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ExampleHttpTest {

    private ExampleHttp exampleHttp;
    private HttpClient mockHttpClient;
    private HttpResponse<String> mockHttpResponse;

    @BeforeEach
    void setUp() {
        // Mock HttpClient and HttpResponse
        mockHttpClient = Mockito.mock(HttpClient.class);
        mockHttpResponse = Mockito.mock(HttpResponse.class);

        // Instantiate the class under test
        exampleHttp = new ExampleHttp() {
            @Override
            protected HttpClient createHttpClient() {
                return mockHttpClient;
            }
        };
    }

    @Test
    void testGetRequestToGoogle() throws Exception {
        // Prepare the mocked response
        when(mockHttpResponse.statusCode()).thenReturn(200);
        when(mockHttpResponse.body()).thenReturn("Mocked Google Home Page");

        // Mock the HttpClient's send method
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockHttpResponse);

        // Call the method under test
        exampleHttp.main(new String[]{});

        // Verify that the HttpClient's send method was called
        verify(mockHttpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));

        // Optionally, you can capture the request and perform additional assertions
        HttpRequest capturedRequest = captureHttpRequest();
        assertEquals(URI.create("https://www.google.com"), capturedRequest.uri());
    }

    private HttpRequest captureHttpRequest() throws IOException, InterruptedException {
        var argumentCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).send(argumentCaptor.capture(), any(HttpResponse.BodyHandler.class));
        return argumentCaptor.getValue();
    }
}
