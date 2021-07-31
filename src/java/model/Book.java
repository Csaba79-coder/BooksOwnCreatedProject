package model;

import controller.BookController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Book {

    Category category;
    String writer;
    String title;
    String publisher;
    int publication;
    String code;
    boolean isRunOut;

    public Book() {
    }

    // TODO parts[0] solve!!! but maybe list ?! ...
    public Book(String[] parts) {
        this(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }

    public Book(String category, String writer, String title, String publisher, String publication, String code) {
        this.category = findValueByKey(BookController.categoriesMap, category);
        this.writer = writer.trim();
        this.title = title.trim();
        this.publisher = publisher.trim();
        this.publication = Integer.parseInt(publication.trim());
        this.code = code.trim();
    }

    private Category findValueByKey(Map<Integer, ArrayList<Category>> categoriesMap, String part) {
        for (List<Category> categoryList : categoriesMap.values()) {
            for (Category currentCategory : categoryList) {
                if (currentCategory.getID() == Integer.parseInt(part.trim())) {
                    return currentCategory;
                }
            }
        }
        return null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isRunOut() {
        return isRunOut;
    }

    public void setRunOut(boolean runOut) {
        isRunOut = runOut;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
