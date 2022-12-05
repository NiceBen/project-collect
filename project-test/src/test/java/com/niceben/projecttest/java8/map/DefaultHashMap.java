package com.niceben.projecttest.java8.map;

import com.niceben.projecttest.java8.model.Payment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class DefaultHashMap<K, V> extends HashMap<K,V> {
    Function<K, V> function;

    public DefaultHashMap(Supplier<V> supplier) {
        this.function = k -> supplier.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        return super.computeIfAbsent((K) key, this.function);
    }

    public static void main(String[] args) {
        List<Payment> payments = getPayments();
        DefaultHashMap<Integer, ArrayList<Payment>> paymentByTypeMap = new DefaultHashMap<>(ArrayList::new);
        for (Payment payment : payments) {
            paymentByTypeMap.get(payment.getPayTypeId())
                    .add(payment);
        }

    }

    private static List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1));
        payments.add(new Payment(2));
        payments.add(new Payment(3));
        return payments;
    }
}
