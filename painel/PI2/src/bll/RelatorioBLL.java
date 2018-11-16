package bll;

import dal.RelatorioDAL;
import models.Relatorio;

public class RelatorioBLL {
	RelatorioDAL dal = new RelatorioDAL();
	
	public Relatorio carregar(String dtInicial, String dtFim){
		return dal.carregar(dtInicial, dtFim);
	}
}
