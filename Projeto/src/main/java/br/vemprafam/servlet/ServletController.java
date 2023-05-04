package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoProduto;
import br.vemprafam.logica.Logica;
import br.vemprafam.logica.LogicaCadastro;
import br.vemprafam.pojo.Produto;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String className = "br.vemprafam.logica.Logica" + op;
		try {
			Class<?> classe = Class.forName(className);
			Logica logica = (Logica)classe.getDeclaredConstructor().newInstance();
			String pagina = logica.executar(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
