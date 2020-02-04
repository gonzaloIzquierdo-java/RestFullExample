package com.gonza.rest;
 
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.gonza.rest.dto.Greeting;
import com.google.gson.Gson;
 
@Path("/greeting")
public class GreetingService {
 
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Response getMsg(@PathParam("param") String msg) {
 
		//String output = "Jersey say : " + msg;
		System.out.println("Entrada getMsg");
		Greeting out=new Greeting("1", "HOla DAvid");
		final Gson gson = new Gson();
		final String representacionJSON = gson.toJson(out);
 
		return Response.status(200).entity(representacionJSON).build();
 
	}
	
	@GET
	@Produces("application/json")
	public Response getGreetings() {
		System.out.println("Entrada getGreetings");
		List<Greeting> out=new ArrayList<Greeting>();		
		out.add(new Greeting("1", "HOla DAvid"));
		out.add(new Greeting("2", "HOla Valde"));
		out.add(new Greeting("3", "HOla Gonza"));
		final Gson gson = new Gson();
		final String representacionJSON = gson.toJson(out);
 
		
		
		return Response.status(200).entity(representacionJSON).build();
 
	}
	
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGreetings(String jsonRequest) {
		System.out.println("Entrada createGreetings");
		final Gson gson = new Gson();
		Greeting greeting=gson.fromJson(jsonRequest, Greeting.class);
		
		System.out.println("Entradada createGreeting con parametro:"+greeting);
		System.out.println("Entradada createGreeting con parametro:"+greeting.getId());
		System.out.println("Entradada createGreeting con parametro:"+greeting.getContent());
		
		if(greeting!=null){
			if(greeting.getId()!=null) {
				Greeting out=new Greeting("1", "HOla DAvid");
				final String representacionJSON = gson.toJson(out);				
				return Response.status(200).entity(representacionJSON).build();
			}
		}
		return Response.status(203).entity(null).build();
	}
	
	
	
 
}