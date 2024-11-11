package bean;

public class CART {
	public CART(int cart_id, String cart_p_filename, String cart_p_name, int cart_p_price, int cart_quantity,
			int cart_p_stock, String cart_p_size, int cart_p_id, String cart_u_id, int cart_valid) {
		super();
		Cart_id = cart_id;
		Cart_p_filename = cart_p_filename;
		Cart_p_name = cart_p_name;
		Cart_p_price = cart_p_price;
		Cart_quantity = cart_quantity;
		Cart_p_stock = cart_p_stock;
		Cart_p_size = cart_p_size;
		Cart_p_id = cart_p_id;
		Cart_u_id = cart_u_id;
		Cart_valid = cart_valid;
	}
	public int Cart_id;
	public String Cart_p_filename;
	public String Cart_p_name;
	public int Cart_p_price;
	public int Cart_quantity;
	public int Cart_p_stock;
	public String Cart_p_size;
	public int Cart_p_id;
	public String Cart_u_id;
	public int Cart_valid;
	public int getCart_id() {
		return Cart_id;
	}
	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}
	public String getCart_p_filename() {
		return Cart_p_filename;
	}
	public void setCart_p_filename(String cart_p_filename) {
		Cart_p_filename = cart_p_filename;
	}
	public String getCart_p_name() {
		return Cart_p_name;
	}
	public void setCart_p_name(String cart_p_name) {
		Cart_p_name = cart_p_name;
	}
	public int getCart_p_price() {
		return Cart_p_price;
	}
	public void setCart_p_price(int cart_p_price) {
		Cart_p_price = cart_p_price;
	}
	public int getCart_quantity() {
		return Cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		Cart_quantity = cart_quantity;
	}
	public int getCart_p_stock() {
		return Cart_p_stock;
	}
	public void setCart_p_stock(int cart_p_stock) {
		Cart_p_stock = cart_p_stock;
	}
	public String getCart_p_size() {
		return Cart_p_size;
	}
	public void setCart_p_size(String cart_p_size) {
		Cart_p_size = cart_p_size;
	}
	public int getCart_p_id() {
		return Cart_p_id;
	}
	public void setCart_p_id(int cart_p_id) {
		Cart_p_id = cart_p_id;
	}
	public String getCart_u_id() {
		return Cart_u_id;
	}
	public void setCart_u_id(String cart_u_id) {
		Cart_u_id = cart_u_id;
	}
	public int getCart_valid() {
		return Cart_valid;
	}
	public void setCart_valid(int cart_valid) {
		Cart_valid = cart_valid;
	}
	
}