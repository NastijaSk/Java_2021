package lesson2_6_home;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network {

    public static final String SERVER_HOST = "localhost"; //127.0.0.1
    public static final int SERVER_PORT = 8188;

    private String host;
    private int port;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;
    private Socket socket;

    public Network(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            socketInput = new DataInputStream(socket.getInputStream()); //чтение
            socketOutput = new DataOutputStream(socket.getOutputStream()); //запись
            System.out.println("Network connect");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            socketOutput.writeUTF(message);
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение на сервер");
            e.printStackTrace();
            throw e;
        }
    }

    public void waitMessages(Consumer<String> messageHandler) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String message = socketInput.readUTF();
                        messageHandler.accept(message);
                    } catch (IOException e) {
                        System.err.println("Не удалось получить сообщение от сервера");
                        break;

                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();



    }

    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Не удалось закрыть соединение");
        }
    }
}


