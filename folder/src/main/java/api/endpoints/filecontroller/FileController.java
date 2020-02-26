package api.endpoints.filecontroller;

import static api.endpoints.endpoints.Endpoints.V1_FILE_CONTROLLER_CONTEXT;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(V1_FILE_CONTROLLER_CONTEXT)
public class FileController {

	@Autowired
	public FileService fileService;
	
	@GetMapping("/getRequest1")
	public String getRequest1(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return fileService.getFileContentAsString(name);
	}
	
	@GetMapping("/getRequest2")
	public FileRepresentation getRequest2(@RequestParam(value = "path") String path) throws IOException {
		return fileService.getValuesFromCSV(path);
	}
	
}
