/**
 * 
 */
package com.denali.keycloack.resource;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denali.keycloack.utils.KeycloakUtils;

/**
 * @author zentere
 *
 */
@RestController
@RequestMapping("/api/")
public class UserResource {
	
	@PostMapping("users")
	public String addUser(@RequestBody UserRepresentation user) {
		Keycloak keycloak = KeycloakUtils.getClient();
		keycloak.realm("Service-One").users().create(user);
		return "Added";
	}
	
	@GetMapping("users")
	public List<UserRepresentation> getUsers() {
		Keycloak keycloak = KeycloakUtils.getClient();
		UsersResource usersResource = keycloak.realm("Service-One").users();
		List<UserRepresentation> data = usersResource.list();
		return data;
	}
	
	@PutMapping("users")
	public List<UserRepresentation> updateUser(@RequestBody UserRepresentation user) {
		Keycloak keycloak = KeycloakUtils.getClient();
		UsersResource usersResource = keycloak.realm("Service-One").users();
		usersResource.get(user.getId()).update(user);
		return usersResource.list();
	}
	
	@GetMapping("users/{id}")
	public UserRepresentation getUser(@PathVariable String id) {
		Keycloak keycloak = KeycloakUtils.getClient();
		UsersResource usersResource = keycloak.realm("Service-One").users();
		org.keycloak.admin.client.resource.UserResource data = usersResource.get(id);
		return data.toRepresentation();
	}
	
	@DeleteMapping("users/{id}")
	public String deleteUser(@PathVariable String id) {
		Keycloak keycloak = KeycloakUtils.getClient();
		UsersResource usersResource = keycloak.realm("Service-One").users();
		usersResource.delete(id);
		return "Deleted";
	}
}
