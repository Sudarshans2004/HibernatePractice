package criteria;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket =
                new Socket("192.168.0.212",5000);

        Sttudent student =
                new Sttudent(101,"Naresh");

        ObjectOutputStream oos =
                new ObjectOutputStream(
                        socket.getOutputStream());

        oos.writeObject(student);

        System.out.println("Student Sent");

        oos.close();
        socket.close();
    }
}