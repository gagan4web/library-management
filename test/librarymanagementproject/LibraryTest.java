/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gagan
 */
public class LibraryTest {
    
    Library libInstance;
     
    public LibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int isbn;
        Book book;
        boolean result =false;
        boolean expResult = false;
        libInstance = new Library();
         for(int i=0; i<20000;i++){
            isbn = 1000 + i;
            book = new Book(i + "Five Point Someone", i + "Chetan Bhagat");
            result = libInstance.addBook(isbn, book);
            expResult = true;
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBook method, of class Library.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        int isbn = 0;
        Book book = null;
       
        boolean result = libInstance.addBook(isbn, book);
        boolean expResult = false;
        assertEquals(expResult, result);
        
        isbn = 1245;
         book = new Book("Five Point Someone","Chetan Bhagat");
         result = libInstance.addBook(isbn, book);
         expResult = true;
         assertEquals(expResult, result);

         isbn = 1445;
         book = new Book("Harry Potter","JK Rowling");
         result = libInstance.addBook(isbn, book);
         expResult = true;
      
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudent method, of class Library.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student student = null;
        Library instance = new Library();
        boolean result = instance.addStudent(student);
        boolean expResult = false;
        assertEquals(expResult, result);
        
        student = new Student("Gagan Prajapati","11CSE34");
        result = instance.addStudent(student);
        assertEquals(true, result);
        
    }

    /**
     * Test of addLibrarian method, of class Library.
     */
    @Test
    public void testAddLibrarian() {
        System.out.println("addLibrarian");
        Librarian l = null;
        Library instance = new Library();
        boolean result = instance.addLibrarian(l);
        // TODO review the generated test code and remove the default call to fail.
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of searchBook method, of class Library.
     */
    @Test
    public void testSearchBook() {
        System.out.println("searchBook");
        String searchText = "";
        HashMap<Integer, Book> expResult = new HashMap<>();
        HashMap<Integer, Book> result = libInstance.searchBook(searchText);
        
        assertEquals(expResult, result);
        
        searchText = "che";
        result = libInstance.searchBook(searchText);
        
        if(result.isEmpty()){
            assertEquals(expResult, result);
        }
        else{
            assertNotNull(result);
        }
    }

    /**
     * Test of getAllBooks method, of class Library.
     */
    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        Library instance = new Library();
        HashMap<Integer, Book> expResult = new HashMap<>();
        HashMap<Integer, Book> result = instance.getAllBooks();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudentList method, of class Library.
     */
    @Test
    public void testGetStudentList() {
        System.out.println("getStudentList");
        Library instance = new Library();
        List<Student> expResult = new ArrayList<>();
        List<Student> result = instance.getStudentList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudent method, of class Library.
     */
    @Test
    public void testGetStudent() {
        System.out.println("getStudent");
        String id = "";
        Library instance = new Library();
        Student expResult = null;
        Student result = instance.getStudent(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of issueBook method, of class Library.
     */
    @Test
    public void testIssueBook() {
        System.out.println("issueBook");
        int isbn = 0;
        String id = "";
        Library instance = new Library();
        boolean expResult = false;
        boolean result = instance.issueBook(isbn, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnBook method, of class Library.
     */
    @Test
    public void testReturnBook() {
        System.out.println("returnBook");
        int isbn = 0;
        Library instance = new Library();
        String expResult = null;
        String result = instance.returnBook(isbn);
        assertEquals(expResult, result);
    }
    
}
