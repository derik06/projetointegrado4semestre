package models;

public class RelatorioDetalhado {
	private int idLed;
	private int potencia;
	private int consumo;
	private double valor;
	private String intervaloTempo;
	
	public RelatorioDetalhado() {
		
	}
	
	public RelatorioDetalhado(int idLed, int potencia, int consumo, double valor, String intervaloTempo) {
		this.idLed = idLed;
		this.potencia = potencia;
		this.consumo = consumo;
		this.valor = valor;
		this.intervaloTempo = intervaloTempo;
	}
	
	public int getIdLed() {
		return idLed;
	}
	public void setIdLed(int idLed) {
		this.idLed = idLed;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
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