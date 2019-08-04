package org.reproducer;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.reproducer.model.TheEntity;

@Path("/entity")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resource {

    @GET
    public List<TheEntity> listAll() {
        return TheEntity.listAll();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") long id) {
        TheEntity entity = TheEntity.findById(id);
        if (entity != null) {
            return Response.ok(entity).build();
        } else {
            return notFound(id);
        }
    }

    @POST
    @Transactional
    public Response add(TheEntity entity) {
        TheEntity.persist(entity);
        URI uri = UriBuilder.fromPath("/").path(Resource.class).path("{id}").build(entity.id);
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response remove(@PathParam("id") long id) {
        TheEntity entity = TheEntity.findById(id);
        if (entity != null) {
            entity.delete();
            return Response.noContent().build();
        } else {
            return notFound(id);
        }
    }

    private Response notFound(long id) {
        return Response.status(404).entity("Entity with id " + id + " not found.").build();
    }
}