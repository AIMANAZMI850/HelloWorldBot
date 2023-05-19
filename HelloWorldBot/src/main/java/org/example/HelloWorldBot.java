package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class HelloWorldBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getText());
        //System.out.println(update.getMessage().getFrom().getFirstName());

        String messageText = update.getMessage().getText();

        // Check if the message is "/start"
        if (messageText.equals("/start")) {
            String username = update.getMessage().getFrom().getFirstName();
            String message = "Hello, " + username + "!";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);

            try {
                // Send the message
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

        @Override
        public String getBotUsername() {
            return "HelloWorldMessenger_bot";
        }

        @Override
        public String getBotToken() {
            return "6252888004:AAGOlF1eKiQX8kCugCQQKNqfKTS6zJDdDtI";
        }
    }

