package entity;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Missel implements InterfaceMisselInimigos{
    
    private Image imagem;
    private int x,y;
    private int largura,altura;
    private boolean isVisivel;
    
    protected static final int LARGURA_TELA = 800;
    protected static final int VELOCIDADE = 10 ;
    
   
    public Missel(int x, int y){
        
        setX(x);
        setY(y);    
    }
    
    
    
    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem){
        this.imagem=imagem;
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

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
    public Rectangle getBounds(){
       
        return new Rectangle(x,y,largura,altura);
        
    }

    public void setVisivel(boolean b) {
        this.isVisivel=b;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    
}
