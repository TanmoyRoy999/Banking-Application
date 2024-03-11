package org.example.Accounts;

public class BankAccount implements Comparable<BankAccount> {

    private final String bankName;
    private final long minBalance;
    private String accountHolderName;
    private String accountNo;
    private long currentBalance;
    private long totalTransactionValue;  // total amount of money transacted through deposit, withdraw or transfer

    public BankAccount(String accountHolderName, String accountNo, long openingBalance, long minBalance, String bankName) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        if (openingBalance < minBalance) {
            this.currentBalance = minBalance;
            System.out.println("Opening balance less than min balance, hence opening balance set to min balance!");
        } else
            this.currentBalance = openingBalance;
        totalTransactionValue = 0;
        this.minBalance=minBalance;
        this.bankName=bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public long getMinBalance() {
        return minBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    public boolean deposit(long depositAmt) {
        this.currentBalance += depositAmt;
        this.totalTransactionValue += depositAmt;
        System.out.println(depositAmt + " amount deposited in account no " + this.accountNo);
        return true;
    }

    public boolean withdraw(long withdrawAmt) {
        if ((this.currentBalance - withdrawAmt) < minBalance) {
            System.out.println("Balance not sufficient to withdraw!");
            return false;
        } else {
            this.currentBalance -= withdrawAmt;
            this.totalTransactionValue += withdrawAmt;
            System.out.println(withdrawAmt + " amount withdrawn from account no " + this.accountNo);
            return true;
        }
    }

    public boolean transferTo(BankAccount bankAccount, long transferAmt) {
        if (withdraw(transferAmt) && bankAccount.deposit(transferAmt)) {
            System.out.println(transferAmt + " amount transferred from account no " + this.accountNo + " to account no " + bankAccount.getAccountNo());
            return true;
        } else
            return false;
    }

    @Override
    public int compareTo(BankAccount bankAccount) {
        int numSign = Long.signum(this.getTotalTransactionValue() - bankAccount.getTotalTransactionValue());

        switch (numSign) {
            case 0 -> {
                return this.getAccountNo().compareTo(bankAccount.getAccountNo());
            }
            case -1 -> {
                return 1;
            }
            case 1 -> {
                return -1;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankName=" + bankName +
                ", accountHolderName=" + accountHolderName +
                ", accountNo=" + accountNo +
                ", currentBalance=" + currentBalance +
                ", totalTransactionValue=" + totalTransactionValue +
                '}';
    }
}
