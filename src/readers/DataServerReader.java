package readers;

import utils.VariableAssign;

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
//        try {
//            this.openServerConnection();
//        } catch (IOException e) {
//            System.out.println("Failed to open server ! ");
//        }
    }

    public static void openServerConnection(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("before accept");
        Socket socket = serverSocket.accept();
        System.out.println("conneceted..Now data supposed to be sent");
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        Runnable r = () -> {
            int index = 0;
            try {
                String line = reader.readLine();
                while (line != null) {
                    String[] lineData = line.split(",");
                    VariableAssign.updateExistingVariables(lineData);
                    if(index++ % 10 == 0) {
                        System.out.println(line);
                    }
                    line = reader.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
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
