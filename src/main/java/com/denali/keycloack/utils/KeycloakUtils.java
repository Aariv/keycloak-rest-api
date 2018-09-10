/**
 * 
 */
package com.denali.keycloack.utils;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.stereotype.Component;

/**
 * @author zentere
 *
 */
@Component
public class KeycloakUtils {

	public static final String SERVER_URL = "http://localhost:8080/auth";
	public static final String REALM = "master";
	public static final String USERNAME = "admin";
	public static final String PASSWORD = "admin";
	public static final String CLIENT_ID = "admin-cli";
	static Keycloak keycloak;

	public KeycloakUtils() {
		keycloak = KeycloakBuilder.builder().serverUrl(SERVER_URL).realm(REALM).username(USERNAME).password(PASSWORD)
				.clientId(CLIENT_ID).resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
	}

	public static Keycloak getClient() {
		return keycloak;
	}
}
