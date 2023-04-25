import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubstanceChecker {
    private Set<String> desirableSubstances;
    private HashMap<String, String> lowerCaseSubstances;
    private HashMap<String, String> unvoweledSubstances;

    public SubstanceChecker(String[] substances) {
        desirableSubstances = new HashSet<>();
        lowerCaseSubstances = new HashMap<>();
        unvoweledSubstances = new HashMap<>();

        for (String substance : substances) {
            desirableSubstances.add(substance);
            String lowerCaseSubstance = substance.toLowerCase();
            if (!lowerCaseSubstances.containsKey(lowerCaseSubstance)) {
                lowerCaseSubstances.put(lowerCaseSubstance, substance);
            }
            String unvoweled = unvowel(substance);
            if (!unvoweledSubstances.containsKey(unvoweled)) {
                unvoweledSubstances.put(unvoweled, substance);
            }
        }
    }

    private String unvowel(String substance) {
        substance = substance.toLowerCase();
        for (char vowel : "aeuio".toCharArray()) {
            substance = substance.replace(vowel, '#');
        }
        return substance;
    }

    public String[] checkSpelling(String[] queries) {
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (desirableSubstances.contains(query)) {
                result[i] = query;
            } else if (lowerCaseSubstances.containsKey(query.toLowerCase())) {
                result[i] = lowerCaseSubstances.get(query.toLowerCase());
            } else if (unvoweledSubstances.containsKey(unvowel(query))) {
                result[i] = unvoweledSubstances.get(unvowel(query));
            } else {
                result[i] = "";
            }
        }
        return result;
    }
}
