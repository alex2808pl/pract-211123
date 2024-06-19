package de.telran.lesson_29_20240619.inter.factory;

import de.telran.lesson_29_20240619.inter.MessageProvider;
import de.telran.lesson_29_20240619.inter.MessageRenderer;

public class MainFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
