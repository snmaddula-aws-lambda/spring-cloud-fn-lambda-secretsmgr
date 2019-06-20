package snmaddula.aws.lambda.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author snmaddula
 *
 */
@Service
@RequiredArgsConstructor
public class SecretsService {

	private final AWSSecretsManager secretsManager;
	
	public Properties retrieveSecrets(String secretId) {
		try {
			GetSecretValueRequest secretReq = new GetSecretValueRequest().withSecretId(secretId);
			GetSecretValueResult secretRes = secretsManager.getSecretValue(secretReq);
			return new ObjectMapper().readValue(secretRes.getSecretString(), Properties.class);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
