import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a file name: ");
        LoadBooks loadBooks = new LoadBooks();
        while(true) {
            try {
                String path = scanner.nextLine();
                loadBooks.readBooks(path);
                break;
            } catch (Exception e) {
                System.out.println("Wrong file name, try again.");
            }
        }
        Options options = new Options(loadBooks);

        while (true){
            System.out.println("Options: \n" + "1 - Print all books" + "\n"
                    + "2 - Search by name" + "\n" + "3 - Add book" + "\n" + "4 - Remove book" + "\n"
                    + "5 - Change book" + "\n" + "6 - Quit" + "\n" + "Enter a number:");
            int option = scanner.nextInt();
            switch (option){
                case 1:{
                    options.printAllBooks();
                    break;
                }

                case 2:{
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Give a book name: ");
                    String name = scan.nextLine();

                    options.searchByName(name);
                    break;
                }

                case 3:{
                    options.addBook();
                    break;
                }

                case 4:{
                    System.out.println("In order to properly remove a book give the exact book name: ");
                    Scanner scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    options.removeBook(name);
                    break;
                }

                case 5:{
                    options.changeBook();
                    break;
                }

                case 6:{
                    System.out.println("Bye! :)");
                    System.exit(0);
                }
            }
        }

    }
}