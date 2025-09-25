import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null) {
            if (!book.isIssued()) {
                book.issueBook();
                System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
            } else {
                System.out.println("Book is already issued!");
            }
        } else {
            System.out.println("Book/User not found.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("Book not found or not issued.");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) return user;
        }
        return null;
    }

    public void showAllBooks() {
        System.out.println("\nBooks in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
