package api.endpoints.endpoints;

/**
 * Class used for defining the given endpoints. <br>
 * its better to use a class or enum instead of strings, so that we have a possiblity to find references. <br>
 * 
 * @author Dennis
 *
 */
public final class Endpoints {

	public static final String BASE_API = "/api"; 
	
	public static final String V1_API = BASE_API + "/v1";
	
	public static final String FILE_CONTROLLER = "/filecontroller";
	
	public static final String V1_FILE_CONTROLLER_CONTEXT = V1_API + FILE_CONTROLLER;
}
