import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.ServerSocket

class Server {
    init {
        try {
            println("Waiting For Clients")

            val serverSocket = ServerSocket(80)
            val socket = serverSocket.accept()

            println("Client Connected")

            while (socket.isConnected) {
                val clientMessage = BufferedReader(InputStreamReader(socket.getInputStream()))
                println(clientMessage.readLine())

                val serverResponse = BufferedReader(InputStreamReader(System.`in`))
                val response = serverResponse.readLine()

                val printWriter = PrintWriter(socket.getOutputStream(), true)
                printWriter.println(response)
            }
        } catch (e: Exception) {
            println("Connection Ended")
        }
    }
}

fun main() {
    Server()
}