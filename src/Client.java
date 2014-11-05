
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int serverPort = 6666;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Подключаемся по адресу " + address + ":" + serverPort);
            Socket socket = new Socket(ipAddress, serverPort);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(sout);
            DataInputStream in = new DataInputStream(sin);
            //reading from keyboard
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Напишите что нибудь и нажмите Enter");
            System.out.println();
            while (true) {
                line = keyboard.readLine();
                System.out.println("Отправка данной строки на сервер");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("Ответ сервера: " + line);
                System.out.println();
            }

        } catch (Exception x) {x.printStackTrace();}
        //123123
    }
}