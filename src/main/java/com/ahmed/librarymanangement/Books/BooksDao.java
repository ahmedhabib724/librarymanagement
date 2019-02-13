package com.ahmed.librarymanangement.Books;

public interface BooksDao {
    Books getBookById(Integer id);

    Books getBookByName(String name);

    Books saveBook(Books books);
}
