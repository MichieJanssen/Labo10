package ui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        if(command == null) {
            command = "home";
        }
        switch (command) {
            case "vergeet":
                destination = vergeet(request, response);
                break;
            case "setNaamCookie":
                destination = setNaamCookie(request, response);
                break;
            case "hallo":
                destination = hallo(request, response);
                break;
            case "home":
                destination = home(request, response);
                break;
            case "more":
                destination = "more.jsp";
                break;
            case "setCookie":
                destination = setCookie(request, response);
                break;
            default:
                destination = home(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    private String vergeet(HttpServletRequest request, HttpServletResponse response) {
        Cookie c = getCookie(request, "naam");
        if(c != null) {
            c.setMaxAge(0);
            c.setPath("/");
            response.addCookie(c);
        }
        return hallo(request, response);
    }

    private String hallo(HttpServletRequest request, HttpServletResponse response) {
        Cookie naamCookie = getCookie(request, "naam");
        if (naamCookie == null) {
            request.setAttribute("naam", "vreemdeling");
            request.setAttribute("naamLeeg", "yes");
        } else {
            request.setAttribute("naam", naamCookie.getValue());
            request.setAttribute("naamLeeg", "no");
        }
        return "hallo.jsp";
    }

    //Je cookie wordt hier gemaakt met ofwel yes ofwel no als je gebruiker het formulier submit
    private String setCookie(HttpServletRequest request, HttpServletResponse response) {
        String quote = null;
        quote = request.getParameter("quote");
        Cookie cookie = new Cookie("quote", quote);
        response.addCookie(cookie);
        request.setAttribute("quote", quote);

        return "index.jsp";
    }

    //Je gaat kijken of je cookie no of yes is en daarvan ga je je cookie plaatsen
    private String home(HttpServletRequest request, HttpServletResponse response) {
        Cookie quoteCookie = getCookie(request, "quote");
        if(quoteCookie == null || quoteCookie.getValue().equals("no")) {
            request.setAttribute("quote", "no");
        } else {
            request.setAttribute("quote", "yes");
        }
        return "index.jsp";
    }

    //Kijken in lijst of je cookie erin zit die aangemaakt was in setCookie, je kan geen getCookie van een cookie doen!
    private Cookie getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            return null;
        }
        //Kijken of de naam overeenkomt met de attribute die gezet is in setCookie
        for(Cookie c : cookies) {
            if(c.getName().equals(key)) {
                return c;
            }
        }
        return null;
    }

    private String setNaamCookie(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");

        Cookie c = new Cookie("naam", naam);
        c.setMaxAge(168*60*60);
        c.setPath("/");
        response.addCookie(c);
        request.setAttribute("naam", naam);

        return "hallo.jsp";
    }
}