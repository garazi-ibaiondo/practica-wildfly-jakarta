package com.mycompany.myproject.module.services;

import java.util.List;
import java.util.ArrayList;
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

	private static final List<Pojo> lista = new ArrayList<>();
	
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
		return lista;
	}

	@GET
	@Path("/pojo/find/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Pojo find(@PathParam("id") Integer id) {
		
		System.out.println("Buscando un elemento Pojo con id: " + id);

		for (Pojo p : lista) {
		    if (p.getId() == id) {
		        System.out.println("Found: " + p);
		        return p;
		    }
		}

		return null;
	}

	@POST
	@Path("/pojo/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Pojo pojo) {
		System.out.println("Creando un nuevo elemento Pojo: " + pojo);

        lista.add(pojo);

		return Response.status(201).build();
	}

	@PUT
	@Path("/pojo/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Pojo pojo) {

		System.out.println("Modificando el Pojo: " + pojo);

		for (Pojo p : lista) {
		    if (p.getId() == pojo.getId() ) {
		        p.setName(pojo.getName());
		        break; // stop after updating one
		    }
		}

		return Response.status(204).build();
	}

	@DELETE
	@Path("/pojo/remove/{id}")
	public Response delete(@PathParam("id") Integer id) {

		System.out.println("Eliminando el  pojo con id: " + id);

		lista.removeIf(p -> p.getId() == id);

		return Response.status(204).build();
	}

}
