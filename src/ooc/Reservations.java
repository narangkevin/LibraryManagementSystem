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
public class Reservations {
    private String book_id;
    private String id;
    private String title;
    private String isbn;
    private String genre;
    private String day_of_reserve;
    
    public Reservations(String BookID, String ID, String ISBN, String Title) {
        this.book_id = BookID;
        this.id = ID;
        this.isbn = ISBN;
        this.title = Title;
    }
    
    public String getBookID() {
        return book_id;
    }
    
    public String getID() {
        return id;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
}
