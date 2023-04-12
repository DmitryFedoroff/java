public class CanonicalPath {

    public String getCanonicalPath(String path) {
        boolean flag = true;
        path += "/";

        while (flag) {
            if (path.contains("/./")) {
                path = path.replace("/./", "/");
            } else if (path.contains("//")) {
                path = path.replace("//", "/");
            } else if (path.contains("/../")) {
                int pos = path.indexOf("/../");
                if (pos == 0) {
                    path = path.substring(3);
                } else {
                    int prevSlashPos = path.lastIndexOf("/", pos - 1);
                    path = path.substring(0, prevSlashPos) + path.substring(pos + 3);
                }
            } else {
                flag = false;
            }
        }
        if (path.endsWith("/") && !path.equals("/")) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }
}