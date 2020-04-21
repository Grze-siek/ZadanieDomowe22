package KonwersjeMiar.MetricConverter;

import KonwersjeMiar.MetricConverter.MetricCalculations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/KonwersjeMiar")
public class MetricConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String meters = request.getParameter("meters");
        String centimeters = request.getParameter("centimeters");
        String millimeters = request.getParameter("millimeters");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        MetricCalculations calculate = new MetricCalculations();
        Map<String, String> metrics = calculate.metricsToMap(meters, centimeters, millimeters);
        if(calculate.tooManyValues(metrics)) {
            response.getWriter().println(String.format("Proszę wypełnić tylko jedno pole!"));
        }
        else {
            Map<String, Double> convertedMetrics = calculate.calculateMetrics(meters, centimeters, millimeters);
            double convertedMeters = convertedMetrics.get("meters");
            double convertedCentimeters = convertedMetrics.get("centimeters");
            double convertedMillimeters = convertedMetrics.get("millimeters");
            response.getWriter().println(String.format("<h1>Podana wartość w przeliczeniu na:</h1>metry: %.1f<br/>centymetry: %.1f<br/>milimetry: %.1f", convertedMeters, convertedCentimeters, convertedMillimeters));
        }
    }
}
