package pt.upacademy.stockManagementProject.controllers;


import javax.ws.rs.Path;


import pt.upacademy.stockManagementProject.business.ProductBusiness;
import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.repositories.ProductRepository;

@Path("products")
public class ProductController extends EntityController <ProductBusiness,ProductRepository,Product> {
	
	public ProductController () {
		this.busEnt = new ProductBusiness ();
	}


}
