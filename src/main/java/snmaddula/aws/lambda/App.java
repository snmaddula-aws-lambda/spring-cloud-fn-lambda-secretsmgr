package snmaddula.aws.lambda;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import lombok.Setter;

/**
 * 
 * @author snmaddula
 *
 */
@Setter
@SpringBootApplication
@Import(AppContext.class)
public class App extends SpringBootRequestHandler<String, String> {

	@Bean
	public Function<String, String> retrieveSecrets(SecretsService service) {
		return secretId -> service.retrieveSecrets(secretId);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
