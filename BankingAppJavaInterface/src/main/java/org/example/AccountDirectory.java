package org.example;

import org.example.Accounts.BankAccount;
import org.example.Accounts.HDFCBankAccount;
import org.example.Accounts.SBIBankAccount;
import org.example.Accounts.UBIBankAccount;

import java.util.HashMap;
import java.util.Map;

public class AccountDirectory {

    private Map<String, BankAccount> accounts;
    private static int accountNoCounter = 0;

    public AccountDirectory() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createAccount(String bankName, String accountHolderName, long openingBalance) {

        String accountNo = bankName.substring(0,3).toUpperCase() + (10000000 + accountNoCounter);
        BankAccount bankAccount;

        switch (bankName.toUpperCase()) {

            case "SBI" -> {
                bankAccount = new SBIBankAccount(accountHolderName, accountNo, openingBalance);
            }
            case "UBI" -> {
                bankAccount = new UBIBankAccount(accountHolderName, accountNo, openingBalance);
            }
            case "HDFC" -> {
                bankAccount = new HDFCBankAccount(accountHolderName, accountNo, openingBalance);
            }
            default -> {
                System.out.println("Invalid bank name!");
                return null;
            }
        }

        accounts.put(accountNo, bankAccount);
        accountNoCounter++;
        System.out.println("New bank account created with account number " + accountNo);
        return bankAccount;
    }

    public void viewAccountDetails(String accountNo) {
        BankAccount bankAccount = searchAccount(accountNo);
        if (bankAccount != null)
            System.out.println(bankAccount);
    }

    public BankAccount searchAccount(String accountNo) {
        BankAccount bankAccount = accounts.get(accountNo);
        if (bankAccount == null)
            System.out.println("No bank account found with number " + accountNo + "!");
        return bankAccount;
    }

    public void viewAllAccounts() {
        System.out.println(accounts.values());
    }

    public void viewBalance(String accountNo) {
        BankAccount bankAccount = searchAccount(accountNo);
        if (bankAccount != null)
            System.out.println("Balance is " + bankAccount.getBalance());
    }

    public void deposit(String accountNo, long depositAmount) {
        BankAccount bankAccount = searchAccount(accountNo);
        if (bankAccount != null)
            bankAccount.deposit(depositAmount);
    }

    public void withdraw(String accountNo, long withdrawAmount) {
        BankAccount bankAccount = searchAccount(accountNo);
        if (bankAccount != null)
            bankAccount.withdraw(withdrawAmount);
    }

    public void transfer(String withdrawAccNumber, String depositAccNumber, long transferAmount) {
        BankAccount withdrawAccount = searchAccount(withdrawAccNumber);
        BankAccount depositAccount = searchAccount(depositAccNumber);

        if (withdrawAccount != null && depositAccount != null)
            withdrawAccount.transferTo(depositAccount, transferAmount);
    }

    public BankAccount deleteAccount(String accountNo) {
        BankAccount bankAccount = searchAccount(accountNo);
        if (bankAccount != null) {
            accounts.remove(accountNo);
            System.out.println("Account number "+accountNo+" deleted!");
        }
        return bankAccount;
    }

}
