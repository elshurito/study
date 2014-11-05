import java.io.*;
import java.net.*;

/**
 *
 * @author root
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            int serverPort = 6668;
            ServerSocket listenSocket = new ServerSocket(serverPort);

            System.out.println("Server start listening...");

            while(true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        }
        catch(IOException e) { System.out.println("Listen :" + e.getMessage()); }
    }
}

class Connection extends Thread {
    InputStream input;
    OutputStream output;
    Socket clientSocket;
    ///123123

    public Connection (Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            input = clientSocket.getInputStream();
            output = clientSocket.getOutputStream();
            this.start();
        }
        catch(IOException e) {
            System.out.println("Connection: " + e.getMessage());
        }
    }

    public void run() {
        try {
            int inputBytesCount = 0;
            while (inputBytesCount == 0) {
                inputBytesCount = input.available();
            }
            byte[] data = new byte[inputBytesCount];
            input.read(data);
            byte a = data[0];
            byte b = data[1];
            byte c = data[2];
            System.out.println(a + b + c);

            System.out.println("Data:" + new String(data, "UTF-8"));
            output.write(data);
        }
        catch(Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
        finally {
            try {
                clientSocket.close();
            }
            catch (IOException e){/*close failed*/}
            //123123123
        }
    }
}