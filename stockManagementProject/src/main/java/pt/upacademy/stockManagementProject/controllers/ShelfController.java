package pt.upacademy.stockManagementProject.controllers;

import javax.ws.rs.Path;

import pt.upacademy.stockManagementProject.business.ShelfBusiness;
import pt.upacademy.stockManagementProject.models.Shelf;
import pt.upacademy.stockManagementProject.repositories.ShelfRepository;

@Path("shelves")
public class ShelfController extends EntityController <ShelfBusiness,ShelfRepository,Shelf> {
	
	public ShelfController () {
		this.busEnt = new ShelfBusiness ();
	}
	
	

}
