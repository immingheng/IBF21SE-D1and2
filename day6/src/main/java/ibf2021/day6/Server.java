package ibf2021.day6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
//import ibf2021.d4.Cookie;
import java.util.concurrent.Executors;

public class Server {
    /*
    Write a fortune cookie server that serves random cookie.
    Server is started in cmd via:
    java -cp fortunecookie.jar fc.Server 12345 cookie_file.txt
    Port 12345 (TCP) and cookie_file.txt contains a list of cookies
    arg[0] = portNo.
    arg[1] = cookie_file.txt file;
    */
    public static void main(String[] args) throws IOException {
        //int portNo = Integer.parseInt(args[0]);
        //String cookietxt = args[1];
        //ServerSocket serverSocket = new ServerSocket(portNo);

        //MultiThreading example:
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        
        // Open a server socket with local IP and port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Listening at port 12345");
        
        try{
            while(true){
            // perform whatever after only when connection is made...
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                CookieClientHandler cookieForAll = new CookieClientHandler(socket);
                //Thread th = new Thread(cookieForAll);
                //th.start();
                threadPool.submit(cookieForAll);
            } // end of while true

        } // end of try
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            serverSocket.close();
        }
    } // end of main

} // end of class
