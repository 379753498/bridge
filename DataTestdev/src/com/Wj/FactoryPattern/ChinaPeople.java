package com.Wj.FactoryPattern;  
  
public class ChinaPeople implements People {

	@Override
	public void eat() {

		System.out.println("This is China people eat method!");
	}

	@Override
	public void red() {
	
		System.out.println("This is China people red method!");
	}

}
