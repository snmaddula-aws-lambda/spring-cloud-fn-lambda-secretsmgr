package snmaddula.aws.lambda;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;

import lombok.Setter;

/**
 * 
 * @author snmaddula
 *
 */
@Setter
@ConfigurationProperties("aws")
public class AppContext {

	private String region;
	
	@Bean
	public AWSSecretsManager secretsManager() {
		return AWSSecretsManagerClientBuilder.standard().withRegion(region).build();
	}
}
