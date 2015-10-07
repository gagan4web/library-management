/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Gagan
 */
public class LibraryManagementProject {
    
    static String fileName = null;
    static Library lib = new Library();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Boolean running = true;
    private static List<Student> studentList = new ArrayList<>();
    
    private static final String setGreenText = "\033[32;32m";
    private static final String setGrayText = "\033[1;30m";
    private static final String setBlueText = "\033[34;34m";
    private static final String setRedText = "\033[31;31m";
    
    public static void main(String[] args) throws IOException {
        while (running) {
            System.out.println("\nEnter your Choice :\n"
				+ "\n1 to add book to library"
				+ "\n2 to list all books in library"
                                + "\n3 to Add a Student "
                                + "\n4 to list all Students "
                                + "\n5 Search a Book "
                                + "\n6 Issue a Book "
                                + "\n7 Return a Book "
				+ "\n8 to Add a Librarian ");
            int answer = Integer.parseInt(br.readLine());
            switch (answer) {
		case 1:
                    addBook();
                    break;
		case 2:
                    HashMap<Integer, Book> bookList = lib.getAllBooks();
                    printBookList(bookList);
                    pausePointer();
                    break;
		case 3:
                    addStudent();
                    break;
                case 4:
                    studentList = lib.getStudentList();
                    printStudentList(studentList);
                    break;
                case 5:
                    searchBook();
                    pausePointer();
                    break;
                case 6:
                    issueBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    boolean b = adminLogin();
                    if(b)
                        addLibrarian();
                    else{
                        System.out.println("\nError : Wrong Input\n");
                    }
                    break;
                default:
                    break;
            }
        }
    } 

    private static void addBook() throws IOException {
        int isbn;
	String title, author;
        try{
            System.out.println("\nEnter Title: ");
            title = br.readLine();

            System.out.println("\nEnter Author: ");
            author = br.readLine();

            System.out.println("\nEnter ISBN: ");
            isbn = Integer.parseInt(br.readLine());

            Book b = new Book(title, author);
            boolean res = lib.addBook(isbn, b);

            if(res == true){
                System.out.println(setGreenText+"Book added to Library");
            }
            else{
                System.out.println(setRedText+"Invalid Entry!");
            }
        }
        catch(NumberFormatException e){
            System.out.println("\n"+setRedText+"Warning! ISBN should be a number.");
        }
        pausePointer();
    }
    
    private static void addStudent() throws IOException {
        String name, id;
        
        System.out.println("Enter Student Name :");
        name = br.readLine();
        System.out.println("Enter Student ID :");
        id = br.readLine();
        if(!name.equalsIgnoreCase(" ") && !id.equalsIgnoreCase(" ")){
            Student s = new Student(name, id);
        lib.addStudent(s);
        }
        else{
            System.out.println("\n"+setRedText+"Invalid Input!");
        }
        pausePointer();
    }
    
    private static void searchBook() throws IOException{
        String searchText;
        System.out.println("Enter book name or author :");
        searchText = br.readLine();
        HashMap<Integer, Book> bookList = lib.searchBook(searchText);
        printBookList(bookList);
    }

    private static void addLibrarian() throws IOException {
        int id;
        String name, pw;
        
        System.out.println("Enter Librarian Name :");
        name = br.readLine();
        System.out.println("Enter Librarian ID :");
        id = Integer.parseInt(br.readLine());
        System.out.println("Enter Librarian Password :");
        pw = br.readLine();
        Book b = null;
        
        Librarian l = new Librarian(name, id, pw);
        lib.addLibrarian(l);
        pausePointer();
    }

    private static boolean adminLogin() throws IOException {
        String u,pw,au,ap;
        
        Admin adm = new Admin();
        
        au = adm.getUsername();
        ap = adm.getPassword();
        System.out.println("Admin Username : ");
        u=br.readLine();
        System.out.println("Admin Password : ");
        pw = br.readLine();
        
        return au.equals(u) && ap.equals(pw);
    }
    private static void pausePointer() throws IOException{
        System.out.print("\n"+setGreenText+"Successful! Press enter to continue.");
        br.readLine();
    }

    private static void printBookList(HashMap<Integer,Book> bookList) throws IOException {
        if(!bookList.isEmpty()){
            System.out.println("\n"+setGreenText+"=======================================================================| Books |=======================================================================");
            System.out.println(setBlueText+"Title\t\t\t|\tAuthor\t\t\t|\tISBN\t| Book Issued To |\tIssue Date\t\t|\tReturn Date");
            System.out.println(setBlueText+"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            int l;
            for(Map.Entry m:bookList.entrySet()){
                Book b = (Book) m.getValue();
                System.out.print(b.getTitle());
                l = b.getTitle().length()/8;
                for(int j=0; j<3-l; j++){
                    System.out.print("\t");
                }
                System.out.print("|\t"+b.getAuthor());
                l = b.getAuthor().length()/8;
                for(int j=0; j<3-l; j++){
                    System.out.print("\t");
                }
                System.out.print("|\t"+m.getKey()+"\t");
                System.out.print("|\t"+b.getBookWith()+"\t| ");
                if(b.getIssueDate() != null)
                    System.out.print(b.getIssueDate());
                else
                    System.out.print("\t\t\t");
                System.out.print("\t| ");
                if(b.getReturnDate() != null)
                    System.out.print(b.getReturnDate());
                System.out.print("\t");
                System.out.println(); 
            }
        }
        else{
            System.out.println();
        }
    }
    
    private static void printStudentList(List<Student> students) throws IOException {
        System.out.println(setGrayText+"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(setGrayText+"Sr.No.\t\t\t\t|\tName\t\t\t\t|\tID\t");
        System.out.println(setGrayText+"________________________________________________________________________________________________________________________________________________________________________");
        int l;
        for(int i=0;i<students.size();i++){
            System.out.print((i+1)+"\t\t\t\t");
            
            System.out.print("|\t"+students.get(i).getName());
            l = students.get(i).getName().length()/8;
            for(int j=0; j<4-l; j++){
                System.out.print("\t");
            }
            System.out.print("|\t"+students.get(i).getId());
            HashMap<Integer, Book> bookList = students.get(i).getBookList();
            printBookList(bookList);
            System.out.println("________________________________________________________________________________________________________________________________________________________________________\n\n");
        } 
        pausePointer();
    }

    private static void returnBook() throws IOException {
        int isbn;
        System.out.println("Enter Book ISBN :");
        isbn = Integer.parseInt(br.readLine());
        String s = lib.returnBook(isbn);
        if(s != null){
            System.out.println("Book with ISBN : "+isbn+" is Successfully returned from Student with ID :"+s);
        }
        else{
            System.out.println("No Book Found with ISBN : "+isbn);
        }
        pausePointer();
    }

    private static void issueBook() throws IOException {
        String id;
        int isbn;
        try{
            System.out.println("Enter Student ID :");
            id= br.readLine();
            System.out.println("Enter ISBN of the Book to be issued :");
            isbn = Integer.parseInt(br.readLine());
            lib.issueBook(isbn, id);
        }
        catch(NumberFormatException e){
            System.out.println(setRedText+"Warning! Invalid Input");
        }
        pausePointer();
    }
}
