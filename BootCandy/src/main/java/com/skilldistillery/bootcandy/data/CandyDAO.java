package com.skilldistillery.bootcandy.data;

import com.skilldistillery.jpacandy.entities.Candy;

public interface CandyDAO {
	Candy addCandy(Candy candy);
	boolean deleteCandy(int id);
	Candy updateCandy(Candy candy, int...id);
	Candy findById(int id);
}
