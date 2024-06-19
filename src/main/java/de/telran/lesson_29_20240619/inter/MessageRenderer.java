package de.telran.lesson_29_20240619.inter;

public interface MessageRenderer {
    void render();
  void setMessageProvider(MessageProvider messageProvider);
  MessageProvider getMessageProvider();

}
