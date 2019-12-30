package pt.upacademy.stockManagementProject.models;

public class Shelf extends Entity {
	private int capacidade;
	private long produtoId;
	private float dailyPrice;
	


public Shelf() {

	}


public Shelf(int capacidade, long produtoId, float dailyPrice) {
		this.capacidade = capacidade;
		this.produtoId = produtoId;
		this.dailyPrice = dailyPrice;
	}


public Shelf(int capacidade, float dailyPrice) {
	this.capacidade = capacidade;
	this.dailyPrice = dailyPrice;
}


	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}
	public float getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	
@Override
	public String toString() {
		return "Prateleira ID: " + this.getID() + "\n Capacidade:" + capacidade + "\n IDProduto: " + produtoId + "\n Preco Diario:"
				+ dailyPrice;
	}	
	
public static String getName() {
	return "Shelf";
}
	
	
}





