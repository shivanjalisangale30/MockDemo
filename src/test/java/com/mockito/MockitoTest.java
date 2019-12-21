package com.mockito;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class MockitoTest {

    @Mock
    MyDataBase dataBaseMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void tsetQuery() {
        ClassToTest t = new ClassToTest(dataBaseMock);
        when(dataBaseMock.query("* from t")).thenReturn(true);
        boolean check = t.query("* from t");
        Assert.assertTrue(check);
    }

    @Test
    public void customerReaderTest() {
        Customer customer = new Customer("Susan","Ivanova");
        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Customer.class,1L)).thenReturn(customer);
        CustomerReader customerReader = new CustomerReader();
        customerReader.setEntityManager(entityManager);
        String fullName = customerReader.findFullName(1L);
        Assert.assertEquals("Susan Ivanova",fullName);
    }
}
