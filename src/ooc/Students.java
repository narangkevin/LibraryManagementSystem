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
public class Students {
    private String book_id;
    private String isbn;
    private String title;
    private String day_of_issue;
    private String due_date;
    private String isExtended;
     
     public Students(String BookID, String ISBN, String Title, String DayIssue, String DueDate, String Extend) {
        this.book_id = BookID;
        this.isbn = ISBN;
        this.title = Title;
        this.day_of_issue = DayIssue;
        this.due_date = DueDate;
        this.isExtended = Extend;
     }
     
     public String getBookID() {
         return book_id;
     }
     
     public String getIsbn() {
         return isbn;
     }
     
     public String getTitle() {
         return title;
     }
     
     public String getDayIssue() {
         return day_of_issue;
     }
     
     public String getDueDate() {
         return due_date;
     }
     
     public String getExtend() {
         return isExtended;
     }
}
