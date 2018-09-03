package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class GerentePartida {
	
	private GerenteTurno gerenteTurno;
	private GerenteTile gerenteTile;
	private GerenteJogador gerenteJogador;

	
	public GerentePartida(BolsaDeTiles tiles,Cor[] cores){
		gerenteTurno=new GerenteTurno();
		gerenteTile=new GerenteTile(tiles);
		gerenteJogador=new GerenteJogador(cores);
	}
	
	public String relatorioPartida() {
		if(!gerenteTile.acabouTiles()){
			return "Status: " + gerenteTurno.getStatusPartidaEmAndamento() + "\nJogadores: " +toStringJogadores();
		}
		return "Status: " + gerenteTurno.getStatusPartidaFinalizada() + "\nJogadores: " +toStringJogadores();
	}
	public String relatorioTurno() {
		if(gerenteTile.acabouTiles()){
			throw new ExcecaoJogo("Partida finalizada");
		}
		if(gerenteTile.statusTile()){
			gerenteTurno.setStatusTurnoPosicionado();
		}
		return "Jogador: " + gerenteJogador.getCorAtual() + "\nTile: " + gerenteTile.proximoTileString() + "\nStatus: " + gerenteTurno.getStatusTurno();
	}
	public void girarTile() {
		gerenteTile.isPosicionado();
		if(gerenteTile.acabouTiles()){
			throw new ExcecaoJogo("Não pode girar tiles com a partida finalizada");
		}
		gerenteTile.isPrimeiroTurno();
		gerenteTile.girarTile();
	}
	protected void pegarProximoTile() {
		gerenteTile.pegarProximoTile();
	}
	public void finalizarTurno() {
		gerenteTile.inicioDoTurno();
		gerenteTurno.setStatusTurnoInicial();
		gerenteJogador.setJogadorAtual(gerenteTile.getTurnoAtual());
	}
	public void posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		gerenteTile.posicionarTile(tileReferencia, ladoTileReferencia);
	}
	public String relatorioTabuleiro() {
		return gerenteTile.getStatusTabuleiro();

	}
	public String toStringJogadores(){
		return gerenteJogador.toStringJogadores();
	}

}
