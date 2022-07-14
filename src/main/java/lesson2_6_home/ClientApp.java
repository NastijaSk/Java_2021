package lesson2_6_home;

import java.io.IOException;
import java.util.function.Consumer;

public class ClientApp {

    public static void main(String[] args) {

        Client client = new Client();
        client.connectToServer();
        try {
            client.getNetwork().sendMessage("Клиент "+ client.getNAME() +" подключился");
            client.getNetwork().waitMessages(new Consumer<String>() {
                @Override
                public void accept(String message) {
                    System.out.println((message));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
