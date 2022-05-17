package com.chat.clientchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    public TextField messageTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView userList;

    private Network network;
    private ClientChatApplication application;

    public void sendMessage(){
        String message = messageTextArea.getText();

        chatTextArea.appendText(DateFormat.getInstance().format(new Date()) + " ");
        chatTextArea.appendText(System.lineSeparator());
        messageTextArea.requestFocus();
        appendMessageToChat(message);
        try {
            network.sendMessage(message);
        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данных по сети");
        }

    }

    public void appendMessageToChat(String message) {
    if(!message.isEmpty()){
        chatTextArea.appendText(message);
        chatTextArea.appendText(System.lineSeparator());
        messageTextArea.clear();
    }

    
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
        network.waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat(message);
            }
        });
    }

    public ClientChatApplication getApplication() {
        return application;
    }

    public void setApplication(ClientChatApplication application) {
        this.application = application;
    }
}