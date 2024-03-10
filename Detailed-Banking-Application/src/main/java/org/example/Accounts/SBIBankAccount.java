package org.example.Accounts;

public class SBIBankAccount implements BankAccount {

    private static final String bankName = "SBI";
    private static final long minBalance = 3000L;
    private String accountHolderName;
    private String accountNo;
    private long currentBalance;

    public SBIBankAccount(String accountHolderName, String accountNo, long openingBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        if (openingBalance < minBalance) {
            this.currentBalance = minBalance;
            System.out.println("Opening balance less than min balance, hence opening balance set to min balance!");
        } else
            this.currentBalance = openingBalance;
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
    public boolean deposit(long depositAmt) {
        this.currentBalance += depositAmt;
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
        return "SBIBankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
