import java.net.ServerSocket
import java.net.Socket

class Server(var port: Int = 5104) {

    private val serverSocket: ServerSocket

    init{
        serverSocket = ServerSocket(port)
    }

    fun start() {
        val clientSocket: Socket = serverSocket.accept()
        
    }
}