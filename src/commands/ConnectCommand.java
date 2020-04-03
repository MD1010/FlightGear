package commands;

import interfaces.ICommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectCommand implements ICommand {
    private static ConnectCommand connectCommandInstance;
    private static Socket socket;
    private static PrintWriter out;

    private ConnectCommand() {
    }

    public static ConnectCommand getInstance() {
        if (connectCommandInstance == null)
            connectCommandInstance = new ConnectCommand();
        return connectCommandInstance;
    }

    @Override
    public int doCommand(String[] args) {
       /* try {
            socket = new Socket(args[0], Integer.parseInt(args[1]));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }*/
        return 1;
    }

    // establish a connection

    public static void sendCommandToSimulator(String command) throws IOException { //command: "set /controls/..../.././. 100"
//       out.println(command);
    }
}

