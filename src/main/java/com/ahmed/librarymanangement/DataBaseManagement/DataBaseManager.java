package com.ahmed.librarymanangement.DataBaseManagement;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class DataBaseManager {

  private static final Logger LOG = LoggerFactory.getLogger(DataBaseManager.class);

  @Autowired InitializeDataBase dataBase;
  @Autowired ObjectMapper objectMapper = new ObjectMapper();

  public Object saveRecord(Object object, String fileName) {

    switch (object.getClass().getSimpleName()) {
      case "Users":
        writeRecordInFile(object, dataBase.getUsersPath() + fileName + ".json");
        return object;
      case "Books":
        writeRecordInFile(object, dataBase.getBooksPath() + fileName + ".json");
        return object;
      case "Categories":
        writeRecordInFile(object, dataBase.getCategoriesPath() + fileName + ".json");
        return object;
      default:
        break;
    }
    return null;
  }

  public void writeRecordInFile(Object object, String filePath) {
    try {
      String jsonInString =
          objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
      LOG.info("Insert JSON in to file\n" + jsonInString);
      objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
      objectMapper.writeValue(new File(filePath), object);
    } catch (JsonGenerationException e) {
      LOG.error("Exceptions occurs while saves {} record ", object.getClass().getSimpleName(), e);
    } catch (JsonMappingException e) {
      LOG.error("Exceptions occurs while saves {} record ", object.getClass().getSimpleName(), e);
    } catch (IOException e) {
      LOG.error("Exceptions occurs while saves {} record ", object.getClass().getSimpleName(), e);
    }
  }

  public Object getRecordById(Class objectToReturn, int id) {
    switch (objectToReturn.getSimpleName()) {
      case "Users":
        return getObjectById(dataBase.getUsersPath(), id, objectToReturn);
      case "Books":
        return getObjectById(dataBase.getBooksPath(), id, objectToReturn);
      case "Categories":
        return getObjectById(dataBase.getCategoriesPath(), id, objectToReturn);
      default:
        break;
    }
    return null;
  }

  public Object getRecordByUniqueName(Class objectToReturn, String uniqueName) {
    switch (objectToReturn.getSimpleName()) {
      case "Users":
        return getObjectByUniqueName(dataBase.getUsersPath(), uniqueName, objectToReturn);
      case "Books":
        return getObjectByUniqueName(dataBase.getBooksPath(), uniqueName, objectToReturn);
      case "Categories":
        return getObjectByUniqueName(dataBase.getCategoriesPath(), uniqueName, objectToReturn);
      default:
        break;
    }
    return null;
  }

  private String getFileNameById(String fileBasePath, int id) {
    return new File(fileBasePath).listFiles((d, name) -> name.endsWith(id + ".json"))[0].toString();
  }

  private String getFileNameByUniqueName(String fileBasePath, String UniqueName) {
    return new File(fileBasePath)
        .listFiles((d, name) -> name.startsWith(UniqueName + "___"))[0].toString();
  }

  private <T> T getObjectById(String fileBasePath, int id, Class<T> objectToReturn) {
    try {
      return objectMapper.readValue(new File(getFileNameById(fileBasePath, id)), objectToReturn);
    } catch (Exception e) {
      LOG.error("Exceptions occurs while get {} record by Id ", objectToReturn.getSimpleName(), e);
    }
    return null;
  }

  private <T> T getObjectByUniqueName(
      String fileBasePath, String UniqueName, Class<T> objectToReturn) {
    try {
      return objectMapper.readValue(
          new File(getFileNameByUniqueName(fileBasePath, UniqueName)), objectToReturn);
    } catch (Exception e) {
      LOG.error(
          "Exceptions occurs while get {} record by unique name",
          objectToReturn.getSimpleName(),
          e);
    }
    return null;
  }
}
