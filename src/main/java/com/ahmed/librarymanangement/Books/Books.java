package com.ahmed.librarymanangement.Books;

public class Books {
    Integer id;
    Integer categoryId;
    String name;
    String authorName;

    public Books() {
    }

    public Books(Integer categoryId, String name, String authorName) {

        this.categoryId = categoryId;
        this.name = name;
        this.authorName = authorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
