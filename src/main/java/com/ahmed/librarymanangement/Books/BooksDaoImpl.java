package com.ahmed.librarymanangement.Books;

import com.ahmed.librarymanangement.DataBaseManagement.DataBaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDaoImpl implements BooksDao {

  @Autowired DataBaseManager dataBaseManager;

  @Override
  public Books getBookById(Integer id) {
    return (Books) dataBaseManager.getRecordById(Books.class, id);
  }

  @Override
  public Books getBookByName(String name) {
    return (Books) dataBaseManager.getRecordByUniqueName(Books.class, name);
  }

  @Override
  public Books saveBook(Books books) {
    return (Books) dataBaseManager.saveRecord(books, books.name+"___"+books.getId());
  }
}
