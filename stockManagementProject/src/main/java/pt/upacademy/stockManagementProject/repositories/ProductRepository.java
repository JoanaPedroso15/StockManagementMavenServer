package pt.upacademy.stockManagementProject.repositories;

import pt.upacademy.stockManagementProject.models.Product;


public class ProductRepository extends EntityRepository<Product> {
	private static final ProductRepository instance = new ProductRepository ();
	
	private ProductRepository () {
		
	};
	
	
	public static ProductRepository getProdInstance () {
		return instance;
	}
}
