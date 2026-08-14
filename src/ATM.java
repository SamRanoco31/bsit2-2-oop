import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
// One account to use with the ATM (name and starting balance).
        Account account = new Account("Juan Dela Cruz", 1000.0);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("===== WELCOME TO CLI ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
// TODO 7: print the owner and balance using the getters.
                    System.out.println("Account Holder: " + account.getOwner());

                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double d = input.nextDouble();
// TODO 8: call account.deposit(d);
                    account.deposit(d);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double w = input.nextDouble();
// TODO 9: call account.withdraw(w);
                    account.withdraw(w);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using CLI ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }
}