package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Relatorio;

public class RelatorioDAL {
	public Relatorio carregar(String dtInicial, String dtFim) {
		Relatorio relatorio = new Relatorio();
		
		String query = "SELECT\r\n" + 
						"	 SUM(CONSUMO) AS CONSUMO,\r\n" + 
						"    SUM(VALOR) AS VALOR,\r\n" + 
						"    SUM(INTERVALO_TEMPO) AS INTERVALO_TEMPO\r\n" + 
						"FROM \r\n" + 
						"	 tb_fato_led\r\n" + 
						"WHERE \r\n" +  
						"	DT_INICIO >= '"+dtInicial+"'\r\n" + 
						"   AND DT_FIM <= '"+dtFim+"'";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(query);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					relatorio.setConsumo(rs.getInt("CONSUMO"));
					relatorio.setValor(rs.getDouble("VALOR"));
					relatorio.setIntervaloTempo(rs.getString("INTERVALO_TEMPO"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return relatorio;
	}
}
