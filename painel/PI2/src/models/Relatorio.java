package models;

public class Relatorio {
	private int consumo;
	private double valor;
	private String intervaloTempo;
	
	public Relatorio(){
		
	}
	
	public Relatorio(int consumo, double valor, String intervaloTempo) {
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
	public String getIntervaloTempo() {
		return intervaloTempo;
	}
	public void setIntervaloTempo(String intervaloTempo) {
		this.intervaloTempo = intervaloTempo;
	}
}