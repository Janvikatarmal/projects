package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.AadharCard;
import com.jspiders.hibernate.dto.Person;

public class PersonDAO3 {
	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
public static void main(String[] args) {
	openConnection();
Person person = entityManager.find(Person.class, 5);
if(person!= null)
{
	AadharCard aadharCard = person.getAadharCard();
	entityTransaction.begin();
	entityManager.remove(person);
	entityManager.remove(aadharCard);
	entityTransaction.commit();
}else
 System.out.println("User not found");
	closeConnetion();
}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction =entityManager.getTransaction();
		
	}
	private static void closeConnetion() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
		
		
	}

}
