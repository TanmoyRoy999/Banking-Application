package org.example;

import java.util.HashMap;
import java.util.Map;

public class AccountDirectory {

    private Map<String, Account> accounts;
    private static int accountNoCounter = 0;

    public AccountDirectory() {
        this.accounts = new HashMap<>();
    }

    public Account createAccount(String bankName, String accountHolderName) {
        String accountNo = bankName.substring(0, 3).toUpperCase() + (10000000 + accountNoCounter);
        Account account = new Account(bankName, accountHolderName, accountNo);
        accounts.put(accountNo, account);
        accountNoCounter++;
        System.out.println("New bank account created with account number " + accountNo);
        return account;
    }

    public void viewAccountDetails(String accountNo) {
        Account account = searchAccount(accountNo);
        if (account != null)
            System.out.println(account);
    }

    public Account searchAccount(String accountNo) {
        Account account = accounts.get(accountNo);
        if (account == null)
            System.out.println("No account found with this number!");
        return account;
    }

    public void viewAllAccounts() {
        System.out.println(accounts.values());
    }

    public void viewBalance(String accountNo) {
        Account account = searchAccount(accountNo);
        if (account != null)
            System.out.println("Balance is " + account.getBalance());
    }

    public boolean deposit(String accountNo, long depositAmount) {
        Account account = searchAccount(accountNo);
        if (account != null) {
            account.setBalance(account.getBalance() + depositAmount);
            System.out.println(depositAmount + " amount deposited in account number " + accountNo);
            return true;
        } else
            return false;
    }

    public boolean withdraw(String accountNo, long withdrawAmount) {
        Account account = searchAccount(accountNo);
        if (account != null) {
            if (account.getBalance() < withdrawAmount) {
                System.out.println("Balance not sufficient to withdraw!");
                return false;
            } else {
                account.setBalance(account.getBalance() - withdrawAmount);
                System.out.println(withdrawAmount + " amount withdrawn from account number " + accountNo);
                return true;
            }
        } else
            return false;
    }

    public boolean transfer(String withdrawAccNumber, String depositAccNumber, long transferAmt) {
        ;
        if (withdraw(withdrawAccNumber, transferAmt) && deposit(depositAccNumber, transferAmt)) {
            System.out.println(transferAmt + " amount transferred from account no " + withdrawAccNumber + " to account no " + depositAccNumber);
            return true;
        } else
            return false;
    }

    public Account deleteAccount(String accountNo) {
        Account account = searchAccount(accountNo);
        if (account != null) {
            accounts.remove(accountNo);
            System.out.println("Account number " + accountNo + " deleted!");
        }
        return account;
    }

}
