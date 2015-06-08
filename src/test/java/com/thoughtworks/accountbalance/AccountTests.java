package com.thoughtworks.accountbalance;

import com.thoughtworks.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account account;
    @Before
    public void setup(){
        account = new Account(100);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        // action
        account.deposit(50);

        // assert
        assertThat(account.balance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        // action
        account.withdraw(50);

        // assert
        assertThat(account.balance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        //action
        account.withdraw(50);
        account.withdraw(100);
        //assert
        assertThat(account.balance(), is(50));
    }
}
