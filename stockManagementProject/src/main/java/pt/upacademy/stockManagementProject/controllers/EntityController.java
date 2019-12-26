package pt.upacademy.stockManagementProject.controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pt.upacademy.stockManagementProject.business.EntityBusiness;
import pt.upacademy.stockManagementProject.models.Entity;
import pt.upacademy.stockManagementProject.repositories.EntityRepository;


public abstract class EntityController <T extends EntityBusiness <R,E>, R extends EntityRepository <E>, E extends Entity> {
	protected T busEnt;
	
 @Context
 protected UriInfo context;
	
 @GET 
 @Path("status")
 @Produces(MediaType.TEXT_PLAIN)
	 public String status () {
		 return "Url: " + context.getRequestUri().toString() + " is Ok";
	 }
 
 @POST 
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.TEXT_PLAIN)
 public long addEntity (E ent) {
		 busEnt.save(ent);
		 return ent.getID();
	 }
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 public Collection<E> consultAllEnts () {
	 return busEnt.consultAll();
	 
 }
 @GET
 @Path("/{id}")
 @Produces (MediaType.APPLICATION_JSON)
 public E consultEntById (@PathParam("id") long id) {
	 return busEnt.get(id);
 }
 
 @PUT
 @Path("/{id}")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public E updateEnt (@PathParam("id") long id, E ent) {
	 ent = busEnt.get(id);
	 busEnt.update(ent);
	 return ent;
 }
 

 @DELETE 
 @Path("/{id}")
 public void deleteEnt (@PathParam("id") long id) {
	 busEnt.delete(id);
 }
 }
 
 
