package br.ufpb.dcx.aps.carcassone;

public class Jogo {

	public Partida criarPartida(BolsaDeTiles tiles, Cor... sequencia) {
		if(tiles == null) {
			throw new ExcecaoJogo("A bolsa de tiles deve ser fornecida na criação de uma partida");
		}
		
		
		if(sequencia.length < 2) {
			throw new ExcecaoJogo("Cada partida deve ter uma sequência de pelo menos dois jogadores");
		}
		
		for(int x=0;x < sequencia.length; x++){
			for(int y=x+1; y<sequencia.length; y++){
				if(sequencia[x]==sequencia[y]) {
					throw new ExcecaoJogo("Não pode haver repetição de cores na sequência de jogadores");
				}
			}
		}
		
		
		
		return new Partida(tiles,sequencia);
	}



}
