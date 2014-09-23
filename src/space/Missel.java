package space;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Missel {
    
    private Image imagem;
    private int x,y;
    private int largura,altura;
    private boolean isVisivel;
    
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 15 ;
    
   
    public Missel(int x, int y){
        
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("res//missel.png");
        imagem = referencia.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        isVisivel = true;
        
        
    }

    public void mexer(){
        this.x += VELOCIDADE;
        
        
        if(this.x > LARGURA_TELA){
            isVisivel = false;
        }
        
    }
    
    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean isVisivel(){
        return isVisivel;
    }
    public Rectangle getBounds(){
       
        return new Rectangle(x,y,largura,altura);
        
    }

    public void setVisivel(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
