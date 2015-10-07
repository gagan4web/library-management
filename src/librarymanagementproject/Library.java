/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Gagan
 */
public class Library {
    private HashMap<Integer, Book> books;
    private List<Student> students; 
    private List<Librarian> librarian;
    private TreeMap<String, String> searchTexts;
    
    Library(){
        this.books = new HashMap();
        students = new ArrayList<>();
        librarian = new ArrayList<>();
        searchTexts = new TreeMap<>();
    }
    
    public boolean addBook(int isbn, Book book){
        if(isbn>0 && book != null){
            books.put(isbn, book);
            try{
                String str1[] = book.getAuthor().split(" ");
                String str2[] = book.getTitle().split(" ");


                for (String str11 : str1) {
                    if(searchTexts.containsKey(str11))
                        searchTexts.put(str11, searchTexts.get(str11)+","+String.valueOf(isbn));
                    else
                        searchTexts.put(str11, String.valueOf(isbn));
                }
                for (String str21 : str2) {
                    if(searchTexts.containsKey(str21))
                        searchTexts.put(str21, searchTexts.get(str21)+","+String.valueOf(isbn));
                    else
                        searchTexts.put(str21, String.valueOf(isbn));
                }
            }
            catch(NullPointerException e){    
            }
            return true;
        }
        return false;
    }
    
    public boolean addStudent(Student student){
        if(student != null){
        students.add(student);
        return true;
        }
        return false;
    }
    
    public boolean addLibrarian(Librarian l){
        if(l != null){
        librarian.add(l);
        return true;
        }
        return false;
    }
    
    public HashMap<Integer, Book> searchBook(String searchText) {
        
        HashMap<Integer, Book> bookList = new HashMap<>();
        
        if(searchText != ""){
            String texts[] = searchText.split(" ");

            SortedMap<String, String> tempRes = new TreeMap<>();

            for(int i=0; i<texts.length; i++){
                if(searchTexts.containsKey(texts[i])){
                    tempRes = searchTexts.tailMap(texts[i]);
                }
                else{
                    searchTexts.put(texts[i], "");
                    tempRes = searchTexts.tailMap(texts[i]);
                    tempRes.remove(texts[i]);
                }
                for(Map.Entry m:tempRes.entrySet()){
                    if(m.getKey().toString().toLowerCase().startsWith(texts[i].toLowerCase())){
                        String str[] = m.getValue().toString().split(",");
                        for(int j=0; j<str.length; j++){
                            try{
                                Book b = (Book)books.get(Integer.parseInt(str[j]));
                                bookList.put(Integer.parseInt(str[j]),b);
                            }
                            catch(NumberFormatException e){   
                            }
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return bookList;
    }
    
    public HashMap<Integer,Book> getAllBooks() {
        return books;
    }
    
    public List<Student> getStudentList() {
        return students;
    }
    
    public Student getStudent(String id){
        for (int i=0; i<students.size(); i++){
            Student s = students.get(i);
            if(s.getId().equalsIgnoreCase(id)){
                return s;
            }
        }
        return null;
    }
    
    public boolean issueBook(int isbn, String id) {
        if(isbn != 0 && !id.equalsIgnoreCase("")){
            int temp = 0;
            for (int i=0; i<students.size(); i++){
                Student s = students.get(i);
                if(s.getId().equalsIgnoreCase(id)){
                    temp = 1;
                    if(books.containsKey(isbn)){
                            Book b = (Book)books.get(isbn);
                            if(b.getBookWith().equalsIgnoreCase("Library")){
                                b.setBookWith(id);
                                b.setIssueDate(new Date());
                                s.setBook(isbn,b);
                                System.out.println("Book with ISBN "+isbn+" issued successfully to Student with ID : "+id);
                            }
                            else{
                                System.out.println("Book is already issued to a student with ID :" + b.getBookWith());
                            }
                    }
                    else{
                        System.out.println("No Book Found with ISBN : "+isbn);
                    }
                }
            }
            if(temp == 0){
                System.out.println("No Student Found with ID : "+id);
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public String returnBook(int isbn){
        if(books.containsKey(isbn)){
            String s = books.get(isbn).getBookWith();
            books.get(isbn).setBookWith("Library");
            books.get(isbn).setIssueDate(null);
            books.get(isbn).setReturnDate(null);
            return s;
        }
        return null;
    }  
}
