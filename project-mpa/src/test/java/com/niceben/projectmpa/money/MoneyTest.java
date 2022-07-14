package com.niceben.projectmpa.money;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

@ExtendWith({SpringExtension.class})
public class MoneyTest {

    @Test
    public void testCreateMoney() {
        CurrencyUnit cny = Monetary.getCurrency("CNY");
        Money money = Money.of(1.0, cny);
        // 或者 Money money = Money.of(1.0, "CNY");
        System.out.println(money);
    }

    @Test
    public void testExeMoney() {
        CurrencyUnit cny = Monetary.getCurrency("CNY");
        Money oneYuan = Money.of(1.0, cny);
        Money threeYuan = oneYuan.add(Money.of(2.0, "CNY"));
        Money tenYuan = oneYuan.multiply(10);
        Money fiveFen = oneYuan.divide(2);
    }

    @Test
    public void testEqualsMoney() {
        Money fiveFen = Money.of(0.5, "CNY");
        Money anotherFiveFen = Money.of(0.50, "CNY");
        Assert.isTrue(fiveFen.equals(anotherFiveFen), "fiveFen 与 anotherFiveFen 之间比较不相等");
    }
}
