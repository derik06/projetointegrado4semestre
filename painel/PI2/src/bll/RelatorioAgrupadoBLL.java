package bll;

import java.util.ArrayList;

import dal.RelatorioAgrupadoDAL;
import models.RelatorioAgrupado;

public class RelatorioAgrupadoBLL {
	RelatorioAgrupadoDAL dal = new RelatorioAgrupadoDAL();
	
	public ArrayList<RelatorioAgrupado> carregar(String dtInicial, String dtFim){
		return dal.carregar(dtInicial, dtFim);
	}
}
