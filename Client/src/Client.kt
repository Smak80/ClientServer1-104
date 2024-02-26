import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client(
    var host: String,
    var port: Int,
) {

    fun start() {
        var socket: Socket? = null
        try {
            socket = Socket(host, port)
            val pw = PrintWriter(socket.getOutputStream())
            pw.println("Привет, Сервер!")
            pw.flush()
            val br = BufferedReader(InputStreamReader(socket.getInputStream()))
            val reply = br.readLine()
            println("Сервер ответил: $reply")
        } catch (_: Throwable){
            println("Упс! Что-то пошло не так!")
        } finally {
            socket?.close()
        }
    }
}