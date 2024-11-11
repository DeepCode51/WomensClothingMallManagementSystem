package bean;
//用户表 实体类
public class USER {
	private String User_id ;
	private String User_name ;
	private String User_pwd ;
	private String User_sex ;
	private String User_birth ;
	private String User_idenity ;
	private String User_email ;
	private String User_phone ;
	private String User_address ;
	private int    User_status ;

	//构造方法
	public USER(String user_id, String user_name, String user_pwd,
			String user_sex, String user_birth, String user_idenity,
			String user_email, String user_phone, String user_address,
			int user_status) {
		super();
		User_id = user_id;
		User_name = user_name;
		User_pwd = user_pwd;
		User_sex = user_sex;
		User_birth = user_birth;
		User_idenity = user_idenity;
		User_email = user_email;
		User_phone = user_phone;
		User_address = user_address;
		User_status = user_status;
	}

	//set get方法（右键source）
	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getUser_pwd() {
		return User_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		User_pwd = user_pwd;
	}

	public String getUser_sex() {
		return User_sex;
	}

	public void setUser_sex(String user_sex) {
		User_sex = user_sex;
	}

	public String getUser_birth() {
		return User_birth;
	}

	public void setUser_birth(String user_birth) {
		User_birth = user_birth;
	}

	public String getUser_idenity() {
		return User_idenity;
	}

	public void setUser_idenity(String user_idenity) {
		User_idenity = user_idenity;
	}

	public String getUser_email() {
		return User_email;
	}

	public void setUser_email(String user_email) {
		User_email = user_email;
	}

	public String getUser_phone() {
		return User_phone;
	}

	public void setUser_phone(String user_phone) {
		User_phone = user_phone;
	}

	public String getUser_address() {
		return User_address;
	}

	public void setUser_address(String user_address) {
		User_address = user_address;
	}

	public int getUser_status() {
		return User_status;
	}

	public void setUser_status(int user_status) {
		User_status = user_status;
	}
	
	
	
}
