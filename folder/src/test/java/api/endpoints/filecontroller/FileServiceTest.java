package api.endpoints.filecontroller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileServiceTest {

	@Autowired
	FileService cut;
	
	@Test
	public void catalog_model_is_useable() throws IOException {

		String filepath = "src/test/java/resources/test.csv";
		
		FileRepresentation rep = cut.getValuesFromCSV(filepath);
	
		assertTrue(rep.getTexts().size() > 0);
	}

}