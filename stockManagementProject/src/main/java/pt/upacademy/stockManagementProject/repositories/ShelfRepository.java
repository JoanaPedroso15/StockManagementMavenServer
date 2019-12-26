package pt.upacademy.stockManagementProject.repositories;


import pt.upacademy.stockManagementProject.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>  {
	private static final ShelfRepository instance = new ShelfRepository();
	
	private ShelfRepository() {
		
	}

	public static ShelfRepository getShelfInstance () {
		return instance;
	}

}
