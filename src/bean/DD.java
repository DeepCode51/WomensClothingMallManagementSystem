package bean;

public class DD {
	public DD(String product_name, String product_filename, int product_price, int quantity, int product_stock,
			String size) {
		super();
		Product_name = product_name;
		this.product_filename = product_filename;
		Product_price = product_price;
		this.quantity = quantity;
		Product_stock = product_stock;
		this.size = size;
	}
	private String Product_name;
	private String product_filename;
	private int Product_price;
	private int quantity;
	private int Product_stock;
	private String size;
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_filename() {
		return product_filename;
	}
	public void setProduct_filename(String product_filename) {
		this.product_filename = product_filename;
	}
	public int getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(int product_price) {
		Product_price = product_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProduct_stock() {
		return Product_stock;
	}
	public void setProduct_stock(int product_stock) {
		Product_stock = product_stock;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}