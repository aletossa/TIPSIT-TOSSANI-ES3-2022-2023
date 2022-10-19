package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    private static int conta = 0;
    private boolean check = true;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();


    public ClientHandler(Socket s) {
        this.s = s;
        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            
            
            System.out.println(br.readLine());
            pr.println("Ciao come ti chiami?"); // invio messaggio
            String nome = br.readLine(); // ricevo: il nome
            System.out.println("Nome ricevuto");
            System.out.println("Utente: " + nome.toUpperCase());
           

            
            pr.println("Benvenuto " + nome.toUpperCase() + " sei l'utente numero: " + conta++);
            pr.println("Cosa vuoi fare"); // invio messaggio
            String comando = br.readLine(); // ricevo: il comando
            


            


            while(check){
                if(comando.equals("data")){
                    pr.println(date.toString());
                }
                if(comando.equals("ora")){
                    pr.println(time.toString());
                }
                if(comando.equals("fine")){
                    check = false;
                }
            }
            System.out.println(br.readLine()); // leggo il saluto finale e lo metto in console
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
