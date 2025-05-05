import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadBooks {
    private  List<Book> booksRead = new ArrayList<>();
    private String fileName;

    public void readBooks(String file) throws Exception {
        this.fileName = file;

        Files.lines(Paths.get(this.fileName))
                .map(book -> book.split(","))
                .filter(parts -> parts.length >= 4)
                .map(parts -> new Book(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]))
                .forEach(booksRead::add);
    }

    public void writeInFile(){
        try {
            List<String> lines = booksRead.stream()
                    .map(book -> book.getName() + "," + book.getPublishingYear() + "," + book.getPageCount() + "," + book.getAuthor())
                    .collect(Collectors.toList());

            Files.write(Paths.get(this.fileName), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Book> getBooksRead() {
        return booksRead;
    }

}
