import java.util.ArrayDeque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/"));
    }

    public static String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] partsPath = path.split("/");
        for (int i = 0; i < partsPath.length; i++) {
            if (partsPath[i].isEmpty() || partsPath[i].equals(".") ||
                    (stack.isEmpty() && partsPath[i].equals(".."))) {
                continue;
            } else if (!stack.isEmpty() && partsPath[i].equals("..")) {
                stack.pollLast();
            } else {
                stack.add(partsPath[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) {
            res.append("/");
            return String.valueOf(res);
        }
        while (!stack.isEmpty()) {
            res.append("/" + stack.pollFirst());
        }
        return String.valueOf(res);
    }
}
