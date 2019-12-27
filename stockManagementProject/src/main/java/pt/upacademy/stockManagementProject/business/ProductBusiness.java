package pt.upacademy.stockManagementProject.business;

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
	public long save(Product product) throws Exception {
		
		List <Long> listShelves = product.getShelvesIds();
		Collection <Long> listCreatedShelves = shelfBus.getAllIds();
		if (!listShelves.isEmpty()) {
			if (listCreatedShelves.isEmpty()) {
				throw new IllegalArgumentException ("Ainda nao existem prateleiras criadas");
			} else {
			for (Long shelfId : listShelves) {
				if (!listCreatedShelves.contains(shelfId)) throw new Exception ("Ainda nao existe uma prateleira com esse ID");
			}
		}
	    
	}
		repository.createEnt (product);
		return product.getID();
	}
	
	
	@Override
	public void update(Product product) throws Exception {
		Product oldProduct = repository.consultEntity(product.getID());
		Collection <Long> listCreatedShelves = shelfBus.getAllIds();
		if(!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
			updateShelfFromProduct (product, oldProduct.getShelvesIds(), product.getShelvesIds());
			
		}
		
		if (!product.getShelvesIds().isEmpty()) {
		for (Long shelfId : product.getShelvesIds()) {
			if (listCreatedShelves.isEmpty()) throw new Exception ("Ainda nao existem prateleiras criadas");
			if (!listCreatedShelves.contains(shelfId)) throw new Exception ("Ainda nao existe uma prateleira com esse ID");
		}
		}
		repository.editEntity(product);
		
	}

	@Override
	public void delete(long id) {
		removeProductShelves (id);
		repository.removeEntity(id);
		
	}

	
	@Override
	public void updateShelfFromProduct(Product p, List <Long> oldShelves, List <Long> newShelves) {
		p.setShelvesIds(newShelves);
		for (Long shelfId : newShelves) {
			Shelf shelf = shelfBus.get (shelfId);
			if (shelf.getProdutoId() == 0) {
				shelf.setProdutoId(p.getID());
			}
		}
	}

public void removeProductShelves (Long productId) {
		Collection <Long> oldShelves = repository.consultEntity(productId).getShelvesIds();
		Iterator<Long> shelfIterator = oldShelves.iterator();
		while (shelfIterator.hasNext()) {
			Long shelfid = (Long) shelfIterator.next();
			shelfBus.get(shelfid).setProdutoId(0);
		}
	}

//	public List<Long> getEmptyShelves () {
//	List <Long> emptyShelves = new ArrayList <Long> ();
//	Iterator<Shelf> shelfIterator = shelfBus.consultAll().iterator();
//	while (shelfIterator.hasNext()) {
//		Shelf shelfEl = (Shelf) shelfIterator.next();
//		Long shelfId = shelfEl.getID();
//		Long id = shelfEl.getProdutoId();
//		if (id == 0) {
//			emptyShelves.add(shelfId);
//		}
//	}
//	return emptyShelves;
//}

}
