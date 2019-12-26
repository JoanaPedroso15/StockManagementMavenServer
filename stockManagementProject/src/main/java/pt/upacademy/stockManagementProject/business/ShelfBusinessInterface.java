package pt.upacademy.stockManagementProject.business;
import pt.upacademy.stockManagementProject.models.Shelf;
import pt.upacademy.stockManagementProject.repositories.ShelfRepository;

public interface ShelfBusinessInterface extends EntityBusinessInterface<Shelf> {
	
	static final ShelfRepository shelfRep = ShelfRepository.getShelfInstance();

	//void updateArrayShelvesProduct(long productId, Shelf shelf);
	void alterarProducts (Shelf shelf, long prodId);
}
