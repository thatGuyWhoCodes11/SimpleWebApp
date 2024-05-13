package com.devlogical.logger;
public class ErrorLogger extends Logger {

  public ErrorLogger() {
    super(1);
  }

  @Override
  void write(String message) {
    System.out.println("Error: " + message);
  }
}
