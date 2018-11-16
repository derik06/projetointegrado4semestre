package models;


public class RelatorioAgrupado {
	private String data;
	private int consumo;
	private double valor;
	private String intervaloTempo;
	
	public RelatorioAgrupado() {
		
	}
	
	public RelatorioAgrupado(String data, int consumo, double valor, String intervaloTempo) {
		this.data = data;
		this.consumo = consumo;
		this.valor = valor;
		this.intervaloTempo = intervaloTempo;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	public String getIntervaloTempo() {
		return intervaloTempo;
	}
	public void setIntervaloTempo(String intervaloTempo) {
		this.intervaloTempo = intervaloTempo;
	}
}