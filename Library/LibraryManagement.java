    package Library;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class LibraryManagement {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Library library = new Library();
            while(true){
                System.out.println("\n===== Library Menu ======");
                System.out.println("1. Add Book");
                System.out.println("2. Issue Book");
                System.out.println("3. Return Book");
                System.out.println("4. Display Books");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
            case 1:
                Book book = new Book();
                System.out.print("Enter Book ID: ");
                book.setBookId(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter Title: ");
                book.setTitle(sc.nextLine());
                System.out.print("Enter Author: ");
                book.setAuthor(sc.nextLine());
                book.setIssued(false);
                library.addBook(book);
                break;

            case 2:
                System.out.print("Enter Book ID to issue: ");
                library.issueBook(sc.nextInt());
                break;

            case 3:
                System.out.print("Enter Book ID to return: ");
                library.returnBook(sc.nextInt());
                break;

            case 4:
                library.displayBooks();
                break;

            case 5:
                System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid option.");
            }
        }
        }
    }
    class Book{
        private int bookId;
        private String title;
        private String author;
        private boolean isIssued;
        public int getBookId() {
            return bookId;
        }
        public void setBookId(int bookId) {
            this.bookId = bookId;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public boolean isIssued() {
            return isIssued;
        }
        public void setIssued(boolean isIssued) {
            this.isIssued = isIssued;
        }
    }
    class Library{
        List<Book> booksList = new ArrayList<>();
        
        public void addBook(Book book){
            booksList.add(book);
            System.out.println("Added Successfully...");
        }
        public boolean issueBook(int bookId){
            for(Book b:booksList){
                    if(b.getBookId() == bookId){
                        if(!b.isIssued()){
                            b.setIssued(true);
                            System.out.println("Book issued successfully!");
                            return true; // Success
                        }
                        else {
                            System.out.println("Book is already issued.");
                            return false; // Already Issued
                        }
                            
                    }
            }
            return false; // Book Not Found
        }
        public boolean returnBook(int bookId){
            for(Book b : booksList){
                if(b.getBookId() == bookId){
                    if(b.isIssued()){
                        b.setIssued(false); // Book is now avaliable now
                        System.out.println("Book returned successfully!");
                        return true; // return successfully
                    }else {
                        System.out.println("Book was never issued.");
                        return false;   //book was never issued

                    }
                }
            }
            System.out.println("Book not found..");
            return false; //book not found
        }
        public void displayBooks(){
            System.out.printf(" %-5s | %-20s | %-30s | %-10s%n" ," ID" , " Author" ,"Title" , "Status");
            System.out.println("----------------------------------------");
            for (Book b : booksList) {
                System.out.printf("%-5s | %-20s | %-30s | %-10s%n" ,
                b.getBookId(),
                b.getAuthor(),
                b.getTitle(),
                b.isIssued() ? "Issued" : "Available");
            }
        }
        
    }
    class User{
        private int userId;
        private String name;
        public int getUserId() {
            return userId;
        }
        public void setUserId(int userId) {
            this.userId = userId;
        }
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }