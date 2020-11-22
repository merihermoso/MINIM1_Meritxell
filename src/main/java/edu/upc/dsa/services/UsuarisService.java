package edu.upc.dsa.services;


import edu.upc.dsa.Gestor;
import edu.upc.dsa.GestorImpl;
import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Usuari;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/usuaris", description = "Endpoint to Usuaris Service")
@Path("/usuaris")
public class UsuarisService {

    private Gestor tm;

    public UsuarisService() {
        this.tm = GestorImpl.getInstance();
        if (tm.size()==0) {                   //ho posa el doble de vegades =?=?
            this.tm.addUsuari("Maria", "Lopez Fernandez");
            this.tm.addUsuari("Rosa", "García Ruiz");
            this.tm.addUsuari("Laura", "Metal Lica");
        }
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuaris() {

        List<Order> orders = this.tm.findAllOrders();

        GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(orders) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        Usuari a = this.tm.getUsuari(id);
        if (a == null) return Response.status(404).build();
        else  return Response.status(201).entity(a).build();
    }

    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    public Response deleteUsuari(@PathParam("id") String id) {
        Usuari u = this.tm.getUsuari(id);
        if (u == null) return Response.status(404).build();
        else this.tm.deleteUsuari(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update an User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    public Response updateUser(Usuari usu) {

        Usuari u = this.tm.updateUsuari(usu);

        if (u == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Order.class),
            @ApiResponse(code = 500, message = "Validation Error. Something is missing...")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuari(Usuari usuari) {

        if (usuari.getNom()==null || usuari.getPwd()==null)  return Response.status(500).entity(usuari).build();
        this.tm.addUsuari(usuari);
        return Response.status(201).entity(usuari).build();
    }

}
