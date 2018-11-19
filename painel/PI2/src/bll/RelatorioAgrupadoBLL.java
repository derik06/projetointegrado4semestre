package bll;

import java.util.ArrayList;

import dal.RelatorioAgrupadoDAL;
import models.RelatorioAgrupado;

public class RelatorioAgrupadoBLL {
	RelatorioAgrupadoDAL dal = new RelatorioAgrupadoDAL();
	
	public ArrayList<RelatorioAgrupado> carregar(int pMes, int pAno){
		
		String dtInicial = "";
		String dtFim = "";
		
		switch (pMes) {
	        case 5:
	        case 7:
	        	dtInicial = pAno+"-0"+(pMes-1)+"-30 23.59.59";
	    		dtFim = pAno+"-0"+(pMes+1)+"-01 00.00.00";
	            break;
	        case 10:
	        	dtInicial = pAno+"-"+(pMes-1)+"-30 23.59.59";
	    		dtFim = pAno+"-"+(pMes+1)+"-01 00.00.00";
	            break;
	        case 2:
	        case 4:
	        case 6:
	        case 8:
	        case 9:
	        	dtInicial = pAno+"-0"+(pMes-1)+"-31 23.59.59";
	    		dtFim = pAno+"-0"+(pMes+1)+"-01 00.00.00";
	            break;
	        case 11:
	        	dtInicial = pAno+"-"+(pMes-1)+"-31 23.59.59";
	    		dtFim = pAno+"-"+(pMes+1)+"-01 00.00.00";
	            break;
	        case 12:
	        	dtInicial = pAno+"-"+(pMes-1)+"-30 23.59.59";
	    		dtFim = (pAno+1)+"-01-01 00.00.00";
	            break;
	        case 1:
	        	dtInicial = (pAno-1)+"-12-31 23.59.59";
	        	dtFim = pAno+"-"+(pMes+1)+"-01 00.00.00";
	            break;
	        case 3:
	        	if(pAno%4 == 0) {
	        		dtInicial = pAno+"-0"+(pMes-1)+"-29 23.59.59";	
	        	}else {
	        		dtInicial = pAno+"-0"+(pMes-1)+"-28 23.59.59";
	        	}
	    		dtFim = pAno+"-0"+(pMes+1)+"-01 00.00.00";
	            break;
		}
		
		return dal.carregar(dtInicial, dtFim);
	}
}
