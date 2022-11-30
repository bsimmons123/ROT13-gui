package org.example.servlets;

import com.google.gson.Gson;
import org.example.model.HashedValue;
import org.example.model.ROT13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/cipher.start")
public class CipherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String values = req.getParameter("input_value"); // getting values from JSP page
        // Used to store Json data
        HashedValue hashedValue = new HashedValue();
        // Set hashedValue in JsonModel
        hashedValue.setValue(hashIndexedValues(hashValues(values)));
        // create JSON
        Gson gson = new Gson();
        String json = gson.toJson(hashedValue);// write output back in JSON format
        // write back to page
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
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
        for (Integer indexValue : indexValues) {
            hashedIndexValues.add((indexValue + 13) % 26);
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
