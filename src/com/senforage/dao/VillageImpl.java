package com.senforage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senforage.entities.Village;

public class VillageImpl implements IVillage {

	private EntityManager em;
	
	public VillageImpl() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenForageClientPU");
		em = emf.createEntityManager();
	}
	@Override
	public int add(Village village) {
		try {
			em.getTransaction().begin();
			em.persist(village);
			em.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public List<Village> list() {
		
		return em.createQuery("SELECT v FROM Village v").getResultList();
	} 
	
	
}
