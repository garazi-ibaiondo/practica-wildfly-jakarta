package com.mycompany.myproject.module.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.mycompany.myproject.module.Pojo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("myservice")
public class MyService {

	@GET
	@Path("/hello")
	public Response sayHello(@Context HttpServletRequest request) {
		Response response = Response.ok("Kaixo!").build();
		return response;
	}

	@GET
	@Path("/pojo/list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Pojo> getAll() {
		return Arrays.asList(new Pojo(1, "LALALA"), new Pojo(2, "LElele"));
	}

	@GET
	@Path("/pojo/find/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Pojo find(@PathParam("id") Integer id) {
		return new Pojo(1, UUID.randomUUID().toString());
	}

	@POST
	@Path("/pojo/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Pojo pojo) {

		System.out.println("Creando un nuevo elemento Pojo: " + pojo);

		return Response.status(201).build();
	}

	@PUT
	@Path("/pojo/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Pojo pojo) {

		System.out.println("Modificando el Pojo: " + pojo);

		return Response.status(204).build();
	}

	@DELETE
	@Path("/pojo/remove")
	public Response delete(@QueryParam("id") Integer id) {

		System.out.println("Eliminando el  pojo con id: " + id);

		return Response.status(204).build();
	}

}
