package com.skilldistillery.bootcandy.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacandy.entities.Candy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CandyDAOImpl implements CandyDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Candy findById(int id) {
		Candy candy = em.find(Candy.class, id);
		return candy;
	}
	
	@Override
	public Candy addCandy(Candy candy) {
		em.getTransaction().begin();
		em.persist(candy);
		em.getTransaction().commit();
		return candy;
	}

	@Override
	public boolean deleteCandy(int id) {
		boolean wasDeleted = false;
		
		Candy candy = em.find(Candy.class, id);
		if (candy != null) {
			
			em.remove(candy);
			wasDeleted = true;
		}
		
		wasDeleted = !em.contains(candy);
		
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
