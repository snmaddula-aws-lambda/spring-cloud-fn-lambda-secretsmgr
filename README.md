# Spring Cloud Function for AWS Lambda
### Retrieves Secret Values from the SecretsManager for the given Secret Id.

## Configuring Lambda Handler on AWS Console

![](assets/LAMBDA_HANDLER_CONFIG.PNG)


### To Test Locally follow the below steps

#### 1. Run using the below command

`
    mvn clean spring-boot:run
`

#### 2. Request: Provide the secretId and invoke POST endpoint

![](assets/POSTMAN_1.PNG)

#### 3. Response: Secret Values retrieved from AWS SecretsManager

![](assets/POSTMAN_2.PNG)
