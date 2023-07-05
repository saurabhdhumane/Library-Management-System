package pkg_transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookTransactionManager {
	ObjectOutputStream oos_bookTransaction = null;
	ObjectInputStream ois_bookTransaction = null;

	File bookTransaction_file = new File("bookTransaction.dat");

	ArrayList<BookTransaction> bookTransaction_list = null;

	@SuppressWarnings("unchecked")
	public BookTransactionManager() {
		bookTransaction_file = new File("bookTransaction.dat");
		bookTransaction_list = new ArrayList<BookTransaction>();

		if (bookTransaction_file.exists()) {
			try {
				ois_bookTransaction = new ObjectInputStream(new FileInputStream(bookTransaction_file));
				bookTransaction_list = (ArrayList<BookTransaction>) ois_bookTransaction.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean issueBook(int rollno, int isbn) {
		int total_book_issue = 0;

		for (BookTransaction bookTransaction : bookTransaction_list) {
			if ((bookTransaction.getRollno() == rollno) && (bookTransaction.getReturndate() == null)) {
				total_book_issue = +1;
			}
			if (total_book_issue >= 3) {
				return false;
			}

		}
		String isuee_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
		BookTransaction bookTransaction = new BookTransaction(isbn, rollno, isuee_date, null);
		bookTransaction_list.add(bookTransaction);
		return true;
	}

	public boolean returnBook(int rollno, int isbn) {
		for (BookTransaction bookTransaction : bookTransaction_list) {
			if ((bookTransaction.getRollno() == rollno) && (bookTransaction.getIsbn() == isbn)
					&& (bookTransaction.getReturndate() == null)) {
				String return_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
				bookTransaction.setReturndate(return_date);
				return true;
			}
		}
		return false;
	}

	public void showAllTranction() {
		for (BookTransaction bookTransaction : bookTransaction_list) {
			System.out.println(bookTransaction);
		}

	}
	
	public void writeToFile() {
		try {
			oos_bookTransaction = new ObjectOutputStream(new FileOutputStream(bookTransaction_file));
			oos_bookTransaction.writeObject(bookTransaction_list);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
