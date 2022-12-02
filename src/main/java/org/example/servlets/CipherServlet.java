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
        hashedValue.setValue(rot13(values));
        hashedValue.setOriginalValue(values);
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

    /**
     * Perform the ROT13 cipher
     *
     * author: <a href="https://stackoverflow.com/questions/8981296/rot-13-function-in-java">georgiecasey</a>
     *
     * @param input     Any string value
     * @return          Hashes output
     */
    public static String rot13(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }
}
