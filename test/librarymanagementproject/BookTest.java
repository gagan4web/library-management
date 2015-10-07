/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementproject;

import java.util.Date;
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
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = new Book();
        String expResult = null;
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBookWith method, of class Book.
     */
    @Test
    public void testGetBookWith() {
        System.out.println("getBookWith");
        Book instance = new Book();
        String expResult = null;
        String result = instance.getBookWith();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBookWith method, of class Book.
     */
    @Test
    public void testSetBookWith() {
        System.out.println("setBookWith");
        String id = "";
        Book instance = new Book();
        instance.setBookWith(id);
    }

    /**
     * Test of setIssueDate method, of class Book.
     */
    @Test
    public void testSetIssueDate() {
        System.out.println("setIssueDate");
        Date d = null;
        Book instance = new Book();
        instance.setIssueDate(d);
    }

    /**
     * Test of getIssueDate method, of class Book.
     */
    @Test
    public void testGetIssueDate() {
        System.out.println("getIssueDate");
        Book instance = new Book();
        Date expResult = null;
        Date result = instance.getIssueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReturnDate method, of class Book.
     */
    @Test
    public void testSetReturnDate() {
        System.out.println("setReturnDate");
        Date d = null;
        Book instance = new Book();
        instance.setReturnDate(d);
    }

    /**
     * Test of getReturnDate method, of class Book.
     */
    @Test
    public void testGetReturnDate() {
        System.out.println("getReturnDate");
        Book instance = new Book();
        Date expResult = null;
        Date result = instance.getReturnDate();
        assertEquals(expResult, result);
    }
    
}
