package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private BolsaDeTiles tiles;
	private Tile proximoTile;
	private boolean tilePosicionado;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");
	private String status ="Em_Andamento";
	private String statusTurno= "Tile_Posicionado";
	private Jogador[] jogadores;
	private Jogador jogadorAtual;

	Partida(BolsaDeTiles tiles,Jogador[] jogadores) {
		this.tiles = tiles;
		this.jogadores=jogadores;
		pegarProximoTile();
		jogadorAtual=jogadores[0];
	}
	public String getStatus(){
		return this.status;
	}
	public String toStringJogadores(){
		String texto="";
		for(int x=0;x<jogadores.length;x++){
			if(x==jogadores.length-1){
				texto+= jogadores[x].toString();
			}else{
				texto+=(jogadores[x].toString()+"; ");
			}		
		}
		return texto;
		
	}

	public String relatorioPartida() {
		return "Status: " + status + "\nJogadores: " +toStringJogadores();
	}

	public String relatorioTurno() {
		return "Jogador: " + jogadorAtual.getCor() + "\nTile: " + proximoTile.toString() + "\nStatus: " + statusTurno;
	}

	public Partida girarTile() {
		proximoTile.girar();
		return this;
	}

	private void pegarProximoTile() {
		proximoTile = tiles.pegar();
		proximoTile.reset();
	}

	public Partida finalizarTurno() {
		pegarProximoTile();
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		return this;
	}

	public Partida posicionarMeepleEstrada(Lado lado) {
		return this;
	}

	public Partida posicionarMeepleCampo(Vertice vertice) {
		return this;
	}

	public Partida posicionarMeepleCidade(Lado lado) {
		return this;
	}

	public Partida posicionarMeepleMosteiro() {
		return this;
	}

	public String getEstradas() {
		return null;
	}

	public String getCampos() {
		return null;
	}

	public String getCidades() {
		return null;
	}

	public String getMosteiros() {
		return null;
	}

	public String relatorioTabuleiro() {
		return proximoTile.toString();
	}
}
