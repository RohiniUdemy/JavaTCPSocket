package com.rohini.socketServer;

import java.io.*;
import java.net.*;
import java.util.Locale;

public class tcpSocketServer {

    public static void main(String[] args) throws IOException {
    String clientSentence;
    String capitalizedSentence;

    ServerSocket welcomeSocket = new ServerSocket(8009);
        System.out.println("Listening on port 8009");
    while(true) {
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase(Locale.ROOT) + "\n";

            outToClient.writeBytes(capitalizedSentence);
            System.out.println("RESPONSE TO CLIENT = " + capitalizedSentence);

        }
    }
}
