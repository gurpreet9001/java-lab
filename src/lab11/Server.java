package lab11;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Server {

    public static void main(String[] args) throws Exception {
        
        String server_IP ;
        
        Scanner scan =new Scanner(System.in);
        //PORT input
        System.out.println("Input port number:");
        Integer portNo=scan.nextInt();
        
        //get IP address
        InetAddress iAddress = InetAddress.getLocalHost();
        server_IP = iAddress.getHostAddress();
        System.out.println("Server IP address : " +server_IP);
    
        //establish socket connection
        ServerSocket serverSocket = new ServerSocket(portNo);
        Socket socket = serverSocket.accept();
        
        //Get data through input stream
        InputStream inputStream = socket.getInputStream();
        System.out.println("Reading: " + System.currentTimeMillis());

        //Using byte stream for given input
        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        //show recieved image attributes
        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());

        serverSocket.close();
    }
    
}
