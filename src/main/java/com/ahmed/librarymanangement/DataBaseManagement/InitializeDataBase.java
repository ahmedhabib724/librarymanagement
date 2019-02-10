package com.ahmed.librarymanangement.DataBaseManagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class InitializeDataBase {

  public static int newUserId = 0;
  public static int newBookId = 0;
  public static int newCategoryId = 0;

  @Value("${db.database-path}")
  public String dbPath;

  @Value("${db.users-path}")
  public String usersPath;

  @Value("${db.books-path}")
  public String booksPath;

  @Value("${db.categories-path}")
  public String categoriesPath;

  public static int getNewUserId() {
    return ++newUserId;
  }

  public static int getNewBookId() {
    return ++newBookId;
  }

  public static int getNewCategoryId() {
    return ++newCategoryId;
  }

  public String getUsersPath() {
    return usersPath;
  }

  public String getBooksPath() {
    return booksPath;
  }

  public String getCategoriesPath() {
    return categoriesPath;
  }

  @Bean
  public void createDirectories() {
    createDirectory(dbPath);
    createDirectory(usersPath);
    newUserId = getNewDocumentId(usersPath);
    createDirectory(booksPath);
    newBookId = getNewDocumentId(booksPath);
    createDirectory(categoriesPath);
    newCategoryId = getNewDocumentId(categoriesPath);
  }

  public void createDirectory(String path) {
    File directory = new File(path);
    if (!directory.exists()) {
      directory.mkdirs();
    }
  }

  public int getNewDocumentId(String path) {
    return new File(path).list().length;
  }
}
