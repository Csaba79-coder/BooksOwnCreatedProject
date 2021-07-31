package Util;

import controller.BookController;
import model.Book;
import model.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileHandler {

    private static final String RELATIVE_PATH_BOOKS = "src/resources/books.txt";
    private static final String RELATIVE_PATH_CATEGORY = "src/resources/category.txt";
//    private static final String RELATIVE_PATH_TEST_BOOKS = "src/resources/test_books.txt";
//    private static final String RELATIVE_PATH_TEST2 = "src/resources/test2.txt";


    public static void readCategories() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_CATEGORY);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Category currentCategory = new Category(line.split(";"));
            BookController.categoriesMap.putIfAbsent(currentCategory.getID(), new ArrayList<>());
            BookController.categoriesMap.get(currentCategory.getID()).add(currentCategory);
        }
    }

    public static void readBooks() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book currentBook = new Book(line.split(";"));
            if (line.contains("*")) {
                currentBook.setRunOut(true);
            }
            BookController.booksMap.putIfAbsent(currentBook.getCategory(), new ArrayList<>());
            BookController.booksMap.get(currentBook.getCategory()).add(currentBook);
        }
    }

    public static void readBooksByWriters() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book currBook = new Book((line.split(";")));
           if (line.contains("*")) {
               currBook.setRunOut(true);
           }
           BookController.booksByWriter.putIfAbsent(currBook.getWriter(), new ArrayList<>());
           BookController.booksByWriter.get(currBook.getWriter()).add(currBook);
        }
    }

    public static void readBooksByCodes() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book bookByCode = new Book((line.split(";")));
            if (line.contains("*")) {
                bookByCode.setRunOut(true);
            }
            BookController.bookByCode.putIfAbsent(bookByCode.getCode(), new ArrayList<>());
            BookController.bookByCode.get(bookByCode.getCode()).add(bookByCode);
        }
    }

    public static void readBooksByPublisher() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book bookByPublisher = new Book((line.split(";")));
            if (line.contains("*")) {
                bookByPublisher.setRunOut(true);
            }
            BookController.booksByPublisher.putIfAbsent(bookByPublisher.getPublisher(), new ArrayList<>());
            BookController.booksByPublisher.get(bookByPublisher.getPublisher()).add(bookByPublisher);
        }
    }

    public static void readBooksByPublishedYears() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book bookByPublishedYear = new Book((line.split(";")));
            if (line.contains("*")) {
                bookByPublishedYear.setRunOut(true);
            }
            BookController.booksByPublishedYear.putIfAbsent(bookByPublishedYear.getPublication(), new ArrayList<>());
            BookController.booksByPublishedYear.get(bookByPublishedYear.getPublication()).add(bookByPublishedYear);
        }
    }

    public static void readBooksByTitleFirstChar() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_BOOKS);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Book bookByFirstChar = new Book((line.split(";")));
            if (line.contains("*")) {
                bookByFirstChar.setRunOut(true);
            }
            BookController.bookByTitleFirstChar.putIfAbsent(bookByFirstChar.getTitle().charAt(0), new ArrayList<>());
            BookController.bookByTitleFirstChar.get(bookByFirstChar.getTitle().charAt(0)).add(bookByFirstChar);
        }
    }
}
