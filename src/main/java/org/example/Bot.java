// Defining Package name
package org.example;

// @Value annotation
// @Component annotation
import org.springframework.stereotype.Component;
// LongPollingBot class
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
// Update Method
import org.telegram.telegrambots.meta.api.objects.Update;
// SendMessage method
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
class Bot extends TelegramLongPollingBot {
    String BOT_TOKEN;
    String BOT_USERNAME;

    String welcomemessage = " с 8 марта!\n\n" + "Желаю тебе счастья, здоровья, успехов во всех твоих начинаниях...\n"
            + "Пусть в этот день всё будет хорошо :) \u2764";

    Bot() {
        this.BOT_TOKEN = BOT_TOKEN;
        this.BOT_USERNAME = BOT_USERNAME;
    }

    // onUpdateReceived method
    @Override
    public void onUpdateReceived(Update update) {
        // Checking if the update has message and it has text

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Creating object of SendMessage
            SendMessage message = new SendMessage();
            // Setting chat id
            message.setChatId(update.getMessage().getChatId().toString());
            // Setting reply to message id
            message.setReplyToMessageId(update.getMessage().getMessageId());
            // Getting and setting received message text
            message.setText("Привет, " + update.getMessage().getFrom().getFirstName() + welcomemessage);
            try {
                // Sending message
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (update.hasMessage() && update.getMessage().getText().equals("")) {
            // Creating object of SendMessage
            // Setting chat id
            message.setChatId(update.getMessage().getChatId().toString());
            // Setting reply to message id
            message.setReplyToMessageId(update.getMessage().getMessageId());
            // Getting and setting received message text
            message.setText("Бот не увы не умеет читать сообщения :(\n" +
                    "Если вы хотите что-нибудь написать пишите сюда: @xm1nya_pr\u2764");
            try {
                // Sending message
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
    }
    @Override
    public String getBotUsername() {
        return "xm1nBot";
    }
    @Override
    public String getBotToken() {
        return "6295699160:AAGleZI1DwLi88Cv9ROjE-nplE9y643HzHE";
    }
}