/**
 *
 */
package training.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author aruangth
 */
@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        final BCryptPasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("agoldberg").password(encoder.encode("pass1")).roles(
                "USER").and().withUser("bgoldberg").password(encoder.encode("pass2")).roles(
                        "USER", "OPERATOR");
    }

}
