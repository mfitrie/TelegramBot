import com.google.gson.Gson
import data.funFact
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.generics.TelegramBot
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(args: Array<String>) {

    val telegramBot = TelegramBotsApi(DefaultBotSession::class.java)

    try{

        telegramBot.registerBot(testBot())
    }catch (e: Exception){
        println(e.printStackTrace())
    }
}

