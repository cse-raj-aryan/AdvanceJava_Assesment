package com.capgemini.main;

//import com.assessment.entity.Employee;
import com.capgemini.assesment.*;

import javax.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory ef=Persistence.createEntityManagerFactory("EmployeePU");
        EntityManager em=ef.createEntityManager();
        EntityTransaction tx=em.getTransaction();

        try 
        {
            tx.begin();

            
            
            Employee emp = new Employee();
            emp.setName("John");
            emp.setEmail("john@example.com");


            
            IDCard card = new IDCard();
            card.setCardNumber("IDC101");
            card.setIssueDate(LocalDate.of(2026, 2, 14));

            
            
            
            emp.setIdCard(card);
            card.setEmployee(emp);
            em.persist(emp);

            
            
            
            tx.commit();
            System.out.println("Employee Created Successfully");

            
            
            Employee fetchedEmp = em.find(Employee.class, emp.getId());

            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + fetchedEmp.getId());
            System.out.println("Name: " + fetchedEmp.getName());
            System.out.println("Email: " + fetchedEmp.getEmail());

            System.out.println("\nID Card Details:");
            System.out.println("Card Number: " + fetchedEmp.getIdCard().getCardNumber());
            System.out.println("Issue Date: " + fetchedEmp.getIdCard().getIssueDate());

 
            
            IDCard fetchedCard = em.find(IDCard.class, card.getId());

            System.out.println("\nAssociated Employee:");
            System.out.println("Name: " + fetchedCard.getEmployee().getName());
            System.out.println("Email: " + fetchedCard.getEmployee().getEmail());

        } 
        
        
        
        catch (Exception e) 
        {
            if (tx.isActive()) 
            {
                tx.rollback();
            }
            e.printStackTrace();
        } 
        
        
        
        finally 
        {
            em.close();
            ef.close();
        }
    }
}
