package ibf2021.d4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;

/*
A fortune cookie client will make a request to the server to get a cookie.
Client is started based on the following format:
java -cp fortunecookie.jar fc.Client localhost:12345
Server for client to connect is in the form of <host>:<port>
Client will request a cookie from server
and displays the cookie and closes the connection
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class FortuneCookieClient {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Creates a socket based on localhost IP address and port 12345
        Socket socket = new Socket("localhost", 12345);

        try (OutputStream os = socket.getOutputStream(); InputStream is = socket.getInputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            // Allow the user to key in inputs over their console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Initialising an empty string to the message input by the client
            String msg ="";
            msg = br.readLine();
            while (!msg.equals("close")){
                // write and send the message to the server
                dos.writeUTF(msg);
                dos.flush();
                // Now await for server to reply by reading its UTF
                System.out.println(dis.readUTF());
                msg = br.readLine();
            }


                
            
        

        socket.close();

        }
        



        
    }
    
}
