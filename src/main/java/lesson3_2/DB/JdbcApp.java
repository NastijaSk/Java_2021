package lesson3_2.DB;
import lesson3_2.server.BaseAuthService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcApp {
        private static Connection connection;
        private static Statement stmt;
        public static void main(String[] args) {
            try {
                connect();
                createTable();
                insertClient("Ivan", "user1", "pwd1");
                insertClient("Petr", "user2", "pwd2");
                insertClient("Oleg", "user3", "pwd3");
                readDBClients();
                readData();
                UpdateNickFromLogin("Vanya", "user1");
                readData();
            } catch (Exception e) {

            } finally {
                disconnect();
            }
        }
        public static void connect() throws SQLException {
            //connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/javadb.db");
            stmt = connection.createStatement();
        }
        public static void disconnect() {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static List<BaseAuthService.Entry> readDBClients() throws SQLException {
            List<BaseAuthService.Entry> clients = new ArrayList<BaseAuthService.Entry>();

            ResultSet resultSet = stmt.executeQuery("SELECT id, nick, login, password FROM clients;");
            while (resultSet.next()) {
                clients.add(new BaseAuthService.Entry(
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("nick")));
            }
            return clients;
        }


        private static void createTable() throws SQLException {
            stmt.executeUpdate("create table if not exists clients (\n" +
                    "    id integer primary key autoincrement not null,\n" +
                    "    nick text not null,\n" +
                    "    login text,\n" +
                    "    password text\n" +
                    ");");
        }

        private static void insertClient(String nick, String login, String password) throws SQLException {
           stmt.executeUpdate(String.format("insert into clients " +
                    "(nick, login, password)  values ( '%s', '%s', '%s')", nick, login ,password));
        }

        public static void readData() {
            try (ResultSet rs = stmt.executeQuery("select * from clients")) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString("nick") +
                            " " + rs.getString("login") + " " + rs.getString("password"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public static void UpdateNickFromLogin(String newNick, String login)
        {
            try {
                stmt.executeUpdate(String.format("update clients " +
                        "set nick = '%s' where login = '%s'" , newNick, login));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


