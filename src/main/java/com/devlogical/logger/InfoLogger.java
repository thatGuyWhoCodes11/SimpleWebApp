package com.devlogical.logger;
public class InfoLogger extends Logger {

  public InfoLogger() {
    super(2);
  }

  @Override
  void write(String message) {
    System.out.println("Info: " + message);
  }
}