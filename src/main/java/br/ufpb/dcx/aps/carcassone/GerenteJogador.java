package br.ufpb.dcx.aps.carcassone;

public class GerenteJogador {
	private Jogador[] jogadores;
	private Jogador jogadorAtual;
	
	public GerenteJogador(Cor[] cores){
		criarJogadores(cores);
		
	}
	
	public void criarJogadores(Cor[] cores){
		Jogador jogadores[]=new Jogador[cores.length];
		for(int x=0;x < cores.length; x++){
			
			jogadores[x]=new Jogador(cores[x]);
		}
		this.jogadores=jogadores;
		jogadorAtual=jogadores[0];
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
	public Cor getCorAtual(){
		return jogadorAtual.getCor();
	}
	public void setJogadorAtual(int turnoAtual){
		jogadorAtual=jogadores[(turnoAtual-1)%jogadores.length];
	}

}
