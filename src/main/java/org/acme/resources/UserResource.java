package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import org.acme.services.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuarios")
public class UserResource {

    @Inject
    private UserService userService;
    @GET
    @Operation(summary = "Retorna lista de usuários", description = "Retorna a lista contendo todos os usuários do sistema")
    public Response getUsers() {
        return Response.ok(this.userService.getUsers()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Retorna um usuário específico", description = "Retorna os dados de um único usuário considerando o seu nome informado")
    public Response getUser(UUID id) {
        return Response.ok(this.userService.getUser(id)).build();
    }

    @POST
    @Operation(summary = "Adiciona um novo usuário", description = "Faz a inscrição no banco de dados")
    public Response postUser(Request request) {
        System.out.println(request);
        return Response.ok().build();
    }


}
