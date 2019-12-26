package pt.upacademy.stockManagementProject.business;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.models.Shelf;
import pt.upacademy.stockManagementProject.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements ShelfBusinessInterface {
	
	  
	public static final ProductBusiness prodBus = new ProductBusiness ();

	@Override
	public Shelf get(long id) {
		return shelfRep.consultEntity (id);
	}

	public Collection<Shelf> consultAll () {
		return shelfRep.consultAll();
	}
	@Override
	public Collection <Long> getAllIds() {
		return shelfRep.getAllIds();
	}

	@Override
	public long save(Shelf shelf) {
		shelfRep.createEnt (shelf);
	    return shelf.getID();
	}

	@Override
	public void update(Shelf shelf) {
		shelfRep.editEntity(shelf);
		
	}

	@Override
	public void delete(long id) {
		Long productId = productsWithShelf (id);
		prodBus.get(productId).removeShelfId(id);
		shelfRep.removeEntity(id);
	}

	@Override
	public boolean isEmpty() {
		return shelfRep.isEmpty();
		
	}

	public Long productsWithShelf (Long shelfId) {
		Iterator<Product> prodIterator = prodBus.consultAll().iterator();
		Long productId = (long) -1;
		while (prodIterator.hasNext()) {
			Product prodEl = (Product) prodIterator.next();
			Long prodId = prodEl.getID();
			List<Long>listShelves = prodEl.getShelvesIds();
			if (listShelves.contains(shelfId)) {
				productId = prodId;
				}
		}
			return productId;
		
	}
		
	public void alterarProducts (Shelf shelf, long prodId) {
    	Long productInTheShelf = shelf.getProdutoId();
    	if (productInTheShelf == 0) {
    		Product prod = prodBus.get(prodId);
    		prod.addShelfId(shelf.getID());
    		shelf.setProdutoId(prodId);
    	} else {
    		prodId = shelf.getProdutoId();
    		Product prod = prodBus.get(prodId);
    		prod.removeShelfId(shelf.getID());
    		shelf.setProdutoId((long) 0);
    	}
	}
    	


}
    
	


