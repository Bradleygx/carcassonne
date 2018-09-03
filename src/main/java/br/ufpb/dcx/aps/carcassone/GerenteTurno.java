package br.ufpb.dcx.aps.carcassone;

public class GerenteTurno {
	private String statusTurno;
	private String statusPartida;
	private String statusPartida2;
	public GerenteTurno(){
		this.statusTurno= "Tile_Posicionado";
		this.statusPartida ="Em_Andamento";
		this.statusPartida2 ="Partida_Finalizada";
	}
	
	public String getStatusPartidaEmAndamento() {
		return statusPartida;
	}
	public String getStatusPartidaFinalizada() {
		return statusPartida2;
	}
	public void setStatusTurnoInicial(){
		statusTurno="Início_Turno";
	}
	public void setStatusTurnoPosicionado(){
		statusTurno="Tile_Posicionado";
	}
	public String getStatusTurno(){
		return statusTurno;
	}

}
