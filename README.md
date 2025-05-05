## Book Manager

Book Manager is a simple Java console application that allows users to manage a list of books stored in a file. The project demonstrates some core OOP principles. It also utilizes file handling with `java.nio.file`, input parsing, and basic user interaction via the console.

### Features

* Load book data from a user-specified file
* Display all books
* Search books by name (case-insensitive, partial matches allowed)
* Add new books (with input validation)
* Remove books by exact name match
* Edit existing book details (name, publishing year, page count, author)
* Save all changes back to the file

### Technologies and Concepts Used

* Object-Oriented Programming:
  * Classes and Objects (`Book`, `Options`, `LoadBooks`)
  * Encapsulation with private fields and public getters/setters
* File I/O with `java.nio.file.Files`
* Exception handling and input validation
* Stream API for parsing and writing data
* Console-based UI using `Scanner`

### How It Works

1. On launch, the program prompts the user to input a valid file(.txt) name containing book data(in a specific format).
2. It loads the file and provides a menu of options to interact with the book list.
3. Users can perform actions such as search, add, remove, and update books.
4. Any changes made are immediately written back to the file, ensuring persistence.
