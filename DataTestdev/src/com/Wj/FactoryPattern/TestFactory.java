package com.Wj.FactoryPattern;  
  
public class TestFactory {
	
	
	public static void main(String[] args) {
		
		
		PeopleFactory PeopleFactory =new PeopleFactory();
		String china="China";
		String Japan="Japan";
		String America="America";
		
		People chinapeople =PeopleFactory.getPeople(china);
		chinapeople.eat();
		chinapeople.red();
		People Japanpeople =PeopleFactory.getPeople(Japan);
		Japanpeople.eat();
		Japanpeople.red();
		
		People Americapeople =PeopleFactory.getPeople(America);
		Americapeople.eat();
		Americapeople.red();
		
		People anone =PeopleFactory.getPeople("anone");
		anone.eat();
		anone.red();
		
	}
	
}
