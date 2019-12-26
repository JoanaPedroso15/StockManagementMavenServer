package pt.upacademy.stockManagementProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.models.Shelf;
import pt.upacademy.stockManagementProject.repositories.ProductRepository;



public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements ProductBusinessInterface {
	public static final ShelfBusiness shelfBus = new ShelfBusiness();
	
	public ProductBusiness () { 
		repository = ProductRepository.getProdInstance();	
		}


	@Override
	public Product get(long id) {
		return prodRep.consultEntity (id);
	}
	
	public Collection<Product> consultAll () {
		return prodRep.consultAll();
	}

	@Override
	public Collection<Long> getAllIds() {
		return prodRep.getAllIds();
	}

	@Override
	public long save(Product product) { 
		prodRep.createEnt (product);
	    return product.getID();
	}

	@Override
	public void update(Product product) {
		prodRep.editEntity(product);
		
	}

	@Override
	public void delete(long id) {
		removeProductShelves (id);
		prodRep.removeEntity(id);
		
	}

	@Override
	public boolean isEmpty() {
		return prodRep.isEmpty();
		
	}

	@Override
	public void updateShelfFromProduct(long productId, long shelfId) {
		Product p = prodRep.consultEntity (productId);
		p.addShelfId(shelfId);
		Shelf shelf = shelfBus.get (shelfId);
		shelf.setProdutoId(productId);
		
	}

	public List<Long> getEmptyShelves () {
		List <Long> emptyShelves = new ArrayList <Long> ();
		Iterator<Shelf> shelfIterator = shelfBus.consultAll().iterator();
		while (shelfIterator.hasNext()) {
			Shelf shelfEl = (Shelf) shelfIterator.next();
			Long shelfId = shelfEl.getID();
			Long id = shelfEl.getProdutoId();
			if (id == 0) {
				emptyShelves.add(shelfId);
			}
		}
		return emptyShelves;
	}
	
	
	public void removeProductShelves (Long productId) {
		Collection <Long> oldShelves = prodRep.consultEntity(productId).getShelvesIds();
		Iterator<Long> shelfIterator = oldShelves.iterator();
		while (shelfIterator.hasNext()) {
			Long shelfid = (Long) shelfIterator.next();
			shelfBus.get(shelfid).setProdutoId(0);
		}
	}

}
