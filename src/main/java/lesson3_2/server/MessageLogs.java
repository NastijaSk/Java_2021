package lesson3_2.server;

import java.io.*;

public class MessageLogs {

    public static void createFile(String fileName) throws IOException {
        File libDir = new File("src/main/resources/lib/" + fileName + ".txt");
        System.out.println(libDir);
        if (!libDir.exists()) {
            libDir.createNewFile();
        }

    }

    public static void writterInFile(String fileName, String message) throws IOException {
        File libDir = new File("src/main/resources/lib/" + fileName + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(libDir, true));
        writer.append(System.getProperty("line.separator"));
        writer.append(message);
        writer.close();
    }

    public static String readFromFile(String fileName) throws IOException {

        File libDir = new File("src/main/resources/lib/" + fileName + ".txt");
        String lineAll = "";
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(libDir), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineAll = lineAll + line + ';';
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineAll;


    }

    public static void main(String[] args) throws IOException {
        createFile("Petr");
        //writterInFile("ex1", "новый текст");
        System.out.println(readFromFile("Petr"));
    }

}
