package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Mostra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/mostres", description = "Endpoint to Orders Service")
@Path("/mostres")
public class MostresService {

    private Covid19Manager tm;

    public MostresService() {
        this.tm = Covid19ManagerImpl.getInstance();
        if (tm.mostresize()==0) {
            this.tm.addMostra("123456789", "3","23012020","10");
            this.tm.addMostra("987654321", " 2","30012020","11");
            this.tm.addMostra("113456789", "1","23032020","12");
        }
    }

    @GET
    @ApiOperation(value = "obtenir totes les mostres", notes = "Totes les mostres.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Geniaal!", response = Mostra.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMostres() {

        List<Mostra> mostres = this.tm.findAllMostres();

        GenericEntity<List<Mostra>> entity = new GenericEntity<List<Mostra>>(mostres) {};
        return Response.status(201).entity(entity).build()  ;

    }


    @GET
    @ApiOperation(value = "obtenir una Mostra", notes = "from one users id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Mostra obtinguda.", response = Mostra.class),
            @ApiResponse(code = 404, message = "Mostra not found")
    })
    @Path("/{id_mostra}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMostra(@PathParam("id_mostra") String id_mostra) {
        Mostra m = this.tm.getMostra(id_mostra);
        if (m == null) return Response.status(404).build();
        else  return Response.status(201).entity(m).build();
    }

    @DELETE
    @ApiOperation(value = "eliminar una Mostra", notes = "from its id.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Mostra not found")
    })
    @Path("/{id_mostra}")
    public Response deleteMostra(@PathParam("id_mostra") String id_mostra) {
        Mostra m = this.tm.getMostra(id_mostra);
        if (m == null) return Response.status(404).build();
        else this.tm.deleteMostra(id_mostra);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "modifica una Mostra", notes = "tota la mostra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Mostra not found")
    })
    @Path("/")
    public Response updateMostra(Mostra mostra) {

        Mostra m = this.tm.updateMostra(mostra);

        if (m == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Mostra", notes = "Create a new mostra.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Mostra.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMostra(Mostra mostra) {

        if (mostra.getId_p()==null || mostra.getId_clinic()==null|| mostra.getId_l()==null|| mostra.getData_extr()==null)  return Response.status(500).entity(mostra).build();
        this.tm.addMostra(mostra);
        return Response.status(201).entity(mostra).build();
    }

}
