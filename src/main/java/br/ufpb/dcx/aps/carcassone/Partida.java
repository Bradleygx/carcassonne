package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private GerentePartida gerente;

	Partida(BolsaDeTiles tiles,Cor[] cores) {
		gerente=new GerentePartida(tiles,cores);
	}
	public String toStringJogadores(){
		return gerente.toStringJogadores();
		
	}

	public String relatorioPartida() {
		return gerente.relatorioPartida();
	}

	public String relatorioTurno() {
		return gerente.relatorioTurno();
	}

	public Partida girarTile() {
		gerente.girarTile();
		return this;
	}

	public Partida finalizarTurno() {
		gerente.finalizarTurno();
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		gerente.posicionarTile(tileReferencia, ladoTileReferencia);
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
		return gerente.relatorioTabuleiro();

	}
	public int getQuantCampos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
