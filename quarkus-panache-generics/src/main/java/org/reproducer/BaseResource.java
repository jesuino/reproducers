package org.reproducer;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class BaseResource<T extends PanacheEntity> {

    public List<T> listAll() {
        return T.listAll();
    }

    public Response get(long id) {
        T entity = T.findById(id);
        if (entity != null) {
            return Response.ok(entity).build();
        } else {
            return notFound(id);
        }
    }

    @Transactional
    public Response add(T entity) {
        T.persist(entity);
        URI uri = UriBuilder.fromPath("/")
                // "this" reference was not working here
                .path(entity.getClass().getName().toLowerCase()).path("{id}").build(entity.id);
        return Response.created(uri).build();
    }

    @Transactional
    public Response remove(long id) {
        T entity = T.findById(id);
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
