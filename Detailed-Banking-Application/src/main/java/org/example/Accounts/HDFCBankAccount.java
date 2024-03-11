package org.example.Accounts;

public class HDFCBankAccount extends BankAccount {

    public HDFCBankAccount(String accountHolderName, String accountNo, long openingBalance) {
        super(accountHolderName,accountNo,openingBalance,3000,"HDFC");
    }

}
