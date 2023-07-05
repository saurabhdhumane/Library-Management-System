package Pkg_book;

import java.io.Serializable;

public class Book  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private int available_quantity;
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	// geter and setter methods
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", available_quantity=" + available_quantity + ", subject=" + subject + "]";
	}

	public Book(int isbn, String title, String author, String publisher, int edition, int available_quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.available_quantity = available_quantity;
	}

	public Book() {
		super();
	}

}
