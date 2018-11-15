package models;

import java.sql.Time;

public class Relatorio {
	private int consumo;
	private double valor;
	private Time intervaloTempo;
	
	public Relatorio(){
		
	}
	
	public Relatorio(int consumo, double valor, Time intervaloTempo) {
		this.consumo = consumo;
		this.valor = valor;
		this.intervaloTempo = intervaloTempo;
	}
	
	public int getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Time getIntervaloTempo() {
		return intervaloTempo;
	}
	public void setIntervaloTempo(Time intervaloTempo) {
		this.intervaloTempo = intervaloTempo;
	}
}