package com.niceben.projecttest.java8.map;

import com.niceben.projecttest.java8.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    @BeforeEach
    public void init() {

    }

    @Test
    public void testMap() {
        orderMethod();

        newMethod();
    }

    private void newMethod() {
        List<Payment> payments = getPayments();
        Map<Integer, List<Payment>> paymentByTypeMap = new HashMap<>();
        for(Payment payment : payments){
            paymentByTypeMap.computeIfAbsent(payment.getPayTypeId(), k -> new ArrayList<>())
                    .add(payment);
        }
    }

    private void orderMethod() {
        List<Payment> payments = getPayments();
        Map<Integer, List<Payment>> paymentByTypeMap = new HashMap<>();
        for(Payment payment : payments){
            if(!paymentByTypeMap.containsKey(payment.getPayTypeId())){
                paymentByTypeMap.put(payment.getPayTypeId(), new ArrayList<>());
            }
            paymentByTypeMap.get(payment.getPayTypeId())
                    .add(payment);
        }
    }

    private List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1));
        payments.add(new Payment(2));
        payments.add(new Payment(3));
        return payments;
    }
}
