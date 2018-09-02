package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private BolsaDeTiles tiles;
	private Tile proximoTile;
	private Tile tileAnterior;
	private boolean tilePosicionado;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");
	private String status ="Em_Andamento";
	private String status2 ="Partida_Finalizada";
	private String statusTurno= "Tile_Posicionado";
	boolean partidaAcabou;
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
		if(!partidaAcabou){
			return "Status: " + status + "\nJogadores: " +toStringJogadores();
		}
		return "Status: " + status2 + "\nJogadores: " +toStringJogadores();
	}

	public String relatorioTurno() {
		if(partidaAcabou){
			throw new ExcecaoJogo("Partida finalizada");
		}
		return "Jogador: " + jogadorAtual.getCor() + "\nTile: " + proximoTile.toString() + "\nStatus: " + statusTurno;
	}

	public Partida girarTile() {
		proximoTile.girar();
		return this;
	}

	private void pegarProximoTile() {
		tileAnterior=proximoTile;
		proximoTile = tiles.pegar();
		if(proximoTile!=null){
			proximoTile.reset();
		}
		else{
			partidaAcabou=true;
		}
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
		if(proximoTile==null){
			return tileAnterior.toString();
		}
		return proximoTile.toString();
	}
}
