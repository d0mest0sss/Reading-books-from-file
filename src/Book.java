public class Book {

    private String name;
    private int publishingYear;
    private int pageCount;
    private String author;

    public Book(String name, int publishingYear, int pages, String author) {
        if (publishingYear <= 0) {
            throw new IllegalArgumentException("Publishing year must be positive.");
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }

        this.name = name;
        this.publishingYear = publishingYear;
        this.pageCount = pages;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishingYear(int publishingYear) {
        if (publishingYear <= 0) {
            throw new IllegalArgumentException("Publishing year must be positive.");
        }

        this.publishingYear = publishingYear;
    }

    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }

        this.pageCount = pageCount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString(){
        return "Book name: " + this.name + "\n" + "Publishing year: " + this.publishingYear + "\n"
                + "Page count: " + this.pageCount + "\n" + "Author: " + this.author + "\n";
    }

}