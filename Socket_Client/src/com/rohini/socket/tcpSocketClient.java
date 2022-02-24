package com.rohini.socket;

import java.io.*;
import java.net.Socket;

public class tcpSocketClient {

    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;

        Socket clientSocket = new Socket("localhost", 8009);

        System.out.println("Enter a string to server");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        sentence = inFromUser.readLine();

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(sentence + "\n");

        modifiedSentence = inFromServer.readLine();

        System.out.println("RESPONSE FROM SERVER = " + modifiedSentence);

        clientSocket.close();

    }
}
