/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Andrés Felipe
 */
public class Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Workbook book = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Hoja 1");
        FileOutputStream fileout;
        int[][] matriz = new int[2000][25];

        for (int x = 0; x < 2000; x++) {
            int b = 0;
            int i = 0;
            int n = 0;
            int g = 0;
            int o = 0;
            //Lista de Verificación B
            int[] verificacionb = new int[50];
            int contb = 0;
            //Lista de Verificación I
            int[] verificacioni = new int[50];
            int conti = 0;
            //Lista de Verificación N
            int[] verificacionn = new int[50];
            int contn = 0;
            //Lista de Verificación G
            int[] verificaciong = new int[50];
            int contg = 0;
            //Lista de Verificación O
            int[] verificaciono = new int[50];
            int conto = 0;
            for (int j = 0; j < 25; j++) {
                if (matriz[x][j] == 0) {

                    if (j < 5) {
                        //Verificación                      
                        boolean check = true;
                        while (check) {
                            check = false;
                            b = (int) (Math.random() * (15 - 1 + 1) + 1);

                            for (int m = 0; m < verificacionb.length; m++) {
                                if (verificacionb[m] == b) {
                                    check = true;
                                }
                            }
                            verificacionb[contb] = b;
                        }
                        matriz[x][j] = b;
                        contb++;

                    }
                    if (j >= 5 && j < 10) {
                        //Verificación                      
                        boolean check = true;
                        while (check) {
                            check = false;
                            i = (int) (Math.random() * (30 - 16 + 1) + 16);

                            for (int m = 0; m < verificacioni.length; m++) {
                                if (verificacioni[m] == i) {
                                    check = true;
                                }
                            }
                            verificacioni[conti] = i;
                        }
                        matriz[x][j] = i;
                        conti++;

                    }
                    if (j >= 10 && j < 15) {
                        //Verificación                      
                        //Verificación                      
                        boolean check = true;
                        while (check) {
                            check = false;
                            n = (int) (Math.random() * (45 - 31 + 1) + 31);

                            for (int m = 0; m < verificacionn.length; m++) {
                                if (verificacionn[m] == n) {
                                    check = true;
                                }
                            }
                            verificacionn[contn] = n;
                        }
                        matriz[x][j] = n;
                        contn++;

                    }
                    if (j >= 15 && j < 20) {
                        //Verificación                      
                        boolean check = true;
                        while (check) {
                            check = false;
                            g = (int) (Math.random() * (60 - 46 + 1) + 46);

                            for (int m = 0; m < verificaciong.length; m++) {
                                if (verificaciong[m] == g) {
                                    check = true;
                                }
                            }
                            verificaciong[contg] = g;
                        }
                        matriz[x][j] = g;
                        contg++;

                    }
                    if (j >= 20) {
                        //Verificación                      
                        boolean check = true;
                        while (check) {
                            check = false;
                            o = (int) (Math.random() * (75 - 61 + 1) + 61);

                            for (int m = 0; m < verificaciono.length; m++) {
                                if (verificaciono[m] == o) {
                                    check = true;
                                }
                            }
                            verificaciono[conto] = o;
                        }
                        matriz[x][j] = o;
                        conto++;

                    }

                }
            }
        }

        //Aquí se ordena
        for (int i = 0; i < 2000; i++) {
            int aux = 0;

            for (int x = 0; x < 25; x++) {
                for (int k = 0; k < 25 - 1; k++) {
                    if (matriz[i][k] > matriz[i][k + 1]) {
                        aux = matriz[i][k];
                        matriz[i][k] = matriz[i][k + 1];
                        matriz[i][k + 1] = aux;
                    }

                }
            }

        }
        
        

        //Concatenación
        String[] lista = new String[2000];

        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 25; j++) {
                if (lista[i] == null) {
                    lista[i] = "";
                }
                lista[i] = lista[i] + (String.valueOf(matriz[i][j]));
            }
        }
                    
        //Imprimir Concatenación
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
        
        
        //Verificación concatenación
        for (int i = 0; i < lista.length; i++) {
            for (int j = 0; j < lista.length; j++) {
                if (i != j) {
                    if (lista[i] == lista[j]) {
                        System.out.println("SE REPITIÓ EL TABLERO");
                    }
                }
            }
        }

        //Imprimir Matriz
//        for (int x = 0; x < matriz.length; x++) {
//            System.out.print("|");
//            for (int y = 0; y < matriz[x].length; y++) {
//                System.out.print(matriz[x][y]);
//                if (y != matriz[x].length - 1) {
//                    System.out.print("\t");
//                }
//            }
//            System.out.println("|");
//        }

        //Insertar datos en el excel
        for (int i = 0; i < 2000; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 25; j++) {
                row.createCell(j).setCellValue(matriz[i][j]);
            }
        }

        try {
            fileout = new FileOutputStream("Excel.xlsx");
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
