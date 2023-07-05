package pkg_main;

import java.util.Scanner;

import Pkg_book.Book;
import Pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BookTransactionManager;

public class Main {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		StudentManager stm = new StudentManager();
		BookTransactionManager bt = new BookTransactionManager();
		int choice;

		do {
			System.out.println("1. Student\n2. Librarian \n3. Exit");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("Enter Your Roll Number");
				int rollno = sc.nextInt();
				try {
					Student st = stm.get(rollno);
					if (st == null) {
						throw new StudentNotFoundException();
					}

					int std_choice;

					do {
						System.out.println(
								"1. View All Books \n 2. Search Book By Subject\n 3. Search Book By ISBN \4. Issue Book \n 5. Return Book \n 6. Exit ");
						std_choice = sc.nextInt();

						switch (std_choice) {
						case 1:
							System.out.println("Viewing All Books...");
							bm.viewAllBook();
							break;
						case 2:
							System.out.println("searching Book By Subjects...");
							System.out.println("Enter The Book Of Subject");
							sc.nextLine();
							String searchSubject = sc.nextLine();
							bm.listBoookBySubject(searchSubject);
							break;
						case 3:
							System.out.println("Searching Book By ISBN");
							System.out.println("Viewing Book By ISBN...");
							System.out.println("Enter ISBN code");
							int search_isbn = sc.nextInt();
							Book book = bm.searchBookByIsbn(search_isbn);
							if (book == null) {
								System.out.println("Book Not found");
							} else {
								System.out.println(book);
							}
							break;
						case 4:
							System.out.println("Issueing Book..");
							System.out.println("Enter ISBN Code To Issuing Book");
							int issue_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(issue_isbn);

							try {
								if (book == null) {
									throw new BookNotFoundException();
								}
								if (book.getAvailable_quantity() > 0) {
									if (bt.issueBook(rollno, issue_isbn)) {
										book.setAvailable_quantity(book.getAvailable_quantity() - 1);
										System.out.println("Book Issue Succefully..");
									}
								} else {
									System.out.println("Book Quantity Is Not Available To Issue..");
								}
							} catch (BookNotFoundException e) {
								e.printStackTrace();
							}

							break;
						case 5:
							System.out.println("Returning Book..");
							System.out.println("Enter ISBN To Return Book");
							int return_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							if (book == null) {
								throw new BookNotFoundException();
							}
							else {
								if (bt.returnBook(rollno, return_isbn)) {
									book.setAvailable_quantity(book.getAvailable_quantity() + 1);
									System.out.println("Book has Been Return");
								}else {
									System.out.println("could not return the book");
								}
							}
							break;
						case 6:
							System.out.println("Application Close Exiting System..");
							break;
						default:
							System.out.println("Invalid Option");

						}

					} while (std_choice != 6);
				} catch (StudentNotFoundException e) {
					System.out.println(e);
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (choice == 2) {
				int lbn_choice;
				do {

					System.out.println(
							"1. View All Student\n2. View Student By Roll Number\n3. Register New Student\n4. Update Student information\n5. Delete Student");
					System.out.println(
							"6. View All Books\n7 View a Books By ISBN\n8. Register New Book\n9. Update A Book\n10. delete A Book");
					System.out.println("11. View All Transaction\n12. Exit Application");

					lbn_choice = sc.nextInt();

					switch (lbn_choice) {
					case 1:
						System.out.println("Viewing All Student...");
						stm.viewAllstudent();
						break;
					case 2:
						System.out.println("Viewing Student By Roll Number...");
						System.out.println("Enter Student Roll Number");
						int rollNumber = sc.nextInt();
						Student student = stm.get(rollNumber);
						if (student == null) {
							System.out.println("Student Not Found...");
						} else {
							System.out.println(student);
						}
						break;
					case 3:
						System.out.println("Register New Student...");
						System.out.println("Enter Student details To Add");
						String name;
						String emailId;
						String phoneNumber;
						String address;
						String dob;
						int rollno;
						int std;
						String division;
						sc.nextLine();

						System.out.println("Enter Student Name");
						name = sc.nextLine();
						System.out.println("Enter Email Address");
						emailId = sc.nextLine();
						System.out.println("Enter Phone Number");
						phoneNumber = sc.nextLine();
						System.out.println("Enter Address");
						address = sc.nextLine();
						System.out.println("Enter Date Of Birth");
						dob = sc.nextLine();
						System.out.println("Enter Roll Number");
						rollno = sc.nextInt();
						System.out.println("Enter Standard");
						std = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Division");
						division = sc.nextLine();

						student = new Student(name, emailId, phoneNumber, address, dob, rollno, std, division);
						stm.addStudent(student);
						System.out.println("Student details added Successfully...");

						break;
					case 4:
						System.out.println("Update student Information...");
						System.out.println("Enter Roll Number To Update Student Record");
						int modify_rollNumber = sc.nextInt();
						student = stm.get(modify_rollNumber);
						try {
							if (student == null) {
//							System.out.println("Student Not Found...");
								throw new StudentNotFoundException();
							} else {
								System.out.println("Enter Student Name");
								name = sc.nextLine();
								System.out.println("Enter Email Address");
								emailId = sc.nextLine();
								System.out.println("Enter Phone Number");
								phoneNumber = sc.nextLine();
								sc.nextLine();
								System.out.println("Enter Address");
								address = sc.nextLine();
								System.out.println("Enter Date Of Birth");
								dob = sc.nextLine();

								System.out.println("Enter Standard");
								std = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter Division");
								division = sc.nextLine();
								stm.updateStudent(modify_rollNumber, name, emailId, phoneNumber, address, dob, std,
										division);
								System.out.println("Student Record Updated Successfullly...");
							}

						} catch (StudentNotFoundException e) {
							System.out.println(e);
						}

						break;
					case 5:
						System.out.println("deleting Student....");
						System.out.println("Enter Roll Number You Want To delete");
						int detete_rollNumber = sc.nextInt();

						if (stm.deleteStudent(detete_rollNumber)) {
							System.out.println("Student Record Deleted Successfully");
						} else {
							System.out.println("student Record Not Deleted!!");
						}

						break;
					case 6:
						System.out.println("Viewing All Books...");
						bm.viewAllBook();
						break;
					case 7:
						System.out.println("Viewing Book By ISBN...");
						System.out.println("Enter ISBN code");
						int search_isbn = sc.nextInt();
						Book book = bm.searchBookByIsbn(search_isbn);
						if (book == null) {
							System.out.println("Book Not found");
						} else {
							System.out.println(book);
						}
						break;
					case 8:
						System.out.println("Registering New Book...");
						int isbn;
						String title;
						String author;
						String publisher;
						int edition;
						int available_quantity;
						String subject;

						System.out.println("Enter Book ISBN");
						isbn = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Book Title");
						title = sc.nextLine();
						System.out.println("Enter Author Name");
						author = sc.nextLine();
						System.out.println("Enter Publisher");
						publisher = sc.nextLine();
						System.out.println("Enter edition");
						edition = sc.nextInt();

						sc.nextLine();
						System.out.println("Enter Avalable quantity");
						available_quantity = sc.nextInt();
						System.out.println("Enter Book Subject");
						subject = sc.nextLine();

						book = new Book(isbn, title, author, publisher, edition, available_quantity);
						bm.addBook(book);
						System.out.println("New Book Added Successfully..");
						break;
					case 9:
						System.out.println("Updating A Book...");
						System.out.println("Enter ISBN To Update Book");
						int update_isbn = sc.nextInt();

						try {
							book = bm.searchBookByIsbn(update_isbn);
							if (book == null) {
								throw new BookNotFoundException();
							} else {
								System.out.println("Enter Update Book Details..");
								sc.nextLine();
								System.out.println("Enter Book Title");
								title = sc.nextLine();
								System.out.println("Enter Author Name");
								author = sc.nextLine();
								System.out.println("Enter Publisher");
								publisher = sc.nextLine();
								System.out.println("Enter edition");
								edition = sc.nextInt();

								sc.nextLine();
								System.out.println("Enter Avalable quantity");
								available_quantity = sc.nextInt();
								System.out.println("Enter Book Subject");
								subject = sc.nextLine();

								bm.updateBook(update_isbn, title, author, publisher, edition, available_quantity);

							}
						} catch (BookNotFoundException e) {
							System.out.println("e");
						}
						break;
					case 10:
						System.out.println("Deleting A Book");
						System.out.println("Enter ISBN To Delete Book");
						int delete_isbn = sc.nextInt();

						try {
							book = bm.searchBookByIsbn(delete_isbn);
							if (book == null) {
								throw new BookNotFoundException();
							} else {
								bm.deleteBook(delete_isbn);
								System.out.println("Book Record Deleted Succefully..");
							}
						} catch (BookNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 11:
						System.out.println("Viewing All Transactions...");
						bt.showAllTranction();
						break;
					case 12:
						System.out.println("Exiting Application...");
//						System.exit(1);
						break;
					default:

						System.out.println("Invalid Option...");
					}
				} while (lbn_choice != 12);
			}
//			sc.close();
		} while (choice != 3);
		stm.writeToFile();
		bm.writeToFile();
		bt.writeToFile();
		sc.close();

	}
}
