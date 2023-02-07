package Servlets;

import Crud.CrudInterface;
import Entity.Entity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    ServletConfigInterface servletConfig;
    CrudInterface crud;

    public Servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Entity entity = new Entity("Бліндаж", "imgs/1.png");

        ArrayList<Entity> data = new ArrayList<Entity>();
        data.add(crud.readEntity());

        String someJson = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String name = request.getParameter("name");
        String img = request.getParameter("img");

        crud.updateEntity(new Entity(name, img));
    }
}
