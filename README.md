# Library-Management-System
# Library Management System  The Library Management System is a Java application that allows students and librarians to manage books, students, and book transactions. It features searching books, issuing/returning books, and maintaining student records.


# Library Management System

The Library Management System is a Java-based application that allows students and librarians to manage books, students, and book transactions in a library setting. It provides features such as searching books, issuing and returning books, adding and updating student information, and maintaining a record of book transactions.

## Features

- **Student Management:** Students can view available books, search for books by subject or ISBN, issue books, and return books.
- **Librarian Management:** Librarians can view student information, register new students, update student details, delete student records, view and manage books, and track book transactions.
- **Book Management:** Books can be added, updated, and deleted. Librarians can view all books, search books by ISBN, and search books by subject.
- **Book Transactions:** The system allows issuing and returning books, maintaining a record of book transactions, and managing the availability of books.

## Getting Started

To run the Library Management System, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/library-management-system.git`
2. Open the project in your preferred Java IDE.
3. Build and compile the project.
4. Run the `Main` class to start the application.

## Usage

Upon launching the application, you will be presented with a menu that allows you to choose between the student and librarian interfaces. Select the appropriate option based on your role.

### Student Interface

- View All Books: Lists all available books in the library.
- Search Book By Subject: Allows you to search for books based on a specific subject.
- Search Book By ISBN: Retrieves a book by its ISBN number.
- Issue Book: Issues a book to the student.
- Return Book: Returns a book to the library.

### Librarian Interface

- View All Students: Displays a list of all registered students.
- View Student By Roll Number: Retrieves a student's information using their roll number.
- Register New Student: Adds a new student to the system.
- Update Student Information: Updates an existing student's details.
- Delete Student: Removes a student's record from the system.
- View All Books: Lists all available books in the library.
- View a Book By ISBN: Retrieves a book's information using its ISBN number.
- Register New Book: Adds a new book to the library.
- Update a Book: Updates an existing book's details.
- Delete a Book: Removes a book from the library.
- View All Transactions: Displays a list of all book transactions.

## File Handling

The Library Management System utilizes file handling for data persistence. The student, book, and transaction data are stored in separate files. The system writes the data to files when exiting and reads the data from the files when starting up.

## Dependencies

The Library Management System is built using core Java and does not have any external dependencies.

## Contributing

Contributions to the Library Management System project are welcome! If you find any issues or would like to suggest enhancements, please submit an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

