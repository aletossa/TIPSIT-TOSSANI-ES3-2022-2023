package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);
        boolean c=true;
        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // per la tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");
        System.out.println(br.readLine()); // rivevo: ciao come ti chiami
        pr.println(tastiera.readLine()); // leggo da tastiera il nome e lo invio

        System.out.println(br.readLine()); //benvenuto utente con numero


            /*while(c){
                System.out.println(br.readLine()); // rivevo: ciao come ti chiami
                pr.println(tastiera.readLine()); // leggo da tastiera il nome e lo invio
                System.out.println(tastiera.readLine().toString());
                if(tastiera.readLine().toString().equals("fine")){
                    c=false;
                }
            }*/
            


        System.out.println(br.readLine()); // rivevo: cosa vuoi fare
        pr.println(tastiera.readLine()); // leggo da tastiera il comando e lo invio
        

        System.out.println(br.readLine()); // rivevo: cosa vuoi fare
        pr.println(tastiera.readLine()); // leggo da tastiera il comando e lo invio

        System.out.println(br.readLine()); // rivevo: cosa vuoi fare
        pr.println(tastiera.readLine()); // leggo da tastiera il comando e lo invio
        
        System.out.println(br.readLine()); //ricevo ora
        
        pr.println("Grazie e ciao");

        s.close();
    }
}
