package snmaddula.aws.lambda;

import java.util.Properties;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import lombok.Setter;
import snmaddula.aws.lambda.domain.SecretRequest;
import snmaddula.aws.lambda.service.SecretsService;

/**
 * 
 * @author snmaddula
 *
 */
@Setter
@SpringBootApplication
@Import(AppContext.class)
public class App extends SpringBootRequestHandler<SecretRequest, Properties> {

	@Bean
	public Function<SecretRequest, Properties> retrieveSecrets(SecretsService service) {
		return req -> service.retrieveSecrets(req.getSecretId());
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
