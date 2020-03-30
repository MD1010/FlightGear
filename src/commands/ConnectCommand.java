package commands;

import interfaces.ICommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectCommand implements ICommand {
    private static ConnectCommand connectCommandInstance;
    private Socket socket;
    private PrintWriter out;

    private ConnectCommand() {
    }

    public static ConnectCommand getInstance() {
        if (connectCommandInstance == null)
            connectCommandInstance = new ConnectCommand();
        return connectCommandInstance;
    }

    @Override
    public int doCommand(String[] args) {
        try {
            this.setSocket(new Socket(args[0], Integer.parseInt(args[1])));
            this.setOut(new PrintWriter(this.getSocket().getOutputStream(), true));
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return 1;
    }

    // establish a connection

    public void sendCommandToSimulator(String command) throws IOException {
        this.getOut().println(command.replace("\"", ""));
    }


    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOut() {
        return this.out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
}

