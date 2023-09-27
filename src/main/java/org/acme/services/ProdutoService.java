package org.acme.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/produtos")
@Tag(name = "Produtos")
public class ProdutoService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Retorna uma lista contendo todos os produtos", description = "Retorna os dados de tods os produtos registrados")
    public Response retornaProduto() {
        return Response.ok("Nome do produto").build();
    }

}
