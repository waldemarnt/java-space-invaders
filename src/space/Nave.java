package space;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Nave {

    private int x, y;
    private int dx, dy;
    private int naveVelocidade=5;
    private Image imagem;
    private int altura , largura;
    private List<Missel> misseis;
    private boolean isVisivel;
    
    

    public Nave() {

        ImageIcon referencia = new ImageIcon("res//nave.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura= imagem.getWidth(null);
        
        misseis = new ArrayList<Missel>();
        
        
        this.x = 100;
        this.y = 100;

    }

    public boolean isIsVisivel() {
        return isVisivel;
    }
    

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    public Rectangle getBounds(){
       
        return new Rectangle(x,y,largura,altura);
    }

    public void mexer() {

        x += dx;//1 e 462
        y += dy;//1 e 340
        if(this.x <1){
            x = 1;
        }
        if(this.x>400){
            x=400;
        }
        
        if(this.y< -30){
            y=-30;
        }
        if(this.y>300){
            y=300;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public void atira(){
        this.misseis.add(new Missel(x + largura,y + altura/2));
        
        
    }
    
    
    
    public void keyPressed(KeyEvent tecla) {

        int codigo = tecla.getKeyCode();

        
        if(codigo == KeyEvent.VK_SPACE){
            atira();
        }
        
        
        if (codigo == KeyEvent.VK_UP) {
            dy = -naveVelocidade;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = naveVelocidade;
        }


        if (codigo == KeyEvent.VK_LEFT) {
            dx = -naveVelocidade;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = naveVelocidade;
        }
    }

    public void keyReleased(KeyEvent tecla) {


        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }


        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public List<Missel> getMisseis() {
        return misseis;
    }

    
  
}
