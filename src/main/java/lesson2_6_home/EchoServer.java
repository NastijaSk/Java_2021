package lesson2_6_home;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    private static final int PORT = 8187;
    public static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер начал работу. Ожидаем новое подключение");
            Socket clientSocket = serverSocket.accept();

            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream()); //чтение
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream()); //запись

            //processClientConnection(inputStream, outputStream, clientSocket);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String messageServer= scaner.nextLine();
                    if(messageServer!=""){
                        try {
                            outputStream.writeUTF(messageServer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (clientSocket.isConnected()) {

                    String message = inputStream.readUTF();
                    if (message.startsWith("/end")) {
                        outputStream.writeUTF(message);
                        break;
                    }
                    System.out.println("Клиент: " + message);
                    outputStream.writeUTF("Echo: " + message);
            }



        } catch (IOException e) {
            System.err.println("Ошибка при подключении к порту " + PORT);
            e.printStackTrace();
        }

    }

    private static void processClientConnection(DataInputStream inputStream, DataOutputStream outputStream,
                                                Socket clientSocket) {
        while (clientSocket.isConnected()) {
            String message = null;
            try {
                message = inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (message.startsWith("/end")) {
                break;
            }
            try {
                outputStream.writeUTF("Echo: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

