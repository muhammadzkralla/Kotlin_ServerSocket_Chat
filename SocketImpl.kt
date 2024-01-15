import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket

class Client {
    init {
        try {
            println("Client Started")
            val socket = Socket("localhost", 80)
            while (socket.isConnected) {
                val clientMessage = BufferedReader(InputStreamReader(System.`in`))
                val message = clientMessage.readLine()

                val printWriter = PrintWriter(socket.getOutputStream(), true)
                printWriter.println(message)

                val serverResponse = BufferedReader(InputStreamReader(socket.getInputStream()))
                println(serverResponse.readLine())
            }
        } catch (e: Exception) {
            println("Connection Ended")
        }
    }
}

fun main() {
    Client()
}