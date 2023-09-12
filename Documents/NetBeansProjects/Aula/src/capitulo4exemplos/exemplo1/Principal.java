/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package capitulo4exemplos.exemplo1;

/**
 *
 * @author dtic
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Robo robo1;
        robo1 = new Robo();
        
        robo1.modelo = "T1000";
        robo1.cor = "prata";
        robo1.ano  = 1992;
        robo1.nSerie = "T1000N0001";
        
        Robo robo2;
        robo2 = new Robo();
   
        robo2.modelo = "T1001";
        robo2.cor = "preto";
        robo2.ano  = 1993;
        robo2.nSerie = "T1001N0010";
        
        robo1.ligar();
        robo2.ligar();
        robo1.andar();
        robo2.andar();
        robo1.direcao = -robo2.direcao;
        robo1.desligar();
        robo2.desligar();
        
    }
    
}
