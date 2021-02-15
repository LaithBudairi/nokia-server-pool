package application.controller;

import application.model.Server;
import application.service.ServerService;
import application.service.impl.ServerServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;

@Path("/servers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServerController {
    private ServerService serverService = new ServerServiceImpl();

    public ServerController() throws IOException { }

    @Path("/create")
    @POST
    public Response allocate(int size,  @Context UriInfo uriInfo) {
        Server createdServer =  serverService.AllocateServer(size);

        if(createdServer == null) {
            return Response.noContent()
                    .build();
        }

        String newId = String.valueOf(createdServer.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

        return Response.created(uri)
                .entity(createdServer)
                .build();
    }
}