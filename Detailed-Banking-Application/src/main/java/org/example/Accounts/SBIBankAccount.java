package org.example.Accounts;

public class SBIBankAccount extends BankAccount {

    public SBIBankAccount(String accountHolderName, String accountNo, long openingBalance) {
        super(accountHolderName,accountNo,openingBalance,2000,"SBI");
    }

}
