package demo;  
  
public class Parent {

	private int age;
	
	private String sex;
	Parent()
	{
		System.out.println("父亲构造方法被调用");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		System.out.println("我是父亲的SET方法");
		this.sex = sex;
	}
}
