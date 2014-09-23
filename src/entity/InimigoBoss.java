package entity;

import javax.swing.ImageIcon;

/**
 *
 * @author Waldema
 */
public class InimigoBoss extends Inimigos{

    private static final int LARGURA_TELA = 1000;
    private static final int VELOCIDADE = 5 ;

    public InimigoBoss(int x, int y) {
        super(x, y);
        setX(x);
        setY(y);
    setImagem();
    }
    
    @Override
    public void mexer() {
      if(getX() < 0){
            setX(LARGURA_TELA);
        }else{
            setX(getX()-VELOCIDADE);
            
        }
    }

    @Override
    public void setImagem() {
  ImageIcon referencia = null;
        referencia = new ImageIcon("res//inimigoBoss.png");
        
        setImagem(referencia.getImage());
        
        setAltura(getImagem().getHeight(null));
        setLargura(getImagem().getHeight(null));

        setVisivel(true);     }
    
    
    
}
