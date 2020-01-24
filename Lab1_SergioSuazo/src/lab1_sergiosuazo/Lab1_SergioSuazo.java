
package lab1_sergiosuazo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class Lab1_SergioSuazo {

    static Scanner leer=new Scanner(System.in);
    static Random rand=new Random();
    static int cont=1;
    public static void main(String[] args) throws ParseException {
        char resp='s';
        while(resp=='s'||resp=='S')
        {
            System.out.println("Seleccione el ejercicio que quiere probar:\n"
                    + "1: Torre de Hanoi\n"
                    + "2: Diagonales\n"
                    + "3: Fechas\n");
            int n;
            n=leer.nextInt();
            switch(n)
            {
                case 1:
                {
                    System.out.print("Numero de discos: ");
                    int disc,paso=0;
                    disc=leer.nextInt();
                    Hanoi(disc,1,2,3);
                    cont=1;
                    break;
                }
                case 2:
                {
                    int size;
                    int[][]mat;
                    System.out.print("Ingrese tamaño de la matriz: ");
                    size=leer.nextInt();
                    mat=fillMatrix(size,size);
                    System.out.println("Matriz creada: ");
                    printMatrix(mat);
                    Diagonales(mat,0,0);
                    break;
                }
                case 3:
                {
                    String str;
                    System.out.print("Ingrese la cadena: ");
                    str=leer.next();
                    String[]token=str.split(",");
                    for (int i = 0; i < token.length; i++) 
                    {
                        String[]token2=token[i].split("/");
                        if(token2.length==3)
                        {
                            if(token2[1].equals("01")||token2[1].equals("03")||token2[1].equals("05")||token2[1].equals("07")||token2[1].equals("08")||token2[1].equals("10")||token2[1].equals("12"))
                            {
                                if(Integer.parseInt(token2[0])<=31)
                                {
                                    Date fecha;
                                    SimpleDateFormat fi=new SimpleDateFormat("dd/MM/yyyy");
                                    fecha=fi.parse(token[i]);
                                    System.out.println(fecha);
                                }
                            }
                            else if(token2[1].equals("02"))
                            {
                                if(Integer.parseInt(token2[0])<=28)
                                {
                                    Date fecha;
                                    SimpleDateFormat fi=new SimpleDateFormat("dd/MM/yyyy");
                                    fecha=fi.parse(token[i]);
                                    System.out.println(fecha);
                                }
                            }
                            else if(token2[1].equals("04")||token2[1].equals("06")||token2[1].equals("09")||token2[1].equals("11"))
                            {
                                if(Integer.parseInt(token2[0])<=30)
                                {
                                    Date fecha;
                                    SimpleDateFormat fi=new SimpleDateFormat("dd/MM/yyyy");
                                    fecha=fi.parse(token[i]);
                                    System.out.println(fecha);                                    
                                }
                            }
                        }
                    }
                    break;
                }   
            }
            System.out.println("Quiere escoger un nuevo ejercicio? (s/n)");
            resp=leer.next().charAt(0);
        }
    }
    
    public static void Hanoi(int disc,int origen,int aux,int destino)
    {
        if(disc==1)
        {
            System.out.println(cont+" mover disco "+disc+" de "+origen+" a "+destino);
            cont++;
        }
        else
        {
            Hanoi(disc-1,origen,destino,aux);
            System.out.println(cont+" mover disco "+disc+" de "+origen+" a "+destino);
            cont++;
            Hanoi(disc-1,aux,origen,destino);
        }
    }
    
    public static int[][] fillMatrix(int fila, int columna)
    {
        int[][]temp=new int[fila][columna];
        for(int i=0;i<fila;i++)
        {
            for(int j=0;j<columna;j++)
            {
                temp[i][j]=1+rand.nextInt(10);
            }
        }
        return temp;
    }
    
    public static void printMatrix(int[][]matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println();
        }
    }
    public static void Diagonales(int[][]mat,int i, int j)
    {
        if(i==mat.length-1&&j==mat.length-1)
        {
            System.out.println(" "+mat[i][j]);
        }
        else
        {
            if(i==j)
            {
                System.out.print(" "+mat[i][j]);
            }
            else if(i+j==mat.length-1)
            {
                System.out.print(" "+mat[i][j]);
            }
            if(i==mat.length-1)
            {
                Diagonales(mat, 0, j+1);
            }
            else
            {
                Diagonales(mat, i+1, j);
            }
        }
    }
}
