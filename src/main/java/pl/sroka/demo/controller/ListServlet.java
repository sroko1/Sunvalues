package pl.sroka.demo.controller;


import pl.sroka.demo.dao.TabelaTestowaDao;
import pl.sroka.demo.model.TabelaTestowa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tabelaTestowaList(request, response);
    }

    public void tabelaTestowaList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TabelaTestowaDao ttDao = new TabelaTestowaDao();


        try {
            List<TabelaTestowa> tabelaTestowaList = ttDao.list();
            request.setAttribute("tabelaTestowaList", tabelaTestowaList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("tabela_testowa"));

        request.setAttribute("selectedId", id);
        tabelaTestowaList(request, response);

    }
}
