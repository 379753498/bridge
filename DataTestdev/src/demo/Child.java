package demo;  
  
public class Child extends Parent {


	private String like;
	Child()
	{
		System.out.println("孩子构造方法被调用");
	}
	public String getLike() {
		
		return like;
	}

	
	public void setSex(String Sex) {
		System.out.println("我是孩子的set方法");
	}
	public void setLike(String like) {
		this.like = like;
		System.out.println("我是孩子");
	}
	
}
