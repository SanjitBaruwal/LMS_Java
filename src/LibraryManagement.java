import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                }
                case 2 -> {
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    library.addMember(new Member(memberId, name));
                }
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int issueBookId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = scanner.nextInt();
                    library.issueBook(issueBookId, issueMemberId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int returnMemberId = scanner.nextInt();
                    library.returnBook(returnBookId, returnMemberId);
                }
                case 5 -> library.displayBooks();
                case 6 -> library.displayMembers();
                case 7 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
