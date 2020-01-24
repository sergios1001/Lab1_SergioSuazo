
package lab1_sergiosuazo;

import java.util.Scanner;
import java.util.Random;

public class Lab1_SergioSuazo {

    static Scanner leer=new Scanner(System.in);
    static Random rand=new Random();
    public static void main(String[] args) {
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
                    
                }
                case 3:
                {
                
                }   
            }
            System.out.println("Quiere escoger un nuevo ejercicio? (s/n)");
        }
    }
    
    public static void Hanoi(int disc,int origen,int aux,int destino)
    {
        if(disc==1)
        {
            System.out.println(" mover disco "+disc+" de "+origen+" a "+destino);
        }
        else
        {
            Hanoi(disc-1,origen,destino,aux);
            System.out.println(" mover disco "+disc+" de "+origen+" a "+destino);
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
            System.out.print(mat[i][j]);
        }
        else
        {
            if(i==j)
            {
                System.out.print(mat[i][j]);
            }
            else if(i+j==mat.length-1)
            {
                System.out.print(mat[i][j]);
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
