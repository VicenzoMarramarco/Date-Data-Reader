import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entidades.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o full PATH:");
        String path = sc.nextLine();

        try (BufferedReader ds = new BufferedReader(new FileReader(path))) {
            
            
            Set<Log> set = new HashSet<>();
            String linha= ds.readLine();

            while (linha!= null) {
                String[] campo= linha.split(" ");
                String nome = campo[0];
                Date momento = Date.from(Instant.parse(campo[1]));
                
                set.add(new Log(nome, momento));

                linha= ds.readLine();
                
             }
             System.out.println("Total de usuarios:  " + set.size());

           } catch (IOException e) {
            System.out.println("Erro na execução:" + e.getMessage());
        }

        sc.close();

    }
}
