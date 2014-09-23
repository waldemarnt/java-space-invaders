/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Waldema
 */
public class ContaTempo {
     
    private long inicio = 0;  
  
    // Construtor - também ativa o cronometro.  
    public ContaTempo() {  
    inicio = System.currentTimeMillis();  
    }  
  
    // retorna tempo em segundos   
    // não interrompe o cronometro, pode ser chamado várias vezes  
    public long getAtual() {  
        long mili = System.currentTimeMillis() - inicio;  
        return Math.round(mili / 1000.0);  
    }
    }
