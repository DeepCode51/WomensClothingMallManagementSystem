package bean;

public class Orderitem {
	private int iid;
	private int oid;
	private int Product_id;
	private int quantity;
	private int cost;
	public Orderitem(int iid, int oid, int product_id, int quantity, int cost) {
		super();
		this.iid = iid;
		this.oid = oid;
		Product_id = product_id;
		this.quantity = quantity;
		this.cost = cost;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}