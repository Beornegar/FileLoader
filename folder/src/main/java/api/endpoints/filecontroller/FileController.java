package api.endpoints.filecontroller;

import static api.endpoints.endpoints.Endpoints.V1_FILE_CONTROLLER_CONTEXT;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Entry-Point for all Calls to the service, which have the per @RequestMapping
 * defined path <br>
 * Afterwards the endpath & HTTP-Method will decide which method should be
 * called with given data <br>
 * <br>
 * The @RestController means, that per default a json-file will be returned
 * (parsed per Jackson internally) <br>
 * 
 * @author Dennis
 *
 */
@RestController
@RequestMapping(V1_FILE_CONTROLLER_CONTEXT)
@Api(value = "Files")
public class FileController {

	/**
	 * Autowired means, that the already instantiated bean will be injected here
	 * <br>
	 * All classes which have @Component-Annotation will be instantiated at startup
	 * <br>
	 * This means that @RestController, @Service, @Repository etc. will be
	 * instantiated, <br>
	 * because they also include the @Component-Annotation <br>
	 */
	@Autowired
	public FileService fileService;

	/**
	 * Used to make REST-Calls to other APIs Also see:
	 * https://stackoverflow.com/questions/42365266/call-another-rest-api-from-my-server-in-spring-boot
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Called when request ends with /getRequest1 and HTTP-Method = GET <br>
	 * Alternativly use: @PostMapping, @PutMapping etc.. <br>
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/echo")
	@ApiOperation(value = "Echoes the given string plus extras", notes = "Das ist eine Notiz, welche in Swagger dazu angezeigt wird", response = String.class)
	public String getEcho(@RequestParam(value = "name", defaultValue = "World") String name) {

		return fileService.getFileContentAsString(name);
	}

	@GetMapping("/readCSV")
	@ApiOperation(value = "Loads a file from system", notes = "The filepath has to be an full file path", response = FileRepresentation.class)
	public FileRepresentation getValuesFromCSVFileInSystem(@RequestParam(value = "path") String path)
			throws IOException {
		return fileService.getValuesFromCSV(path);
	}

}
