package lesson3_2.server;

import lesson3_2.DB.JdbcApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static lesson3_2.DB.JdbcApp.readDBClients;

public class BaseAuthService implements AuthService {

    private List<Entry> entries;

    public BaseAuthService() {
        entries = new ArrayList<>();
        /*entries.add(new Entry("login1", "pass1", "nick1"));
        */

        try {
            JdbcApp.connect();
            readDBClients();
            JdbcApp.readData();
            JdbcApp.readDBClients();
            entries = JdbcApp.readDBClients();

        } catch (Exception e) {

        } finally {
            JdbcApp.disconnect();
        }

        //System.out.println(entries);
    }

    @Override
    public void start() {
        System.out.println("Auth service is running");
    }

    @Override
    public void stop() {
        System.out.println("Auth service is shutting down");
    }

    @Override
    public Optional<String> getNickByLoginAndPass(String login, String pass) {

        return entries.stream()
                .filter(entry -> entry.login.equals(login) && entry.password.equals(pass))
                .map(entry -> entry.nick)
                .findFirst();

      /*  for (Entry entry : entries) {
            if(entry.login.equals(login) && entry.password.equals(pass)) {
                return Optional.of(entry.nick);
            }
        }
        return Optional.empty();*/
    }

    public static class Entry {
        private int id;
        private String login;
        private String password;
        private String nick;

        public Entry( String login, String password, String nick) {
            this.id= id;
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }
}