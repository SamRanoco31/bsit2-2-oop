import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY INFORMATION SYSTEM =====");
            System.out.println("1. Add a Book");
            System.out.println("2. List All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search a Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);

                    break;

                case 2:

                    library.listBooks();

                    break;

                case 3:

                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = scanner.nextLine();

                    library.borrowBook(borrowTitle);

                    break;

                case 4:

                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();

                    library.returnBook(returnTitle);

                    break;

                case 5:

                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();

                    library.searchBook(searchTitle);

                    break;

                case 0:

                    System.out.println("Thank you for using the Library Information System!");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}