package com.mockito;

public class CustomerReader {
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String  findFullName(long id) {
        Customer customer = this.entityManager.find(Customer.class, 1L);
        return customer.fname + " "+ customer.lname;
    }
}
