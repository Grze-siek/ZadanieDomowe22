package KonwersjeMiar.WeightConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/KonwersjeMiar/WeightConverter")
public class WeightConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilograms = request.getParameter("kilograms");
        String grams = request.getParameter("grams");
        String milligrams = request.getParameter("milligrams");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        WeightCalculations calculate = new WeightCalculations();
        Map<String, String> weights = calculate.weightsToMap(kilograms, grams, milligrams);
        if(calculate.tooManyValues(weights)) {
            response.getWriter().println(String.format("Proszę wypełnić tylko jedno pole!"));
        }
        else {
            Map<String, Double> convertedWeights = calculate.calculateWeights(kilograms, grams, milligrams);
            double convertedKilograms = convertedWeights.get("kilograms");
            double convertedGrams = convertedWeights.get("grams");
            double convertedMilligrams = convertedWeights.get("milligrams");
            response.getWriter().println(String.format("<h1>Podana wartość w przeliczeniu na:</h1>kilogramy: %.1f<br/>gramy: %.1f<br/>miligramy: %.1f", convertedKilograms, convertedGrams, convertedMilligrams));
        }
    }
}

