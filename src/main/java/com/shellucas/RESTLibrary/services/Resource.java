package com.shellucas.RESTLibrary.services;

import com.shellucas.RESTLibrary.dbaccess.DBAccess;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

/**
 * @author shelby
 * @author lucas
 */
public abstract class Resource<T> {

    private DBAccess<T> DATABASE;

    /**
     * Gets all entities from the database as a {@code List}. The MIME media type of
     * representation produces a resource in the form of the specified @Produces
     * responses. If multiple MIME types are equally viable, the first occurrence
     * of a viable type will be chosen as the response.
     *
     * @return The {@code List} of entities.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<T> getAll() {
        return DATABASE.get();
    }

    /**
     * Gets an entities from the database. The MIME media type of
     * representation produces a resource in the form of the specified @Produces
     * responses. If multiple MIME types are equally viable, the first occurrence
     * of a viable type will be chosen as the response.
     *
     * @param id The ID of the entity
     * @return Returns a Response code corresponding the the HTML Response Codes
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("id") Integer id) {
        final T entity = DATABASE.getById(id);
        return (entity == null)
                ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.status(Response.Status.OK).entity(entity).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, T e) {
        return (DATABASE.put(e))
                ? Response.status(Response.Status.OK).entity(e).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(T e) {
        DATABASE.post(e);
        return null;
    }



}
