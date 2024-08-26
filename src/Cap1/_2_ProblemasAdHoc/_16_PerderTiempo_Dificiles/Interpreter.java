package Cap1._2_ProblemasAdHoc._16_PerderTiempo_Dificiles;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Interpreter {


     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         scan.useLocale(Locale.ENGLISH);

         //Definir la memoria RAM
         int[] memory = new int[1000];
         //Definir los registros
         int[] registros = new int[10];

         //Cargar la memoria
         int i = 0;
         while (scan.hasNextInt()) {
             memory[i] = scan.nextInt();
             i++;
         }

         //Ejecutar el programa
         int pc = 0;
         int count = 0;
         boolean halt = false;
         while (!halt) {
             int instr = memory[pc];
             //Descomponer la instrucción
             int op = instr / 100;
             int d = (instr % 100) / 10;
             int n = instr % 10;
             pc++;
             count++;
             //Analizar y ejecutar la instrucción
             if (op == 1) {
                 // 1 means halt (regardless of the values of d and n
                 halt = true;
             } else if (op == 2) {
                 // 2dn means set register d to n (between 0 and 9)
                 registros[d] = n;
             } else if (op == 3) {
                 // 3dn means add n to register d
                 registros[d] = (registros[d] + n) % 1000;
             } else if (op == 4) {
                 // 4dn means multiply register d by n
                 registros[d] = (registros[d] * n) % 1000;
             } else if (op == 5) {
                 // 5dn means set register d to the value of register n
                 registros[d] = registros[n];
             } else if (op == 6) {
                 // 6dn means add the value of register n to register d
                 registros[d] = (registros[d] + registros[n]) % 1000;
             } else if (op == 7) {
                 // 7dn means multiply register d by the value of register n
                 registros[d] = (registros[d] * registros[n]) % 1000;
             } else if (op == 8) {
                 // 8dn means set register d to the value in RAM whose address is in register n
                 registros[d] = memory[registros[n]];
             } else if (op == 9) {
                 // 9dn means set the value in RAM whose address is in register n to the value of register d
                 memory[registros[n]] = registros[d];
             } else if (op == 0) {
                 // 0dn means goto the location in register d unless register n contains 0
                 if (registros[n] != 0) {
                     pc = registros[d];
                 }
             }
         }
         System.out.println(count);

     }
}


