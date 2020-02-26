package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starting point of the application
 * Has to be 1 package level higher so that it can automatically find all other classes <br>
 * If you want to change that, you have to use different annotations <br>
 * and manually add the packages which have to be searched <br>
 * 
 * @author Dennis
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
