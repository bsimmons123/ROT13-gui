package org.example.servlets;

import org.example.model.ROT13;
import org.omg.CORBA.INTERNAL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/cypher.start")
public class CypherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String values = req.getParameter("input-value"); // getting values from JSP page

        req.setAttribute("hashedValues", hashIndexedValues(hashValues(values)));
        doGet(req, resp);
    }

    private ArrayList<Integer> hashValues(String values){
        ArrayList<Integer> indexValues = new ArrayList<>();
        for (char hashVal:  values.toCharArray()) {
            int hashedIndexValue = ROT13.CYPHER.hash.indexOf(hashVal);
            if (hashedIndexValue >= 0){
                indexValues.add(hashedIndexValue);
            }
        }
        ArrayList<Integer> hashedIndexValues = new ArrayList<>();
        for(int i = 0; i < indexValues.size(); i++){
            hashedIndexValues.add((indexValues.get(i)+13)%26);
        }

        return hashedIndexValues;
    }

    private String hashIndexedValues(ArrayList<Integer> hashedIndexValues){
        String hashedValues = "";
        for (int value: hashedIndexValues) {
            hashedValues += ROT13.CYPHER.hash.subSequence(value, value+1);
        }
        return hashedValues;
    }
}
