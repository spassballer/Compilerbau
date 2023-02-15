public class IfTestRunner {
    public static void main(String[] args) {
        IfTest ifTest = new IfTest();
        boolean t = true;
        boolean f = false;

        System.out.println("------------------------------------------------");
        System.out.println("If sucessfull: " + (ifTest.onlyIf(t) == !t));
        System.out.println("If/else sucessfull: " + (ifTest.bothIfAndElse(t, t) == t));
        System.out.println("If/else sucessfull: " + (ifTest.bothIfAndElse(t, f) == f));
        System.out.println("If/else sucessfull: " + (ifTest.bothIfAndElse(f, t) == t));
        System.out.println("If/else sucessfull: " + (ifTest.bothIfAndElse(f, f) == f));
        System.out.println("------------------------------------------------");

    }
}
