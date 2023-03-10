package org.example.tests.entities;

import org.example.entities.Account;
import org.example.tests.factory.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){

        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
    @Test
    public void fullWithdramShouldClearBalanceAndReturnFullBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }
    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
        Account acc = AccountFactory.createAccount(800.0);

        acc.withdram(500.00);

        Assertions.assertEquals(300.0, acc.getBalance());
    }
    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdram(801.0);
        });
    }
}
