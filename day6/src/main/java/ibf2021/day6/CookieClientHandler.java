package ibf2021.day6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
Refactoring workshop 4 to use thread. Each client connection should be handled 
by a thread. 
Write a class called CookieClientHandler that implements the 
Runnable interface. All interactions with a client should be perform in this 
class.
*/

public class CookieClientHandler implements Runnable{

/* Client connects to server via localhost and portNumber and it either:
request for cookie via get-cookie or close the connection.
Now each client will connect to the server via threading...
*/

private final Socket socket;


//Constructor
public CookieClientHandler(Socket socket) throws IOException {
    this.socket = socket;
}





@Override
    public void run(){    
        //Cookie c1 = new Cookie();
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
            }
        
    } catch (EOFException e) {
       try {
        socket.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
} //end of @Override

public static void main(String[] args) {
    
}

}
