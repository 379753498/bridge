package com.Wj.FactoryPattern;

public class PeopleFactory {

	public People getPeople(String country) {
		if (country.equals("China")) {
			return new ChinaPeople();
		}

		if (country.equals("Japan")) {
			return new JapanPeople();
		}
		if (country.equals("America")) {
			return new AmericaPeople();
		} else {

			throw new Error(country + "People不存在");

		}

	}

}
