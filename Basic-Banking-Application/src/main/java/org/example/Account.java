package org.example;

public class Account {

    private String bankName;
    private String accountHolderName;
    private String accountNo;
    private long balance;

    public Account(String bankName, String accountHolderName, String accountNo) {
        this.bankName = bankName.toUpperCase();
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
//        this.accountNo = (long) Math.floor(Math.random() * 90000000000L) + 10000000000L;
        this.balance=0;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankName='" + bankName + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber=" + accountNo +
                ", balance=" + balance +
                '}';
    }
}
