package pt.upacademy.stockManagementProject.business;

import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.repositories.ProductRepository;


public interface ProductBusinessInterface extends EntityBusinessInterface<Product> {
//public interface ProductBusinessInterface extends EntityBusinessInterface <Product> {
	

	
	static final ProductRepository prodRep = ProductRepository.getProdInstance();
	
	void updateShelfFromProduct (long productId, long shelfId);
	
	

}
