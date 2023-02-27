package uz.ankeloff.House_Selling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.ankeloff.House_Selling.repository.UserRepository;
import uz.ankeloff.House_Selling.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(org.telegram.telegrambots.meta.api.objects.User user){

        Optional<User> byId = userRepository.findById(user.getId());
        if (byId.isEmpty()) {



            User user1 = new User();
            user1.setId(user.getId());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setUsername(user.getUserName());
            log.info("user saved" + user.getFirstName());
            userRepository.save(user1);

        }else{
            log.info("this user already saved");
            return;
        }
    }

    public ReplyKeyboardMarkup menuPage() {

        KeyboardButton button = new KeyboardButton();
        button.setText("Uy sotib olish \uD83C\uDFE0");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Uy sotish \uD83C\uDFE0");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Bot haqida \uD83E\uDD16");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Sozlamalar ⚙️");


        KeyboardRow row = new KeyboardRow(List.of(button));
        KeyboardRow row1 = new KeyboardRow(List.of(button1));
        KeyboardRow row2 = new KeyboardRow(List.of(button2,button3));

        List<KeyboardRow> rowList = new ArrayList<>(List.of(row, row1, row2));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(rowList);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup settingsButton(){

        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83C\uDF10 Tilni o'zgartirish");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDD19 orqaga \uD35F");

        KeyboardRow row = new KeyboardRow(List.of(button));
        KeyboardRow row1 = new KeyboardRow(List.of(button1));
        List<KeyboardRow> rowList = new ArrayList<>(List.of(row, row1));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
