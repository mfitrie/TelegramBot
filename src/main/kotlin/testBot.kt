import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update
import java.io.File
import java.util.Scanner

class testBot: TelegramLongPollingBot() {
    override fun getBotToken(): String {
//        return "5108705273:AAEuDMoxS5ytwv-TpeEhZwlShjlP6w66JNM"
        return readToken()
    }

    override fun getBotUsername(): String {
        return "api1009Bot"
    }

    override fun onUpdateReceived(update: Update?) {
        println(update?.message?.text)
    }

    fun readToken(): String{
        val file = File("src/main/resources/token.txt")

        try {
            val scanner = Scanner(file)
            return scanner.nextLine()
        }catch (e: Exception){
            e.printStackTrace()
        }

        return ""
    }
}