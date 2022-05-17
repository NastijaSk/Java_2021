package com.chat.clientchat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.chat.clientchat.Network.SERVER_HOST;
import static com.chat.clientchat.Network.SERVER_PORT;

public class ClientChatApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ClientChatApplication.class.getResource("hello-view.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);

        ClientController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");

        stage.show();

        /*
        Подключение к серверу
         */
        connectToServer(controller);
    }

    private void connectToServer(ClientController clientController) {
          Network network = new Network();
          boolean resultConnectedToServer = network.connect();
          if(!resultConnectedToServer){
              String errorMessage = "Невозможно установить сетевое соединение";
              System.err.println(errorMessage);
              showErrorDialog(errorMessage);
          }
          clientController.setNetwork(network);
          clientController.setApplication(this);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                network.close();
            }
        });
    }



    public void showErrorDialog(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();

    }
    public static void main(String[] args) {
        launch();
    }
}