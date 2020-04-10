package readers;

import com.sun.security.ntlm.Server;
import utils.VariableAssign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServerReader {
    private static ServerSocket serverSocket;
    private static InputStream input;
    private static BufferedReader reader;
    private static Socket socket;
    public static int sleepedTime;
    public DataServerReader() {

    }

    public static void openServerConnection(int port, int time) throws IOException {
        sleepedTime = time;
        serverSocket = new ServerSocket(port);
        System.out.println("before accept");
        socket = serverSocket.accept();
        System.out.println("conneceted..Now data supposed to be sent");
        input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));

        Runnable r = () -> {
            int index = 0;
            try {
                String line = reader.readLine();
                while (line != null) {
                    String[] lineData = line.split(",");
                    VariableAssign.updateExistingVariables(lineData);
                    if (index++ % 10 == 0) {
                        System.out.println(line);
                    }
                    line = reader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }



    public static void closeConnection() throws IOException {
        serverSocket.close();
        input.close();
        socket.close();
        reader.close();
    }

}
