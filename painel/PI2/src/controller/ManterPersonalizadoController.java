package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.RelatorioBLL;
import bll.RelatorioDetalhadoBLL;
import models.Relatorio;
import models.RelatorioDetalhado;

/**
 * Servlet implementation class ManterPersonalizadoController
 */
@WebServlet("/ManterPersonalizado.do")
public class ManterPersonalizadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pDtInicial = request.getParameter("dt_inicial");
		String pDtFim = request.getParameter("dt_fim");
		
		RelatorioBLL relatorioBLL = new RelatorioBLL();
		RelatorioDetalhadoBLL relatorioDetalhadoBLL = new RelatorioDetalhadoBLL();
		
		Relatorio relatorio = relatorioBLL.carregar(pDtInicial, pDtFim);
		ArrayList<RelatorioDetalhado> relatorioDetalhadoLista = relatorioDetalhadoBLL.carregar(pDtInicial, pDtFim);
		
		request.setAttribute("relatorio", relatorio);
		request.setAttribute("relatorioDetalhadoLista", relatorioDetalhadoLista);
		RequestDispatcher view = request.getRequestDispatcher("Personalizado.jsp");         
		view.forward(request, response);
	}
}
