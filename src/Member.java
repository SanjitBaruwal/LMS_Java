import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    private int memberId;
    private String name;
    private List<Integer> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Integer> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(int bookId) { borrowedBooks.add(bookId); }
    public void returnBook(int bookId) { borrowedBooks.remove(Integer.valueOf(bookId)); }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Borrowed Books: " + borrowedBooks;
    }
}
