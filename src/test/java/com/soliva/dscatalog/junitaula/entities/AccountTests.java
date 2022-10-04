package com.soliva.dscatalog.junitaula.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//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
public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        // Arrange = Instancie os objetos necessários
        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = AccountFactory.createEmptyAccount();

        // Act = Execute as ações necessárias
        acc.deposit(amount);

        // Assert = declare o que deveria acontecer ( Resultado esperado )
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0;
        Account acc = AccountFactory.createEmptyAccount(expectedValue);

        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalance() {

        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createEmptyAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

        Account acc = AccountFactory.createEmptyAccount(800.0);

        acc.withdraw(500.0);

        Assertions.assertEquals(300.0, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createEmptyAccount(800.0);

            acc.withdraw(801.0);
        });
    }
}
