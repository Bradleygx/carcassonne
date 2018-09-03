package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class GerenteTile {

	private BolsaDeTiles tiles;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");
	private int count;
	private boolean semTile;
	private boolean tilePosicionado;
	private Tile proximoTile;
	public GerenteTile(BolsaDeTiles tiles){
		this.tiles=tiles;
		pegarProximoTile();
	}
	public boolean statusTile(){
		return tilePosicionado;
	}
	public String proximoTileString(){
		return proximoTile.toString();
	}
	
	protected void pegarProximoTile() {
		count++;
		proximoTile = tiles.pegar();
		if(proximoTile!=null){
			proximoTile.reset();
		}
		else{
			semTile=true;
		}
		if(count==1){
			tabuleiro.adicionarPrimeiroTile(proximoTile);
			tilePosicionado=true;
		}
	}
	public void inicioDoTurno() {
		tilePosicionado=false;
		pegarProximoTile();
		
	}
	public void posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		if(tilePosicionado){
			throw new ExcecaoJogo("Não pode reposicionar tile já posicionado");
		}
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		tilePosicionado=true;
	}
	public String relatorioTabuleiro() {
		return tabuleiro.toString();

	}
	public void isPosicionado(){
		if(tilePosicionado){
			throw new ExcecaoJogo("Não pode girar tile já posicionado");
		}
	}
	public void isPrimeiroTurno(){
		if(count==1){
			throw new ExcecaoJogo("Não pode girar tile já posicionado");
		}
	}
	public void girarTile(){
		proximoTile.girar();
	}
	public boolean acabouTiles(){
		return semTile;
	}
	public int getTurnoAtual(){
		return count;
	}
	public String getStatusTabuleiro(){
		return tabuleiro.toString();
	}
}
