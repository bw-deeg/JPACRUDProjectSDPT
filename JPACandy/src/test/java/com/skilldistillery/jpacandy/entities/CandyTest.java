package com.skilldistillery.jpacandy.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CandyTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	// entity under test
	private Candy candy = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("CandyStore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		candy = em.find(Candy.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		candy = null;
	}

	@Test
	void test_Candy_basic_mappings() {
		assertNotNull(candy);
		assertEquals("Gobstoppers", candy.getName());
	}

}
