package entity;

import javax.swing.ImageIcon;

public class InimigoMedio extends Inimigos{
  
    private static final int LARGURA_TELA = 800;
    private static final int VELOCIDADE = 4 ;
    private static int contador = 0;

    public InimigoMedio(int x, int y) {
        super(x, y);
        setX(x);
        setY(y);
    setImagem();
    }
    
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
        referencia = new ImageIcon("res//inimigo4.png");
        
        setImagem(referencia.getImage());
        
        setAltura(getImagem().getHeight(null));
        setLargura(getImagem().getHeight(null));

        setVisivel(true); 
    }
}
