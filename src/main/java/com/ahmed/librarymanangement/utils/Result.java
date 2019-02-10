package com.ahmed.librarymanangement.utils;

import java.util.ArrayList;
import java.util.List;

public class Result<D> {

  private boolean success = true;
  private D data;
  private List<D> dataItems = new ArrayList<>();
  private List<DataError> errors = new ArrayList<>();

  public Result() {}

  public Result(D data) {
    this.data = data;
  }

  public Result(boolean success, D data) {
    this.success = success;
    this.data = data;
  }

  public Result(boolean success, D data, List<DataError> errors) {
    this.success = success;
    this.data = data;
    this.errors = errors;
  }

  public Result(List<D> dataItems) {
    this.dataItems = dataItems;
  }

  public Result(boolean success, List<D> dataItems) {
    this.success = success;
    this.dataItems = dataItems;
  }

  public Result(boolean success, List<D> dataItems, List<DataError> errors) {
    this.success = success;
    this.dataItems = dataItems;
    this.errors = errors;
  }

  public Result(Result<D> result) {
    this.data = result.data;
  }

  public D getData() {
    return data;
  }

  public void setData(D data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<D> getDataItems() {
    return dataItems;
  }

  public void setDataItems(List<D> dataItems) {
    this.dataItems = dataItems;
  }

  public List<DataError> getErrors() {
    return errors;
  }

  public void setErrors(List<DataError> errors) {
    this.errors = errors;
  }
}
