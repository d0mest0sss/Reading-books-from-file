import java.util.Scanner;

public class Options {
    private LoadBooks loadBooks;

    public Options(LoadBooks loadBooks) {
        this.loadBooks = loadBooks;
    }

    public void printAllBooks() {
        for(Book book: loadBooks.getBooksRead()){
            System.out.println(book);
        }
    }

    public void searchByName(String name) {
        for(Book book: loadBooks.getBooksRead()){
            if(book.getName().toLowerCase().trim().contains(name.toLowerCase().trim())){
                System.out.println(book);
            }
        }
    }

    public void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give a book to add in this exact format: name,publishing year,page count,author");
        String bookToAdd = scan.nextLine();

        try {
            String[] book = bookToAdd.split(",");
            Book newBook = new Book(book[0], Integer.parseInt(book[1]), Integer.parseInt(book[2]), book[3]);
            loadBooks.getBooksRead().add(newBook);
        } catch (Exception e) {
            System.out.println("Wrong format.");
            return;
        }

        loadBooks.writeInFile();
    }

    public void removeBook(String name) {
        boolean removed = loadBooks.getBooksRead().removeIf(book -> book.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Book removed successfully!");

            loadBooks.writeInFile();
        } else {
            System.out.println("Book not found!");
        }

    }

    public void changeBook(){
        System.out.println("What book do you want to change?(give the exact book name)");
        Scanner scan = new Scanner(System.in);
        String bookToChange = scan.nextLine();
        Book changedBook = null;
        boolean found = false;
        for(Book book: loadBooks.getBooksRead()){
            if(bookToChange.toLowerCase().trim().equals(book.getName().toLowerCase().trim())) {
                System.out.println(book);
                changedBook = book;
                found = true;
            }
        }

        if(!found){
            System.out.println("Book not found!");
            return;
        }


        System.out.println("What do you want to change?" + "\n" + "1 - Name" + "\n"
                + "2 - Publishing year" + "\n" + "3 - Page count" + "\n" + "4 - Author" + "\n" + "5 - Quit" + "\n" + "Enter a number:");
        int option = scan.nextInt();
        switch (option){
            case 1:{
                Scanner s = new Scanner(System.in);
                System.out.println("Enter new name:");
                String newName = s.nextLine();
                changedBook.setName(newName);
                System.out.println("Name changed.");
                break;
            }

            case 2:{
                System.out.println("Enter new publishing year:");
                while(true) {
                    try {
                        Scanner s = new Scanner(System.in);
                        int newYear = s.nextInt();
                        changedBook.setPublishingYear(newYear);
                        break;
                    } catch (Exception e) {
                        System.out.println("Your input is not a number or the number is negative, try again.");
                    }
                }

                System.out.println("Publishing year changed.");
                break;
            }

            case 3:{
                System.out.println("Enter new page count:");
                while(true) {
                    try {
                        Scanner s = new Scanner(System.in);
                        int newCount = s.nextInt();
                        changedBook.setPageCount(newCount);
                        break;
                    } catch (Exception e) {
                        System.out.println("Your input is not a number or the number is negative, try again.");
                    }
                }

                System.out.println("Page count changed.");
                break;
            }

            case 4:{
                Scanner s = new Scanner(System.in);
                System.out.println("Enter new author:");
                String newAuthor = s.nextLine();
                changedBook.setAuthor(newAuthor);
                System.out.println("Author changed.");
                break;
            }

            case 5:{
                System.out.println("Change canceled.");
            }

        }
        loadBooks.writeInFile();
    }
}