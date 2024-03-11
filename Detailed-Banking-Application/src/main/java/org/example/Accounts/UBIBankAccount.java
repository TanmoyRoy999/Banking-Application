package org.example.Accounts;

public class UBIBankAccount implements BankAccount {

    private static final String bankName = "UBI";
    private static final long minBalance = 2000L;
    private String accountHolderName;
    private String accountNo;
    private long currentBalance;
    private long totalTransactionValue;  // total amount of money transacted through deposit, withdraw or transfer

    public UBIBankAccount(String accountHolderName, String accountNo, long openingBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        if (openingBalance < minBalance) {
            this.currentBalance = minBalance;
            System.out.println("Opening balance less than min balance, hence opening balance set to min balance!");
        } else
            this.currentBalance = openingBalance;
        totalTransactionValue = 0;
    }

    @Override
    public String getAccountNo() {
        return this.accountNo;
    }

    @Override
    public long getBalance() {
        return this.currentBalance;
    }

    @Override
    public long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    @Override
    public boolean deposit(long depositAmt) {
        this.currentBalance += depositAmt;
        this.totalTransactionValue += depositAmt;
        System.out.println(depositAmt + " amount deposited in account no " + this.accountNo);
        return true;
    }

    @Override
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

    @Override
    public boolean transferTo(BankAccount bankAccount, long transferAmt) {
        if (withdraw(transferAmt) && bankAccount.deposit(transferAmt)) {
            System.out.println(transferAmt + " amount transferred from account no " + this.accountNo + " to account no " + bankAccount.getAccountNo());
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return "UBIBankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", currentBalance=" + currentBalance +
                ", totalTransactionValue=" + totalTransactionValue +
                '}';
    }

    @Override
    public int compareTo(BankAccount bankAccount) {
        int numSign = Long.signum(this.totalTransactionValue - bankAccount.getTotalTransactionValue());

        switch (numSign) {
            case 0 -> {
                return this.accountNo.compareTo(bankAccount.getAccountNo());
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
}
