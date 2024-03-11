package org.example.Accounts;

public interface BankAccount extends Comparable<BankAccount> {

    public String getAccountNo();
    public long getBalance();
    public long getTotalTransactionValue();
    public boolean deposit(long depositAmt);
    public boolean withdraw(long withdrawAmt);
    public boolean transferTo(BankAccount bankAccount, long transferAmt);

}
