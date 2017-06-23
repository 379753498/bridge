package com.Wj.FactoryPattern;  
  

/**
 * 我们将创建一个 People 接口和实现 People 接口的实体类。下一步是定义工厂类 PeopleFactory。
FactoryPatternDemo，我们的演示类使用 PeopleFactory 来获取 People 对象。它将向 PeopleFactory 传递信息（CIRCLE / RECTANGLE / SQUARE），以便获取它所需对象的类型。
 *@Title:  
 *@Description:  
 *@Author:Administrator  
 *@Since:2017年6月23日  
 *@Version:1.1.0
 */

public interface People {
	
	 void eat();
	 void red();
}
