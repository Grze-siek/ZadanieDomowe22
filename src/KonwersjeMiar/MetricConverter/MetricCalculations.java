package KonwersjeMiar.MetricConverter;

import java.util.HashMap;
import java.util.Map;

public class MetricCalculations {

    public Map<String, String> metricsToMap (String meters, String centimeters, String millimeters) {
        Map<String, String> metrics = new HashMap<>();
        metrics.put("meters", meters);
        metrics.put("centimeters", centimeters);
        metrics.put("millimeters", millimeters);
        return metrics;
    }


    public Map<String, Double> calculateMetrics(String meters, String centimeters, String millimeters) {
        Map<String, String> metrics = metricsToMap(meters, centimeters, millimeters);
        Map<String, Double> convertedMetrics = null;
        for (String metric : metrics.keySet()) {
            String value = metrics.get(metric);
            if(!"".equals(value)) {
                convertedMetrics = convert(metric, value);
            }
        }
        return convertedMetrics;
    }

    private Map<String, Double> convert(String metric, String value) {
        Map<String, Double> convertedMetrics = new HashMap<>();
        switch(metric) {
            case "meters" : {
                convertedMetrics = calculateIfGivenMeters(value);
                break;
            }
            case "centimeters" : {
                convertedMetrics = calculateIfGivenCentimeters(value);
                break;
            }
            case "millimeters" : {
                convertedMetrics = calculateIfGivenMillimeters(value);
                break;
            }
        }
        return convertedMetrics;
    }

    private Map<String, Double> calculateIfGivenMeters(String meters) {
        Map<String, Double> convertedMetrics = new HashMap<>();
        double metersAfterParse = Double.parseDouble(meters);
        double centimeters = metersAfterParse * 100;
        double millimeters = metersAfterParse * 1000;
        convertedMetrics.put("meters", metersAfterParse);
        convertedMetrics.put("centimeters", centimeters);
        convertedMetrics.put("millimeters", millimeters);
        return convertedMetrics;
    }
    private Map<String, Double> calculateIfGivenCentimeters(String centimeters) {
        Map<String, Double> convertedMetrics = new HashMap<>();
        double centimetersAfterParse = Double.parseDouble(centimeters);
        double meters = centimetersAfterParse / 100;
        double millimeters = centimetersAfterParse * 10;
        convertedMetrics.put("meters", meters);
        convertedMetrics.put("centimeters", centimetersAfterParse);
        convertedMetrics.put("millimeters", millimeters);
        return convertedMetrics;
    }
    private Map<String, Double> calculateIfGivenMillimeters(String millimeters) {
        Map<String, Double> convertedMetrics = new HashMap<>();
        double millimetersAfterParse = Double.parseDouble(millimeters);
        double centimeters = millimetersAfterParse / 10;
        double meters = millimetersAfterParse / 1000;
        convertedMetrics.put("meters", meters);
        convertedMetrics.put("centimeters", centimeters);
        convertedMetrics.put("millimeters", millimetersAfterParse);
        return convertedMetrics;
    }

    public boolean tooManyValues(Map<String, String> metrics) {
        int sumOfValues = 0;
        for (String metric : metrics.values()) {
            if (!"".equals(metric)) {
                sumOfValues++;
            }
        }
        return sumOfValues > 1;
    }
}
