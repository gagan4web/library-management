/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Gagan
 */
public class Book {
    
    private String title, author, bookWith;
    private Date issueDate, returnDate;
    
    Book(){
        
    }
    
    public Book(String title, String author){
	this.title = title;
	this.author = author;
	this.bookWith = "Library";
        this.issueDate = null;
        this.returnDate = null;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getBookWith(){
        return bookWith;
    }
    
    public void setBookWith(String id){
        this.bookWith = id;
    }
    
    public void setIssueDate(Date d){
        this.issueDate = d;
    }
    public Date getIssueDate(){
        return this.issueDate;
    }
    
    public void setReturnDate(Date d){
        this.returnDate = d;
    }
    public Date getReturnDate(){
        return this.returnDate;
    }
    
}
