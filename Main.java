import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        // Preloaded sample data
        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));
        library.addBook(new Book(101, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(102, "1984", "George Orwell"));

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uid, uname));
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int ibid = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int iuid = sc.nextInt();
                    library.issueBook(ibid, iuid);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int rbid = sc.nextInt();
                    library.returnBook(rbid);
                    break;

                case 5:
                    library.showAllBooks();
                    break;

                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}