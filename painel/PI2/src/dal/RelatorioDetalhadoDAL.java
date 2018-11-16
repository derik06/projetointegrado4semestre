package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.RelatorioDetalhado;

public class RelatorioDetalhadoDAL {
	public ArrayList<RelatorioDetalhado> carregar(String dtInicial, String dtFim) {
		ArrayList<RelatorioDetalhado> relatorioDetalhadoLista = new ArrayList<RelatorioDetalhado>(); 
		
		String query =  "SELECT\r\n" + 
						"	 B.ID_LED,\r\n" + 
						"    B.POTENCIA,\r\n" + 
						"    SUM(A.CONSUMO) AS CONSUMO,\r\n" + 
						"    SUM(A.VALOR) AS VALOR,\r\n" + 
						"    SUM(A.INTERVALO_TEMPO) AS INTERVALO_TEMPO\r\n" + 
						"FROM \r\n" + 
						"	tb_fato_led A\r\n" + 
						"    	INNER JOIN tb_led B\r\n" + 
						"        	ON A.ID_LED = B.ID_LED \r\n" + 
						"WHERE \r\n" + 
						"	A.DT_INICIO > '"+dtInicial+"'\r\n" + 
						"    AND A.DT_FIM < '"+dtFim+"'\r\n" + 
						"GROUP BY \r\n" + 
						"	ID_LED";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(query);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					RelatorioDetalhado relatorioDetalhado = new RelatorioDetalhado();
					relatorioDetalhado.setIdLed(Integer.parseInt("ID_LED"));
					relatorioDetalhado.setPotencia(Integer.parseInt("POTENCIA"));
					relatorioDetalhado.setConsumo(Integer.parseInt("CONSUMO"));
					relatorioDetalhado.setValor(Double.parseDouble("VALOR"));
					relatorioDetalhado.setIntervaloTempo("INTERVALO_TEMPO");
					relatorioDetalhadoLista.add(relatorioDetalhado);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return relatorioDetalhadoLista;
	}
}
