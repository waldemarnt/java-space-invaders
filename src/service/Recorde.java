package service;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Waldema
 */
public class Recorde extends JInternalFrame{
private String nome;
private int posicao;
private short pontos;
private Image fundo;

   public Recorde(String nome,short pontos){
       setNome(nome);
       setPontos(pontos);
       
       
   }
   
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getPontos() {
        return pontos;
    }

    public void setPontos(short pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return " " + nome + ", Pontos: " + pontos ;
    }
    }

