package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.RelatorioAgrupadoBLL;
import models.RelatorioAgrupado;

import java.util.ArrayList;

/**
 * Servlet implementation class ManterPadraoController
 */
@WebServlet("/ManterPadrao.do")
public class ManterPadraoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pMes = Integer.parseInt(request.getParameter("mes"));
		int pAno = Integer.parseInt(request.getParameter("ano"));
		
		RelatorioAgrupadoBLL bll = new RelatorioAgrupadoBLL();
		ArrayList<RelatorioAgrupado> relatorioAgrupadoLista = bll.carregar(pMes, pAno);
		
		request.setAttribute("relatorioAgrupadoLista", relatorioAgrupadoLista);
		RequestDispatcher view = request.getRequestDispatcher("Padrao.jsp");         
		view.forward(request, response); 
	}
}
