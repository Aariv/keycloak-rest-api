package com.denali.keycloack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeycloakExampleApplication {

//	private static final String SERVER_URL = "http://localhost:8080/auth";
//	private static final String REALM = "master";
//	private static final String USERNAME = "admin";
//	private static final String PASSWORD = "admin";
//	private static final String CLIENT_ID = "admin-cli";

	public static void main(String[] args) {
		SpringApplication.run(KeycloakExampleApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Keycloak keycloak = KeycloakBuilder.builder().serverUrl(SERVER_URL).realm(REALM).username(USERNAME)
//				.password(PASSWORD).clientId(CLIENT_ID)
//				.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
//
//		CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
//		credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
//		credentialRepresentation.setValue("12345678");
//
//		UserRepresentation userRepresentation = new UserRepresentation();
//		userRepresentation.setUsername("lupin");
//		userRepresentation.setFirstName("Remus");
//		userRepresentation.setLastName("Lupin");
//		userRepresentation.setEnabled(true);
//		userRepresentation.setCredentials(Arrays.asList(credentialRepresentation));
//		keycloak.realm(REALM).users().create(userRepresentation);
//
//		UsersResource usersResource = keycloak.realm(REALM).users();
//		UserRepresentation user = usersResource.search("lupin").get(0);
//		user.setEmail("lupin@hogwarts.co.uk");
//		usersResource.get(user.getId()).update(user);
//	}
}
