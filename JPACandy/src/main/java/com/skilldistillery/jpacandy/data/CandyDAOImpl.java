package com.skilldistillery.jpacandy.data;

import com.skilldistillery.jpacandy.entities.Candy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CandyDAOImpl implements CandyDAO {
	private static final EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("CandyStore");
	
	@Override
	public Candy addCandy(Candy candy) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(candy);
		em.getTransaction().commit();
		
		em.close();
		return candy;
	}

	@Override
	public boolean deleteCandy(int id) {
		boolean wasDeleted = false;
		EntityManager em = emf.createEntityManager();
		
		Candy candy = em.find(Candy.class, id);
		if (candy != null) {
			em.getTransaction().begin();
			
			em.remove(candy);
			wasDeleted = true;
			em.getTransaction().commit();
		}
		
		wasDeleted = !em.contains(candy);
		
		em.close();
		return wasDeleted;
	}

	@Override
	public Candy updateCandy(Candy candy, int...id) {
		String jpql = "UPDATE Candy candy "
				+     "SET  candy.name = :name "
				+     "    ,candy.calories = :cals "
				+     "    ,candy.description = :descr "
				+     "    ,candy.available = :yesNo "
				+     "WHERE candy.id = :id"
				;
		EntityManager em = emf.createEntityManager();
//		System.out.println(id[0]);
		
		em.getTransaction().begin();
		
		int numRowsUpdated = em.createQuery(jpql)
			  .setParameter("name", candy.getName())
			  .setParameter("cals", candy.getCalories())
			  .setParameter("descr", candy.getDescription())
			  .setParameter("yesNo", candy.getAvailable())
			  .setParameter("id", candy.getId())
			.executeUpdate();
		
		em.getTransaction().commit();
		em.close();
		return candy;
	}

}
