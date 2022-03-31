/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hallgatoi1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.err;
import static java.lang.System.out;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author serto
 */
public class Hallgatoi1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        beKi b = new beKi();
        b.be();
        b.ki();
    }
}
class beKi{
    float szam;
    public void be(){
    Scanner bill = new Scanner (System.in);
        try{
        FileOutputStream bki = new FileOutputStream("Teszt.bin");
        DataOutputStream ki = new DataOutputStream(bki);
        do{
            out.print("Kérek egy számot: ");
            try{
                szam = bill.nextInt();
                out.println(szam);
                ki.writeFloat(szam);
            }
            catch (InputMismatchException error){
                break;
            }
        }while(true);
        ki.close();
        }
        catch (IOException error){
            err.println("Írási hiba - " + error.getMessage());
        }
    }
    
    public void ki(){
        try{
            float num = 0, sum = 0; 
            FileInputStream bbe = new FileInputStream("Teszt.bin");
            DataInputStream be = new DataInputStream(bbe);
            boolean noteof = true;
            
            while (noteof){
                try{
                    szam = be.readFloat();
                    out.println(" " + szam);
                    sum += szam;
                    num++;
                }
                catch (EOFException e){ //Fájl vég
                    noteof = false;
                }
                
            }
            out.println("\nÁtalga  = " + sum/num);
        }
        
        catch (IOException error){
            err.println("Olvasási hiba - " + error.getMessage());
        }
    }
}