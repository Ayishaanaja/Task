package Encapsulation;
class Book {
 private String title;
 private String author;
 private boolean isAvailable;

 public Book(String title, String author) {
	super();
	this.title = title;
	this.author = author;
    this.isAvailable = true;
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

 public boolean isAvailable() {
	return isAvailable;
 }

 public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
 }

 public void borrowBook() {
     if (isAvailable) {
         isAvailable = false;
         System.out.println("You have borrowed \"" + title + "\" by " + author);
     } else {
         System.out.println("Sorry, \"" + title + "\" is currently unavailable.");
     }
 }

 public void returnBook() {
     if (!isAvailable) {
         isAvailable = true;
         System.out.println("You have returned \"" + title + "\". Thank you!");
     } else {
         System.out.println("This book wasn't borrowed.");
     }
 }
}

public class LibrarySystem {
 public static void main(String[] args) {
     Book book1 = new Book("1984", "George Orwell");

     System.out.println("Title: " + book1.getTitle());
     System.out.println("Author: " + book1.getAuthor());
     System.out.println("Available: " + book1.isAvailable());
     book1.borrowBook();   
     book1.borrowBook();   
     book1.returnBook();   
     book1.returnBook();   
 }
}

