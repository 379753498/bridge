package com.zeone.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class test {

	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//		Class c2= Class.forName("com.zeone.Maths.Maths");//
//		
//		Maths math =new Maths();
//		Maths m=	(Maths) c2.newInstance();
//		ArrayList<String> a= new ArrayList<String>();
//		a.add("aa");
//		a.add("bb");
//		
//		System.out.println(m.getsize(a));
		
		
		
		 ArrayList<Integer> list = new ArrayList<Integer>();
	        Method method = list.getClass().getMethod("add", Object.class);
	        method.invoke(list, "Java反射机制实例。");
	        method.invoke(list, "Java反射机制实例1。");
	        method.invoke(list, "Java反射机制实例。");
	        method.invoke(list, "Java反射机制实例。");
	        System.out.println(list.get(1));
	        ArrayList<Integer> list1 = new ArrayList<Integer>();
	        list1.add(1);
	        list1.add(2);
	        ArrayList   list2 = list1;
	        list2.add("heeeeee");
       
	        System.out.println(list2.get(0));
	        System.out.println(list2.get(2));

	}
}
