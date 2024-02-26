import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(var port: Int = 5104) {

    private val serverSocket: ServerSocket

    init{
        serverSocket = ServerSocket(port)
    }

    fun start() {
        var clientSocket: Socket? = null
        try {
            clientSocket = serverSocket.accept()
            val br = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            println("Клиент прислал: ${br.readLine()}")
            val pw = PrintWriter(clientSocket.getOutputStream())
            pw.println("Привет в ответ!")
            pw.flush()
        } catch (_: Throwable){
            println("Упс! Что-то пошло не так")
        } finally {
            clientSocket?.close()
        }
    }
}