/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc;

/**
 *
 * @author Kevin
 */
public class Books {
     private String book_id;
     private String isbn;
     private String title;
     private String author_name;
     private String genre;
     private String availability;
    
     public Books(String BookID, String ISBN, String Title, String AuthorName, String Genre, String Availability) {
         this.book_id = BookID;
         this.isbn = ISBN;
         this.title = Title;
         this.author_name = AuthorName;
         this.genre = Genre;
         this.availability = Availability;
     }
     
     public Books(String BookID, String ISBN, String Title, String AuthorName, String Genre) {
         this.book_id = BookID;
         this.isbn = ISBN;
         this.title = Title;
         this.author_name = AuthorName;
         this.genre = Genre;
     }
     
     public String getBook_Id() {
         return book_id;
     }
     
     public String getIsbn() {
         return isbn;
     }
     
     public String getTitle() {
         return title;
     }
     
     public String getAuthor_Name() {
         return author_name;
     }
     
     public String getGenre() {
         return genre;
     }
     
     public String getAvailability() {
         return availability;
     }
}
