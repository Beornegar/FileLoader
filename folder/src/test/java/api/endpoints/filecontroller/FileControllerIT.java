package api.endpoints.filecontroller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import api.endpoints.endpoints.Endpoints;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileControllerIT {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testGetRequest1() throws Exception {
    	
    	URI uri = UriComponentsBuilder.fromHttpUrl(base.toString()).path(Endpoints.V1_FILE_CONTROLLER_CONTEXT + "/getRequest1")
                .queryParam("name", "Hilbert").build().toUri();
    	
        ResponseEntity<String> response = template.getForEntity(uri,
                String.class);
        assertThat(response.getBody().equals("Hello Hilbert!"));
    }
}