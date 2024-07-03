package programmingone.controlstructures.librarysystem;

import java.util.UUID;

public class Book {
  private String id;
  private String title;
  private String author;
  private int quantity;

  public Book(String title, String author, int quantity) {
    id = UUID.randomUUID().toString();
    this.title = title;
    this.author = author;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getQuantity() {
    return quantity;
  }
  
  public void addQuantity(int quantity) {
    this.quantity += quantity;
  }

  public boolean borrowBook(int quantity) {
    if (this.quantity >= quantity) {
      this.quantity -=quantity;
      return true;
    }

    return false;
  }

  public void returnBook(int quantity) {
    this.quantity += quantity;
  }
  
  public String toString() {
    return String.format("%s, %s, %s, %d", id, title, author, quantity);
  }
}
