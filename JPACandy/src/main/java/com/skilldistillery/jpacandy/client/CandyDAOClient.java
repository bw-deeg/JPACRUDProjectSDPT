package com.skilldistillery.jpacandy.client;

import com.skilldistillery.jpacandy.data.CandyDAO;
import com.skilldistillery.jpacandy.data.CandyDAOImpl;
import com.skilldistillery.jpacandy.entities.Candy;

public class CandyDAOClient {

	public static void main(String[] args) {
		CandyDAO dao = new CandyDAOImpl();

		Candy myCandy = new Candy("malted milk balls", 100, "dissolves tastefully", true, 1.99);
		System.out.println("Before persist: " + myCandy);
		myCandy = dao.addCandy(myCandy);
		System.out.println("After persist: " + myCandy);
		System.out.println(dao.deleteCandy(myCandy.getId()));

		myCandy = new Candy("malted milk balls", 100, "dissolves tastefully", true, 1.99);
		myCandy = dao.addCandy(myCandy);
		System.out.println("Before update: " + myCandy);
		myCandy.setName("malted milk ball ice cream");
		System.out.println("changed: " + dao.updateCandy(myCandy));

	}
}
