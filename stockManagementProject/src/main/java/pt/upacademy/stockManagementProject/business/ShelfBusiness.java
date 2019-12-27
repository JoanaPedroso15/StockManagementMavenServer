package pt.upacademy.stockManagementProject.business;



import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import pt.upacademy.stockManagementProject.models.Product;
import pt.upacademy.stockManagementProject.models.Shelf;                   
import pt.upacademy.stockManagementProject.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements ShelfBusinessInterface {
	
	  
	public static final ProductBusiness prodBus = new ProductBusiness ();
	
	public ShelfBusiness () { 
		repository = ShelfRepository.getShelfInstance ();	
		}

	@Override
	public long save(Shelf shelf) throws Exception {
		long idProduto = shelf.getProdutoId();
		Collection <Long> listProdIds = prodBus.getAllIds();
		if (idProduto != 0) {
			if (listProdIds.isEmpty()) throw new Exception ("Ainda nao ha produtos criados");
			if (!listProdIds.contains(idProduto)) throw new Exception ("Ainda nao existe um produto com esse ID");
		}
		repository.createEnt (shelf);
	    return shelf.getID();
	}

	@Override
	public void update(Shelf shelf) throws Exception {
		Long productId = productsWithShelf (shelf.getID());
		if (productId != -1) {
		alterarProducts(shelf, productId, false);
		}
		Collection <Long> listProdIds = prodBus.getAllIds();
		if (shelf.getProdutoId() != 0) {
			if (listProdIds.isEmpty()) throw new Exception ("Ainda nao ha produtos criados");
			if (!listProdIds.contains(shelf.getProdutoId())) throw new Exception ("Ainda nao existe um produto com esse ID");
		}
		repository.editEntity(shelf);

	}

	@Override
	public void delete(long id) { 
		Long productId = productsWithShelf (id);
		if (productId != -1) {
		alterarProducts(repository.consultEntity(id), productId, true);
		}
		repository.removeEntity(id);
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
		
	public void alterarProducts (Shelf shelf, long prodId, boolean isRemove) {
    	Long productInTheShelf = shelf.getProdutoId();
    	if (productInTheShelf == 0) {
    		Product prod = prodBus.get(prodId);
    		prod.addShelfId(shelf.getID());
    		shelf.setProdutoId(prodId);
    	} else {
    		prodId = shelf.getProdutoId();
    		Product prod = prodBus.get(prodId);
    		prod.removeShelfId(shelf.getID());
    		if (!isRemove) {
    			shelf.setProdutoId(prodId);
    		}
    		
    	}
	}
    	


}
    
	


