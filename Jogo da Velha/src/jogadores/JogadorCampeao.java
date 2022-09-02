package jogadores;

import java.util.Random;
import jogo.Tabuleiro;

public class JogadorCampeao extends Jogador {

    public JogadorCampeao(String nome){
        super(nome);
    }

    @Override
    public int[] jogar(int[][] tabuleiro) {
        int[] jogada = new int[2];
        boolean fuiPrimeiroJogador = false;
        
        int meuSimbolo = super.getSimbolo();
        int simboloOponente = verificaSimboloInimigo(meuSimbolo);
        
        if(verificaPrimeiroJogador(tabuleiro)){
            jogada[0] = 0;
            jogada[1] = 0;
            fuiPrimeiroJogador = true;
        }
        else if (fuiPrimeiroJogador == true){ 
            if(tabuleiro[0][2] == -1){
                jogada[0] = 0;
                jogada[1] = 2;
            }
            else if(tabuleiro[2][0] == -1){
                jogada[0] = 2;
                jogada[1] = 0;
            }
            else if(tabuleiro[2][2] == -1){
                jogada[0] = 2;
                jogada[1] = 2;
            }
            else{
                jogada = jogadaCentro(tabuleiro);
            }
        }
        else{
            if(tabuleiro[0][2] == -1){
                jogada[0] = 0;
                jogada[1] = 2;
            }
            else if(tabuleiro[2][0] == -1){
                jogada[0] = 2;
                jogada[1] = 0;
            }
            else if(tabuleiro[2][2] == -1){
                jogada[0] = 2;
                jogada[1] = 2;
            }
            else{
                jogada = jogadaCentro(tabuleiro);
            }
        }
        return jogada;
    }



    private int[] jogadaCentro(int[][] tabuleiro) {
        int[] jogada = new int[2];

        if(tabuleiro[0][1] == -1){
            jogada[0] = 0;
            jogada[1] = 1;
        }
        else if(tabuleiro[1][1] == -1){
            jogada[0] = 1;
            jogada[1] = 1;
        }
        else if(tabuleiro[2][1] == -1){
            jogada[0] = 2;
            jogada[1] = 1;
        }
        else{
            jogada = jogadaAleatoria(tabuleiro);
        }
        return jogada;
    }

    public int[] jogadaAleatoria (int[][] tabuleiro){
        int[] jogada = new int[2];
        Random r = new Random();
        int i;
        int j;
        for(int k = 0; k < tabuleiro.length*tabuleiro.length*10; k++){//1000 tentativas de jogadas válidas
            i = r.nextInt(tabuleiro.length);
            j = r.nextInt(tabuleiro.length);
            if(tabuleiro[i][j] == -1){
                jogada[0] = i;
                jogada[1] = j;
                return jogada;                
            }
        }
        return null;
    }

    public int verificaSimboloInimigo(int meuSimbolo){
        int simboloOponente;
        if(meuSimbolo == 1){
            simboloOponente = 0;
        }else{
            simboloOponente = 1;
        }
        return simboloOponente;
    }


    public boolean verificaPrimeiroJogador(int[][] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro.length; j++){
                if(tabuleiro[i][j] != -1){
                    return false;
                }
            }
        }
        return true;
    }
    
}
