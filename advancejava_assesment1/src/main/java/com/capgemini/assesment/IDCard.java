package com.capgemini.assesment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="id_card")
public class IDCard 
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="card_number",unique=true)
    private String cardNumber;
    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name="employee_id",unique=true)
    private Employee employee;

    public int getId() 
    {
        return id;
    }

    public String getCardNumber() 
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) 
    {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() 
    {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) 
    {
        this.issueDate = issueDate;
    }

    public Employee getEmployee() 
    {
        return employee;
    }

    public void setEmployee(Employee employee) 
    {
        this.employee = employee;
    }
}
