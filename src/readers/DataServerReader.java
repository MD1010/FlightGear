package readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServerReader {
    private String port;
    private String sampleTime;

    public DataServerReader(String port, String sampleTime) {
        this.setPort(port);
        this.setSampleTime(sampleTime);
        try {
            this.openServerConnection();
        } catch (IOException e) {
            System.out.println("Failed to open server ! ");
        }
    }

    public static void openServerConnection() throws IOException {

        ServerSocket serverSocket = new ServerSocket(5400);
        System.out.println("here 1");
        Socket socket = serverSocket.accept();
        System.out.println("here 2");
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }

    private String getPort() {
        return this.port;
    }


    private void setPort(String port) {
        this.port = port;
    }


    private String getSampleTime() {
        return this.sampleTime;
    }

    ;
    private void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }
}
