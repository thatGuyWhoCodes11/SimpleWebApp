package com.devlogical.logger;
public abstract class Logger {
  private int level;
  private Logger next;

  public Logger(int level) {
    this.level = level;
  }

  public void setNext(Logger next) {
    this.next = next;
  }

  public void logMessage(int level, String message) {
    if (this.level <= level) {
      write(message);
    }
    if (next != null) {
      next.logMessage(level, message);
    }
  }

  abstract void write(String message);
}
