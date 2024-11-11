package bean;
//1分类表 实体类
public class CATEGORY {

	private int Cate_id ;
	private String Cate_name ;
	private int Cate_parent_id ;
	
	//构造方法
	public CATEGORY(int cate_id, String cate_name, int cate_parent_id) {
		super();
		Cate_id = cate_id;
		Cate_name = cate_name;
		Cate_parent_id = cate_parent_id;
	}

	//get set方法
	public int getCate_id() {
		return Cate_id;
	}

	public void setCate_id(int cate_id) {
		Cate_id = cate_id;
	}

	public String getCate_name() {
		return Cate_name;
	}

	public void setCate_name(String cate_name) {
		Cate_name = cate_name;
	}

	public int getCate_parent_id() {
		return Cate_parent_id;
	}

	public void setCate_parent_id(int cate_parent_id) {
		Cate_parent_id = cate_parent_id;
	}
	
	
	
}
