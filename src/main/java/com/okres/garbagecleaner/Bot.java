package com.okres.garbagecleaner;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {


    //method for update
    public void onUpdateReceived(Update update) {

    }

    //name registered
    public String getBotUsername() {
        return null;
    }

    //token which we got
    public String getBotToken() {
        return null;
    }
}
