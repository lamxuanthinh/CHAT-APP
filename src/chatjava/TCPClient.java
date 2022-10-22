/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author phapne
 */
public class TCPClient {
    public static void main(String[] args) {
        try {

                Socket socket = new Socket("127.0.0.1", 6788);
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                
                Scanner sc = new Scanner(System.in);
                System.out.println("enter text : ");
                String st = sc.nextLine();
                System.out.println("sent" + st);
                out.print(st);
                out.flush();
                
                String line = reader.readLine();
                System.out.println("received " + line);
                
                reader.close();
                out.close();
                socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
