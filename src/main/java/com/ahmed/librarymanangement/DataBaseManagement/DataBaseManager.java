package com.ahmed.librarymanangement.DataBaseManagement;

import com.ahmed.librarymanangement.user.Users;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
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
        Users users = (Users) object;
        writeRecordInFile(
            users, dataBase.getUsersPath()+fileName+".json");
        break;
      case "Books":
        break;
      default:
        break;
    }
    return object;
  }

  public void writeRecordInFile(Object object, String filePath) {
    try {
      String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
      LOG.info("Insert JSON in to file\n" + jsonInString);
      objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
      objectMapper.writeValue(new File(filePath), object);
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Object getRecordById(Object objectToReturn,int id) {
      switch (objectToReturn.getClass().getSimpleName()) {
          case "Users":
              return getObjectById(dataBase.getUsersPath(), id, objectToReturn);
          case "Books":
              break;
          default:
              break;
      }
      return objectToReturn;
  }

  public String getFileNameById(String fileBasePath, int id) {
      File dir = new File(fileBasePath);
      File[] files = dir.listFiles((d, name) -> name.endsWith(id+".json"));
      return files[0].toString();
  }
  public Object getObjectById(String fileBasePath, int id, Object objectToReturn){
      ObjectMapper mapper = new ObjectMapper();
      try {
          objectToReturn = mapper.readValue(new File(getFileNameById(fileBasePath, id)), Object.class);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return objectToReturn;
  }
}
