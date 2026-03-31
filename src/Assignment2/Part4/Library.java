package Assignment2.Part4;

class Book {
    String title;
    String author;
    String ISBN;
    String genre;
    boolean isIssued;

    Book(String title, String author, String ISBN, String genre) {
        this.title    = title;
        this.author   = author;
        this.ISBN     = ISBN;
        this.genre    = genre;
        this.isIssued = false;
    }

    void displayInfo() {
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("ISBN    : " + ISBN);
        System.out.println("Genre   : " + genre);
        System.out.println("Status  : " + (isIssued ? "Issued" : "Available"));
        System.out.println("----------------------------");
    }

    void markIssued() {
        isIssued = true;
    }

    void markReturned() {
        isIssued = false;
    }
}

public class Library {
    String name;
    Book[] books = new Book[20];
    int bookCount = 0;

    Library(String name) {
        this.name = name;
    }

    void addBook(Book b) {
        if (bookCount < 20) {
            books[bookCount] = b;
            bookCount++;
            System.out.println("'" + b.title + "' added to the library.");
        } else {
            System.out.println("Library is full, can't add more books.");
        }
    }

    Book findByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        System.out.println("Not found: no book with title '" + title + "'");
        return null;
    }

    void findByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].author.equalsIgnoreCase(author)) {
                books[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author '" + author + "'");
        }
    }

    void issueBook(String title) {
        Book b = findByTitle(title);
        if (b != null) {
            if (!b.isIssued) {
                b.markIssued();
                System.out.println("'" + title + "' has been issued.");
            } else {
                System.out.println("Sorry, '" + title + "' is already issued.");
            }
        }
    }

    void returnBook(String title) {
        Book b = findByTitle(title);
        if (b != null) {
            b.markReturned();
            System.out.println("'" + title + "' has been returned. Thank you!");
        }
    }

    void displayAllBooks() {
        System.out.println("\n=== All Books in " + name + " ===");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayInfo();
        }
    }

    void countAvailable() {
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isIssued) {
                count++;
            }
        }
        System.out.println("Available books: " + count + " out of " + bookCount);
    }

    public static void main(String[] args) {
        Library lib = new Library("Chennai City Library");

        lib.addBook(new Book("Ponniyin Selvan",    "Kalki",           "1001", "Historical"));
        lib.addBook(new Book("Alchemist",          "Paulo Coelho",    "1002", "Fiction"));
        lib.addBook(new Book("Wings of Fire",      "APJ Abdul Kalam", "1003", "Biography"));
        lib.addBook(new Book("Thirukkural",        "Thiruvalluvar",   "1004", "Philosophy"));
        lib.addBook(new Book("Malgudi Days",       "R.K. Narayan",    "1005", "Fiction"));
        lib.addBook(new Book("Devdas",             "Sarat Chandra",   "1006", "Romance"));

        System.out.println();

        lib.issueBook("Alchemist");
        lib.issueBook("Wings of Fire");

        System.out.println();

        lib.returnBook("Alchemist");

        System.out.println();

        System.out.println("=== Searching for 'Thirukkural' ===");
        Book found = lib.findByTitle("Thirukkural");
        if (found != null) {
            found.displayInfo();
        }

        lib.displayAllBooks();
        lib.countAvailable();
    }
}