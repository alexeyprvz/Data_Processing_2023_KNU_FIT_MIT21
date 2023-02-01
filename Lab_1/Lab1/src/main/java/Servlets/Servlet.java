package Servlets;

import Entity.Entity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Entity entity = new Entity("Бліндаж", "imgs/1.png");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        out.println("["+entity+"]");
    }
}
