package org.example.Accounts;

public interface BankAccount {

    public String getAccountNo();
    public long getBalance();
    public boolean deposit(long depositAmt);
    public boolean withdraw(long withdrawAmt);
    public boolean transferTo(BankAccount bankAccount, long transferAmt);

}
