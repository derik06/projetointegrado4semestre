package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.RelatorioAgrupado;

public class RelatorioAgrupadoDAL {
	public ArrayList<RelatorioAgrupado> carregar(String dtInicial, String dtFim) {
		ArrayList<RelatorioAgrupado> relatorioAgrupadoLista = new ArrayList<RelatorioAgrupado>();
		
		String query =  "SELECT\r\n" + 
						"	DT_INICIO,\r\n" + 
						"	SUM(CONSUMO) AS CONSUMO,\r\n" + 
						"   SUM(VALOR) AS VALOR,\r\n" + 
						"   SUM(INTERVALO_TEMPO) AS INTERVALO_TEMPO\r\n" + 
						"FROM \r\n" + 
						"	`tb_fato_led`\r\n" + 
						"WHERE \r\n" + 
						"	DT_INICIO > '"+dtInicial+"'\r\n" + 
						"   AND DT_FIM < '"+dtFim+"'\r\n" + 
						"GROUP BY \r\n" + 
						"    year(DT_INICIO), \r\n" + 
						"    month(DT_INICIO), \r\n" + 
						"    day(DT_INICIO)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(query);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					RelatorioAgrupado relatorioAgrupado = new RelatorioAgrupado();
					relatorioAgrupado.setData(rs.getString("DT_INICIO"));
					relatorioAgrupado.setConsumo(rs.getInt(("CONSUMO")));
					relatorioAgrupado.setValor(rs.getDouble("VALOR"));
					relatorioAgrupado.setIntervaloTempo(rs.getString("INTERVALO_TEMPO"));
					relatorioAgrupadoLista.add(relatorioAgrupado);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return relatorioAgrupadoLista;
	}
}
