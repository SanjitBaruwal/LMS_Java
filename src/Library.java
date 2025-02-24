import java.io.*;
import java.util.*;

public class Library {
    private final List<Book> books;
    private final List<Member> members;
    private final String booksFile = "books.txt";
    private final String membersFile = "members.txt";

    public Library() {
        this.books = loadBooks();
        this.members = loadMembers();
    }

    // Load Books from File
    @SuppressWarnings("unchecked")
    private List<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(booksFile))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Save Books to File
    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(booksFile))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load Members from File
    @SuppressWarnings("unchecked")
    private List<Member> loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(membersFile))) {
            return (List<Member>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Save Members to File
    @SuppressWarnings("unchecked")
    private void saveMembers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(membersFile))) {
            oos.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    // Add Member
    public void addMember(Member member) {
        members.add(member);
        saveMembers();
    }

    // Issue Book
    public void issueBook(int bookId, int memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        
        if (book != null && member != null && !book.isIssued()) {
            book.issueBook();
            member.borrowBook(bookId);
            saveBooks();
            saveMembers();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Issue operation failed.");
        }
    }

    // Return Book
    public void returnBook(int bookId, int memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        
        if (book != null && member != null && book.isIssued() && member.getBorrowedBooks().contains(bookId)) {
            book.returnBook();
            member.returnBook(bookId);
            saveBooks();
            saveMembers();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Return operation failed.");
        }
    }

    // Find Book by ID
    private Book findBook(int bookId) {
        return books.stream().filter(book -> book.getId() == bookId).findFirst().orElse(null);
    }

    // Find Member by ID
    private Member findMember(int memberId) {
        return members.stream().filter(member -> member.getMemberId() == memberId).findFirst().orElse(null);
    }

    // Display Books
    public void displayBooks() {
        books.forEach(System.out::println);
    }

    // Display Members
    public void displayMembers() {
        members.forEach(System.out::println);
    }
}
