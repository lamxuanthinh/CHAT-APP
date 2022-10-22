/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author phapne
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serversocket = new ServerSocket(6788);
            while(true) {
                Socket socket = serversocket.accept();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String line = reader.readLine();
                System.out.println("received" + line);
                System.out.println("sent" + line.toUpperCase() );
                out.print(line.toUpperCase());
                out.flush();
                
                reader.close();
                out.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
