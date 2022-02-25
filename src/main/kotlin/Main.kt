import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.generics.TelegramBot
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

fun main(args: Array<String>) {

    val telegramBot = TelegramBotsApi(DefaultBotSession::class.java)

    try{

        telegramBot.registerBot(testBot())
    }catch (e: Exception){
        println(e.printStackTrace())
    }
}