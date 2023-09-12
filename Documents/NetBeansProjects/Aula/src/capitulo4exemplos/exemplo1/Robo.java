
package capitulo4exemplos.exemplo1;

/**
 *
 * @author dtic
 */
import java.awt.Toolkit;
public class Robo {

    String modelo;
    String cor;
    int ano;
    String nSerie;
    boolean ligado;
    float direcao;
    float velocidade;
    
    
    void ligar(){
        ligado = true;
        velocidade =0;
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Robo andando!");
    }
    
    void desligar(){
        ligado = false;
        velocidade =0;
        System.out.println("Robo desligado!");
    }
    
    void andar(){
        velocidade = 2;
    }
    
    void parar(){
        velocidade = 0;
    }
    
    void virar(){
        
        direcao = direcao + 1;
        if(direcao == 360){
            direcao = 0;
        }
    }
    
}
