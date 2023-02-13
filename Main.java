public class Main {
    public static void main (String [] args) {
        javascanner scanner = new javascanner(new java.io.InputStreamReader (System.in));
        javaparser parser = new javaparser();
        try {
            parser.yyparse(scanner);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
