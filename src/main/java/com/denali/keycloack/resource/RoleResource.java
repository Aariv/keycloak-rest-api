/**
 * 
 */
package com.denali.keycloack.resource;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;
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
public class RoleResource {
	
	@PostMapping("roles")
	public String addRole(@RequestBody RoleRepresentation role) {
		Keycloak keycloak = KeycloakUtils.getClient();
		keycloak.realm("Service-One").roles().create(role);
		return "Added";
	}
	
	@GetMapping("roles")
	public List<RoleRepresentation> getRoles() {
		Keycloak keycloak = KeycloakUtils.getClient();
		RolesResource roles = keycloak.realm("Service-One").roles();
		return roles.list();
	}
	
	@PutMapping("roles")
	public List<RoleRepresentation> updateRole(@RequestBody RoleRepresentation role) {
		Keycloak keycloak = KeycloakUtils.getClient();
		RolesResource roles = keycloak.realm("Service-One").roles();
		roles.get(role.getId()).update(role);
		return roles.list();
	}
	
	@GetMapping("roles/{id}")
	public RoleRepresentation getRole(@PathVariable String id) {
		Keycloak keycloak = KeycloakUtils.getClient();
		RolesResource role = keycloak.realm("Service-One").roles();
		org.keycloak.admin.client.resource.RoleResource data = role.get(id);
		return data.toRepresentation();
	}
	
	@DeleteMapping("roles/{roleName}")
	public String deleteRole(@PathVariable String roleName) {
		Keycloak keycloak = KeycloakUtils.getClient();
		RolesResource role = keycloak.realm("Service-One").roles();
		role.deleteRole(roleName);
		return "Deleted";
	}
}
