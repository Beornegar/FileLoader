package api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Security-Configuration for the whole project. <br>
 * It uses an in-memory user management with 2 users: <br>
 * 1. User: user Password: password <br>
 * 2. User: admin Password: admin <br>
 * <br>
 * You can also use an database with users <br>
 * or an external Identity Provider but for easier use i used this one. <br>
 * 
 * @author Dennis
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Register Users -> New Users = Restart of application
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
	}

	/**
	 * Defines, that all requests need to be authorized with user credentials <br>
	 * The login is an basic login-mask -> Can also be used with requests but they have to send the basic login data <br>
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
}