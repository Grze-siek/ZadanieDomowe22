package PrzelicznikTekstu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/textConverter")
public class TextConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("tekst");
        int numberOfWords = TextStats.numberOfWords(text);
        int numberOfChars = TextStats.numberOfAllChars(text);
        int numberOfCharsWithoutSpaces = TextStats.numberOfChars(text);
        boolean isPalindrom = TextStats.isPalindrom(text);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        response.getWriter().println(String.format("%s<br/>", text));
        response.getWriter().println(String.format("<h4>Ilość słów: %d</h4>", numberOfWords));
        response.getWriter().println(String.format("<h4>Ilość znaków: %d</h4>", numberOfChars));
        response.getWriter().println(String.format("<h4>Ilość znaków (bez spacji): %d</h4>", numberOfCharsWithoutSpaces));
        response.getWriter().println(String.format("<h4>Palindrom: %b</h4>", isPalindrom));
    }
}
