package com.airhacks.stateful.machine.boundary;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatesResource {

    StateManager sm;

    public StatesResource(StateManager sm) {
        this.sm = sm;
    }

    @PUT
    public Response transition(@PathParam("stateMachineId") String stateMachineId, JsonObject event) {
        JsonObject result = sm.trigger(stateMachineId, event.getString("event"));
        return Response.ok(result).build();
    }

}