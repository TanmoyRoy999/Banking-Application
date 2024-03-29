package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice=0;
        AccountDirectory accountDirectory = new AccountDirectory();

        while (choice!=10) {

            System.out.println("--Menu--");
            System.out.println("1: Create account");
            System.out.println("2: View account details");
            System.out.println("3: View account balance");
            System.out.println("4: View all accounts");
            System.out.println("5: Deposit money");
            System.out.println("6: Withdraw money");
            System.out.println("7: Transfer money");
            System.out.println("8: Delete account");
            System.out.println("9: View accounts with highest transaction values (sorted by ascending account no if transaction value is same)");
            System.out.println("10: Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct choice!");
                continue;
            }

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter bank name: ");
                    String bankName = sc.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accHolderName = sc.nextLine();
                    System.out.print("Enter opening balance: ");
                    long openingBalance = Long.valueOf(sc.nextLine());
                    accountDirectory.createAccount(bankName, accHolderName,openingBalance);
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    accountDirectory.viewAccountDetails(accountNumber);
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    accountDirectory.viewBalance(accountNumber);
                }
                case 4 -> {
                    accountDirectory.viewAllAccounts();
                }
                case 5 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    long deposit = Long.valueOf(sc.nextLine());
                    accountDirectory.deposit(accountNumber, deposit);
                }
                case 6 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    long withdraw = Long.valueOf(sc.nextLine());
                    accountDirectory.withdraw(accountNumber, withdraw);
                }
                case 7 -> {
                    System.out.print("Enter account number to withdraw: ");
                    String withdrawAccNumber = sc.nextLine();
                    System.out.print("Enter account number to deposit: ");
                    String depositAccNumber = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    long transfer = Long.valueOf(sc.nextLine());
                    accountDirectory.transfer(withdrawAccNumber,depositAccNumber, transfer);
                }
                case 8 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    accountDirectory.deleteAccount(accountNumber);
                }
                case 9 -> {
                    System.out.print("Enter no of accounts you want to view: ");
                    int noOfAccountsToView = Integer.valueOf(sc.nextLine());
                    accountDirectory.viewAccountsWithHighestTransactionValues(noOfAccountsToView);
                }
                case 10 -> {
                    break;
                }
                default -> {
                    System.out.println("Please enter correct choice!");
                }

            }
            System.out.println();

        }

    }
}