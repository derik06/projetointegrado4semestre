package models;

import java.sql.Time;
import java.util.Date;

public class RelatorioAgrupado {
	private Date data;
	private int consumo;
	private double valor;
	private Time intervaloTempo;
	
	public RelatorioAgrupado() {
		
	}
	
	public RelatorioAgrupado(Date data, int consumo, double valor, Time intervaloTempo) {
		this.data = data;
		this.consumo = consumo;
		this.valor = valor;
		this.intervaloTempo = intervaloTempo;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
