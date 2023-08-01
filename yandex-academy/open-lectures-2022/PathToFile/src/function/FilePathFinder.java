package function;

import java.util.ArrayList;

public class FilePathFinder {
    public String findPath(String query, int n, String[] filesAndDirectories) {
        ArrayList<String> nowPath = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = filesAndDirectories[i];
            String nowFile = line.trim();
            int spaces = 0;

            while (spaces < line.length() && line.charAt(spaces) == ' ') {
                spaces += 1;
            }

            nowPath = new ArrayList<>(nowPath.subList(0, spaces));
            nowPath.add(nowFile);

            if (nowFile.equals(query)) {
                return "/" + String.join("/", nowPath);
            }
        }
        return null;
    }
}
