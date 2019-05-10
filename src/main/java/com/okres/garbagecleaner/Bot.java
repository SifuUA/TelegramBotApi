package com.okres.garbagecleaner;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    //method for update
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String text = message.getText();
            if ("/help".equals(text)) {
                sendMsg(message, "How I can help you ?");
            } else if ("/settings".equals(text)) {
                sendMsg(message, "What will we customize ?");
            }
        }
    }

    private void sendMsg(Message message, String responseText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        //get id of our chat
        sendMessage.setChatId(message.getChatId().toString());
        //get msg id on what we will response
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(responseText);
        try {
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    //create keyboard
    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(keyboardMarkup);
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keys = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/settings"));

        keys.add(keyboardFirstRow);

        keyboardMarkup.setKeyboard(keys);
    }

    //name registered
    public String getBotUsername() {
        return "GarbageCleanerBot";
    }

    //token which we got
    //875594596:AAFVH9ZvGvXKpcrDeoi00ne76E5Kk0BNH84
    public String getBotToken() {
        return "875594596:AAFVH9ZvGvXKpcrDeoi00ne76E5Kk0BNH84";
    }
}
