package pt.upacademy.stockManagementProject.business;
import pt.upacademy.stockManagementProject.models.Shelf;
import pt.upacademy.stockManagementProject.repositories.ShelfRepository;

public interface ShelfBusinessInterface extends EntityBusinessInterface<Shelf> {

	
	void alterarProducts (Shelf shelf, long prodId, boolean isRemove);
}
