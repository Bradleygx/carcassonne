package br.ufpb.dcx.aps.carcassone;

public class Jogador {
	
	private Cor cor;
	private int meeplesForaDojogo;
	private int meeplesNojogo;
	protected Jogador(Cor cor){
		this.cor=cor;
		this.meeplesForaDojogo=7;
		this.meeplesNojogo=0;
	}
	public Cor getCor() {
		return cor;
	}
	public int getMeeplesForaDojogo() {
		return meeplesForaDojogo;
	}
	public int getMeeplesNojogo() {
		return meeplesNojogo;
	}
	public String toString(){
		return cor+"("+meeplesNojogo+","+meeplesForaDojogo+")";
		
	}

}
