public class IfTestRunner {
    public static void main(String[] args) {
        IfTest ifTest = new IfTest();
        boolean t = true;
        boolean f = false;

        System.out.println("------------------------------------------------");
        System.out.println("If successful: " + (ifTest.onlyIf(t) == !t));
        System.out.println("If/else successful: " + (ifTest.bothIfAndElse(t, t) == t));
        System.out.println("If/else successful: " + (ifTest.bothIfAndElse(t, f) == f));
        System.out.println("If/else successful: " + (ifTest.bothIfAndElse(f, t) == t));
        System.out.println("If/else successful: " + (ifTest.bothIfAndElse(f, f) == f));
        ifTest.testVoidReturn(1, 100);
        System.out.println("Return successful: true");
        System.out.println("------------------------------------------------");

    }
}
