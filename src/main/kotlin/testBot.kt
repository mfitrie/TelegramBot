import com.google.gson.Gson
import data.funFact
import org.json.JSONTokener
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

class testBot : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return readToken()
    }

    override fun getBotUsername(): String {
        return "api1009Bot"
    }

    override fun onUpdateReceived(update: Update?) {
        println(update?.message?.text)

        val chat_id = update?.message?.chatId
        val message = update?.message?.text
//
        val userFirstName = update?.message?.chat?.firstName
        var postGreeting = ""
        if (message.toString() == "hai" || message.toString() == "hi") {
            postGreeting = "Hi $userFirstName"

            val sendMessage = SendMessage(chat_id.toString(), postGreeting)

            try {
                execute(sendMessage)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }

        if(message == "/funfact"){
            val fact = GetRequest().capitalize()

            val sendMessage = SendMessage(chat_id.toString(), fact)

            try {
                execute(sendMessage)
            }catch (e: TelegramApiException){
                e.printStackTrace()
            }
        }



//        GetRequest()




    }

    fun readToken(): String {
        val file = File("src/main/resources/token.txt")

        try {
            val scanner = Scanner(file)
            return scanner.nextLine()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }


    fun GetRequest(): String{
        val gson = Gson()
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://asli-fun-fact-api.herokuapp.com/"))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val jsonParser = gson.fromJson(response.body(), funFact::class.java)
//        println(response.body())

//        println(jsonParser.data?.fact.toString().capitalize())

        return jsonParser.data?.fact.toString()

    }

}