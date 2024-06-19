package de.telran.lesson_29_20240619.inter;

public class MessageRenderOther implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        System.out.println("***********");
        System.out.println("* " + messageProvider.getMessage() + " *");
        System.out.println("***********");

    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
