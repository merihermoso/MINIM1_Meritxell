package edu.upc.dsa.services;


import edu.upc.dsa.Gestor;
import edu.upc.dsa.GestorImpl;
import edu.upc.dsa.models.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/orders", description = "Endpoint to Orders Service")
@Path("/orders")
public class OrderService {

    private Gestor tm;

    public OrderService() {
        this.tm = GestorImpl.getInstance();
        if (tm.size()==0) {
            this.tm.addOrder("Melon", "3");
            this.tm.addOrder("Limón", " 2");
            this.tm.addOrder("Kiwi", "1");
        }
    }

    @GET
    @ApiOperation(value = "get all Orders", notes = "Totes les comandes.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Geniaal!", response = Order.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {

        List<Order> orders = this.tm.findAllOrders();

        GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(orders) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get an Order", notes = "Get an order from one user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Comanda obtinguda.", response = Order.class),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("id") int id) {
        Order a = this.tm.getOrder(id);
        if (a == null) return Response.status(404).build();
        else  return Response.status(201).entity(a).build();
    }

    @DELETE
    @ApiOperation(value = "delete an Order", notes = "Delete an order from its id.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        Order a = this.tm.getOrder(id);
        if (a == null) return Response.status(404).build();
        else this.tm.deleteOrder(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update an Order", notes = "Udate ALL the Order.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("/")
    public Response updateOrder(Order order) {

        Order a = this.tm.updateOrder(order);

        if (a == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Order", notes = "Create a new order.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newOrder(Order order) {

        if (order.getUser()==null || order.getState()==null)  return Response.status(500).entity(order).build();
        this.tm.addOrder(order);
        return Response.status(201).entity(order).build();
    }

}
