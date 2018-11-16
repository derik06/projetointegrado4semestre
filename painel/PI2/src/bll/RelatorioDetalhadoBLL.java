package bll;

import java.util.ArrayList;

import dal.RelatorioDetalhadoDAL;
import models.RelatorioDetalhado;

public class RelatorioDetalhadoBLL {
	RelatorioDetalhadoDAL dal = new RelatorioDetalhadoDAL();
	
	public ArrayList<RelatorioDetalhado> carregar(String dtInicial, String dtFim){
		return dal.carregar(dtInicial, dtFim);
	}
}
