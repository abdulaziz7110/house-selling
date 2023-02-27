package uz.ankeloff.House_Selling.project;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.ankeloff.House_Selling.config.BotConfig;
import uz.ankeloff.House_Selling.service.TextService;
import uz.ankeloff.House_Selling.service.UserService;


@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private UserService userService;
    final BotConfig config;

    @Autowired
    private TextService textService;

    public TelegramBot(BotConfig config) {
        this.config = config;
//        List<BotCommand> listofCommands = new ArrayList<>();
//        listofCommands.add(new BotCommand("/start", "get a welcome message"));
//        listofCommands.add(new BotCommand("/mydata", "get your data stored"));
//        listofCommands.add(new BotCommand("/deletedata", "delete my data"));
//        listofCommands.add(new BotCommand("/help", "info how to use this bot"));
//        listofCommands.add(new BotCommand("/settings", "set your preferences"));
//        try {
//            this.execute(new SetMyCommands(listofCommands, new BotCommandScopeDefault(), null));
//        } catch (TelegramApiException e) {
//            log.error("Error setting bot's command list: " + e.getMessage());
//        }
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        User from = message.getFrom();
        System.out.println("hello");

        if (update.hasMessage()){

            if (message.hasText()) {
                String text = message.getText();
                sendMessage = textService.handleText(text, from);
            }

        } else if (update.hasCallbackQuery()) {

        }

        sendMsg(sendMessage);
    }
    public void sendMsg(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
