package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;

    @Before
    public void setup(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        books.add("Book Title");
        library = new Library(books, printStream, null);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        library.listBooks();
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library = new Library(new ArrayList<String>(), printStream, null);
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        books.add("Book Title");
        library.listBooks();
        verify(printStream, times(2)).println("Book Title");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        setupFormattedTimeTest();
        verify(dateTimeFormatter).print(time);
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {
        time = null;
        setupFormattedTimeTest();
        verify(printStream).println(contains("2013-04-08 16:33:17"));
    }

    private void setupFormattedTimeTest() {
        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");
        library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
    }


}