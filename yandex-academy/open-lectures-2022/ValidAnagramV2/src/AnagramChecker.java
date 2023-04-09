public class AnagramChecker {

    public void checkAndPrintResult(String s, String t) {
        boolean isAnagram = isAnagram(s, t);

        if (isAnagram) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }
}