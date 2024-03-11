package org.example.Accounts;

public class UBIBankAccount extends BankAccount {

    public UBIBankAccount(String accountHolderName, String accountNo, long openingBalance) {
        super(accountHolderName,accountNo,openingBalance,3000,"UBI");
    }

}
