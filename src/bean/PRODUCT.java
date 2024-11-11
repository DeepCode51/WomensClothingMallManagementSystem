package bean;
//产品实体类
public class PRODUCT {
	private int Product_id ;
	private String Product_name ;
	private String Product_description  ;
	private int Product_price  ;
	private int Product_stock  ;
	private int Product_fid  ;
	private int Product_cid  ;
	private String Product_filename ;
	
	//创建构造方法
	public PRODUCT(int product_id, String product_name,
			String product_description, int product_price, int product_stock,
			int product_fid, int product_cid, String product_filename) {
		super();
		Product_id = product_id;
		Product_name = product_name;
		Product_description = product_description;
		Product_price = product_price;
		Product_stock = product_stock;
		Product_fid = product_fid;
		Product_cid = product_cid;
		Product_filename = product_filename;
	}

	//get set方法
	public int getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public String getProduct_description() {
		return Product_description;
	}

	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}

	public int getProduct_price() {
		return Product_price;
	}

	public void setProduct_price(int product_price) {
		Product_price = product_price;
	}

	public int getProduct_stock() {
		return Product_stock;
	}

	public void setProduct_stock(int product_stock) {
		Product_stock = product_stock;
	}

	public int getProduct_fid() {
		return Product_fid;
	}

	public void setProduct_fid(int product_fid) {
		Product_fid = product_fid;
	}

	public int getProduct_cid() {
		return Product_cid;
	}

	public void setProduct_cid(int product_cid) {
		Product_cid = product_cid;
	}

	public String getProduct_filename() {
		return Product_filename;
	}

	public void setProduct_filename(String product_filename) {
		Product_filename = product_filename;
	}
	

	
	
}
