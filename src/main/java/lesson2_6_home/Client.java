package lesson2_6_home;

public class Client {

    private Network network = new Network();
    private String NAME ="USER" ;

    public String getNAME(){
      return NAME;
    };

    public Network getNetwork() {
        return network;
    }

    public void connectToServer() {

        boolean resultConnectedToServer = network.connect();
        if(!resultConnectedToServer){
            String errorMessage = "Невозможно установить сетевое соединение";
            System.err.println(errorMessage);
        }


    }


}
