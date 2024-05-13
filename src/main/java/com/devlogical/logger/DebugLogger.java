package com.devlogical.logger;
public class DebugLogger extends Logger {

  public DebugLogger() {
    super(3);
  }

  @Override
  void write(String message) {
    System.out.println("Debug: "  + message);
  }
}