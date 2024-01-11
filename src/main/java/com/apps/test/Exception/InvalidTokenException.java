package com.apps.test.Exception;

public class InvalidTokenException extends RuntimeException{
  public InvalidTokenException(String message){
    super(message);
  }
}
