package edu.upc.dsa.services;


import edu.upc.dsa.Gestor;
import edu.upc.dsa.GestorImpl;
import edu.upc.dsa.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/products", description = "Endpoint to Products Service")
@Path("/products")
public class ProductsService {

    private Gestor tm;

    public ProductsService() {
        this.tm = GestorImpl.getInstance();
        if (tm.size()==0) {
            this.tm.addProduct("La Barbacoa", "Georgie Dann");
            this.tm.addProduct("Despacito", "Luis Fonsi");
            this.tm.addProduct("Enter Sandman", "Metallica");
        }


    }

    @GET
    @ApiOperation(value = "get all Products", notes = "All Products")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {

        List<Product> products = this.tm.findAllProducts();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @GET
    @ApiOperation(value = "get a Product", notes = "Product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") String id) {
        Product t = this.tm.getProduct(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Product", notes = "Delete 1 Product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Product t = this.tm.getProduct(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteProduct(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Product", notes = "Update 1 Product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/")
    public Response updateProduct(Product product) {

        Product t = this.tm.updateProduct(product);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Product", notes = "Register 1 Product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Product.class),
            @ApiResponse(code = 500, message = "Validation Error. Something is missing...")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product product) {

        if (product.getPrize()==null || product.getProductName()==null)  return Response.status(500).entity(product).build();
        this.tm.addProduct(product);
        return Response.status(201).entity(product).build();
    }

}