package org.reproducer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.reproducer.model.TheEntity;

@Path("/entity2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceWithBase extends BaseResource<TheEntity>{

    @GET
    public List<TheEntity> listAll() {
        return super.listAll();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") long id) {
        return super.get(id);
    }

    @POST
    public Response add(TheEntity entity) {
        return super.add(entity);
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        return super.remove(id);
    }

}