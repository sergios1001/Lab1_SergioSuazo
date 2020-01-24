
package lab1_sergiosuazo;

import java.util.Scanner;

public class Lab1_SergioSuazo {

    static Scanner leer=new Scanner(System.in);
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
    
}
