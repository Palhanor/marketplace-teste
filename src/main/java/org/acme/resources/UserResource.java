// É onde são configurados os endpoints, acessando o Service para pegar os dados do DB
package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.User;
import org.acme.services.UserService;

import java.util.Set;
import java.util.Optional;

@Path("/users")
public class UserResource {

    @Inject
    private UserService userService;

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Set<User> getUsers() {
        return this.userService.getUsers();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<User> getUser(String name) {
        return this.userService.getUser(name);
    }

}
