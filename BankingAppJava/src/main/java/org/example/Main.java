package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice=0;
        AccountDirectory accountDirectory = new AccountDirectory();

        while (choice!=9) {

            System.out.println("--Menu--");
            System.out.println("1: Create account");
            System.out.println("2: View account details");
            System.out.println("3: View account balance");
            System.out.println("4: View all accounts");
            System.out.println("5: Deposit money");
            System.out.println("6: Withdraw money");
            System.out.println("7: Transfer money");
            System.out.println("8: Delete account");
            System.out.println("9: Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct choice!");
                continue;
            }

            switch (choice) {

                case 1 -> {
                    String bankName;
                    while (true) {
                        System.out.print("Enter bank name: ");
                        bankName = sc.nextLine();
                        if (bankName.length()<3)
                            System.out.println("Bank name should be 3 letters at least! Please enter again!");
                        else
                            break;
                    }
                    System.out.print("Enter account holder name: ");
                    String accHolderName = sc.nextLine();
                    accountDirectory.createAccount(bankName, accHolderName);
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