package ibf2021.d4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//import ibf2021.d4.Cookie;

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
        int portNo = Integer.parseInt(args[0]);
        String cookietxt = args[1];
        ServerSocket serverSocket = new ServerSocket(portNo);
        
        // Open a server socket with local IP and port 12345
        //ServerSocket serverSocket = new ServerSocket(12345);
        // perform whatever after only when connection is made...
        Socket socket = serverSocket.accept();
        //When connection is established, read what the client says:
        try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            // read inputs from client side 
            String line = dis.readUTF();
            // while input is not close, keep prompting what they want
            while (!line.equals("close")){
                // initialising empty string message
                String msg ="";
                //output what the client says on the server's console
                System.out.println("Message: "+line); 
                // if client request for cookie, call for Cookie class to generate random cookie message
                // the message is then sent back to the client side using dos.writeUTF()
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                if (line.equals("get-cookie")){
                    msg = Cookie.getCookie(); // this returns a random String cookie 
                    System.out.println(msg); // this outputs a random cookie on the server's console
                    dos.writeUTF(msg);
                    dos.flush();
                    
                }
                else{ 
                    msg = "You have keyed an invalid input!"; // this returns a random String cookie 
                    System.out.println(msg); // output invalid input on server's console
                    dos.writeUTF(msg);
                    dos.flush();
                } // end of else
                line = dis.readUTF();
            } // end of while loop
        }      // end of try
 
        //closing the socket and serverSocket when client keys in close
        catch(EOFException e){
        socket.close();
        serverSocket.close();
        }
    } // end of main

} // end of class
