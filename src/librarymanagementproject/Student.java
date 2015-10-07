/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Gagan
 */
public class Student {
    
    private String name, id;
    private HashMap<Integer, Book> books = new HashMap();
    
    public Student(String name, String id){
        this.name = name;
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getId(){
        return id;
    }
    
    public HashMap<Integer, Book> getBookList(){
        return books;
    }
    
    public void setBook(int isbn, Book b){
        this.books.put(isbn, b);
    }
}
