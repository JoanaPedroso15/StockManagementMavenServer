package pt.upacademy.stockManagementProject.business;

import java.util.List;

import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.repositories.ProductRepository;


public interface ProductBusinessInterface extends EntityBusinessInterface<Product> {
	

	void updateShelfFromProduct(Product p, List<Long> oldShelves, List<Long> newShelves);
	
	

}
