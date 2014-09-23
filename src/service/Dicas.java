package service;

/**
 *
 * @author Waldema
 */
public class Dicas {

    Dica dica;
    Dica id;

    public enum Dica {

        DICA1(1,"Apertando 'SHIFT' Você usa o poder especial, a cada nova fase você recebera uma carga"),
        DICA2(2,"O seu tempo interfere na sua pontuação então tente ser rápido!"),
        DICA3(3,"Apertando 'R' quando o jogo não estiver ativo você acessar o ranking"),
        DICA4(4,"Tome cuidado a partir do nivel 2 novos inimigos aparecerão");

        Dica(int id,String dica) {
            this.dicaEscolhida = dica;
            this.idEscolhido = (int) (id*Math.random());
        }
        private String dicaEscolhida;
        private int idEscolhido;
        
        public String getDicaEscolhida() {
            return dicaEscolhida;
        }
        public int getIdEscolhido(){
            return idEscolhido;
        }
    
       
    }

    
}
