package uz.ankeloff.House_Selling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import uz.ankeloff.House_Selling.config.BotConfig;
import uz.ankeloff.House_Selling.project.TelegramBot;



@Service
@Slf4j
@RequiredArgsConstructor
public class TextService {

    private final UserService userService;
//    private final SendMsg sendMsg;
//    private final TelegramBot telegramBot;

    public SendMessage handleText(String text, org.telegram.telegrambots.meta.api.objects.User user) {


        SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(user.getId());

        switch (text) {
            case "/start" -> {
                sendMessage.setText("Assalamu alaykum bizning uy bozor botimizga xush kelibsiz!!! \n" +
                        "Bizning bo'timiz sizga uy \uD83C\uDFE0 sotish va sotib olishingizda yordam beradi");
                userService.registerUser(user);
                ReplyKeyboardMarkup replyKeyboardMarkup = userService.menuPage();
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
            }
            case "hi" -> {
                sendMessage.setText("all over the world");
            }
            case "Sozlamalar ⚙️" ->{
                ReplyKeyboardMarkup replyKeyboardMarkup = userService.settingsButton();
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                sendMessage.setText("Kategoriyalardan birini tanlang");
            }
            case "Bot haqida \uD83E\uDD16" -> {
                sendMessage.setText(aboutUs());
            }
            case "" -> {

            }
            default -> {
                sendMessage.setText("Iltimos matnni to'g'ri kiriting");
            }
        }

        return sendMessage;
    }

    public String aboutUs(){

        return "\uD83C\uDFE0 Assalamu alaykum bizni botimizga 2/16/2023 ishga tushirdik Insha Alloh bu bo'timiz bilan sizga foyda keltiramiz deb umid qilamiz\n" +
        " taklif yoki shikoyatlaringiz bo'lsa bizga yozing \n" +
                "\uD83D\uDC68\u200D\uD83D\uDCBB https://t.me/Ankeloff";
    }
}
