package entity;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class InimigoFacil extends Inimigos {
    
    private static final int LARGURA_TELA = 800;
    private static final int VELOCIDADE = 1 ;
    private static int contador = 0;

    public InimigoFacil(int x, int y) {
        super(x, y);
        setX(x);
        setY(y);

        setImagem();
    }
    
    @Override
        public void mexer(){
        if(getX() < 0){
            setX(LARGURA_TELA);
        
        }else{
            setX(getX()-VELOCIDADE);
            
        }
        
    }
    
    @Override
    public void setImagem(){
              ImageIcon referencia = null;
        if(contador++ %3==0){
        referencia = new ImageIcon("res//inimigo1.png");
        }else if(contador++ %2==0){
        referencia = new ImageIcon("res//inimigo2.png");
        }else{
        referencia = new ImageIcon("res//inimigo3.png");
        }
        setVisivel(true);
        
        setImagem(referencia.getImage());
        
        setAltura(getImagem().getHeight(null));
        setLargura(getImagem().getHeight(null));

        setVisivel(true); 
    }
        
    
}
