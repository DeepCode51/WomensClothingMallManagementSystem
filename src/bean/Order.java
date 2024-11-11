package bean;

public class Order {
	public Order(int oid, String uid, String uname, String uaddress, String uphone, String createtime, int cost,
			int status, String size) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.uphone = uphone;
		this.createtime = createtime;
		this.cost = cost;
		this.status = status;
		this.size = size;
	}

	private int oid;
	private String uid;
	private String uname;
	private String uaddress;
	private String uphone;
	private String createtime;
	private int cost;
	private int status;
	private String size;
	
	public String getOrderStatusStr(){
		if(this.status==1){
			return "待发货";
		}else if(this.status==2){
			return "发货";
		}else{
			return "确认收货";
		}
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}