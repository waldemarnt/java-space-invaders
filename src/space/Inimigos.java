package space;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Inimigos {
    
    private Image imagem;
    private int x,y;
    public int largura , altura;
    private boolean isVisivel;
    
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1 ;
    
   private static int contador = 0;
    
    public Inimigos(int x, int y){
        
        this.x = x;
        this.y = y;
        ImageIcon referencia = null;
        
        if(contador++ %3==0){
        referencia = new ImageIcon("res//inimigo1.png");
        }else{
        referencia = new ImageIcon("res//inimigo2.png");
        }
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        
        isVisivel = true;
        
        
    }
    public Rectangle getBounds(){
       
        return new Rectangle(x,y,largura,altura);
    }
    public void mexer(){
        if(this.x < 0){
            this.x = LARGURA_TELA;
            
        }else{
            this.x -= VELOCIDADE;
            
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

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
    
}
