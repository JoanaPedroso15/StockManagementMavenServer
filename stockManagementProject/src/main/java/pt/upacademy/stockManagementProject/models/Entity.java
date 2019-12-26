package pt.upacademy.stockManagementProject.models;

public class Entity {
	private Long ID;

	public Entity() {
	}

	public Entity(Long iD) {
		ID = iD;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Entity [ID=" + ID + "]";
	}
	

}
