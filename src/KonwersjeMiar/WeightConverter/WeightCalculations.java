package KonwersjeMiar.WeightConverter;

import java.util.HashMap;
import java.util.Map;

public class WeightCalculations {

        public Map<String, String> weightsToMap (String kilograms, String grams, String milligrams) {
            Map<String, String> weights = new HashMap<>();
            weights.put("kilograms", kilograms);
            weights.put("grams", grams);
            weights.put("milligrams", milligrams);
            return weights;
        }


        public Map<String, Double> calculateWeights(String kilograms, String grams, String milligrams) {
            Map<String, String> weights = weightsToMap(kilograms, grams, milligrams);
            Map<String, Double> convertedWeights = null;
            for (String weight : weights.keySet()) {
                String value = weights.get(weight);
                if(!"".equals(value)) {
                    convertedWeights = convert(weight, value);
                }
            }
            return convertedWeights;
        }

        private Map<String, Double> convert(String weight, String value) {
            Map<String, Double> convertedWeights = new HashMap<>();
            switch(weight) {
                case "kilograms" : {
                    convertedWeights = calculateIfGivenKilograms(value);
                    break;
                }
                case "grams" : {
                    convertedWeights = calculateIfGivenGrams(value);
                    break;
                }
                case "milligrams" : {
                    convertedWeights = calculateIfGivenMilligrams(value);
                    break;
                }
            }
            return convertedWeights;
        }

        private Map<String, Double> calculateIfGivenKilograms(String Kilograms) {
            Map<String, Double> convertedWeights= new HashMap<>();
            double kilogramsAfterParse = Double.parseDouble(Kilograms);
            double grams = kilogramsAfterParse * 1000;
            double milligrams = kilogramsAfterParse * 10000;
            convertedWeights.put("kilograms", kilogramsAfterParse);
            convertedWeights.put("grams", grams);
            convertedWeights.put("milligrams", milligrams);
            return convertedWeights;
        }
        private Map<String, Double> calculateIfGivenGrams(String grams) {
            Map<String, Double> convertedWeights = new HashMap<>();
            double gramsAfterParse = Double.parseDouble(grams);
            double kilograms = gramsAfterParse / 1000;
            double milligrams = gramsAfterParse * 10;
            convertedWeights.put("kilograms", kilograms);
            convertedWeights.put("grams", gramsAfterParse);
            convertedWeights.put("milligrams", milligrams);
            return convertedWeights;
        }
        private Map<String, Double> calculateIfGivenMilligrams(String milligrams) {
            Map<String, Double> convertedWeights = new HashMap<>();
            double milligramsAfterParse = Double.parseDouble(milligrams);
            double grams = milligramsAfterParse / 10;
            double kilograms = milligramsAfterParse / 10000;
            convertedWeights.put("kilograms", kilograms);
            convertedWeights.put("grams", grams);
            convertedWeights.put("milligrams", milligramsAfterParse);
            return convertedWeights;
        }

        public boolean tooManyValues(Map<String, String> weights) {
            int sumOfValues = 0;
            for (String weight : weights.values()) {
                if (!"".equals(weight)) {
                    sumOfValues++;
                }
            }
            return sumOfValues > 1;
        }
}


