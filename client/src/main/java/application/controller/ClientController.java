package application.controller;

import application.model.Client;
import application.service.ClientService;
import application.service.impl.ClientServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;

@Path("/clients")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    ClientService clientService = new ClientServiceImpl();

    @Path("/create")
    @POST
    public Response allocate(Client size, @Context UriInfo uriInfo) {
        Client createdClient =  clientService.sendAllocationRequest(size);

        if(createdClient == null) {
            return Response.noContent()
                    .build();
        }

        String newId = String.valueOf(createdClient.getSize());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

        return Response.created(uri)
                .entity(createdClient)
                .build();
        }
}
