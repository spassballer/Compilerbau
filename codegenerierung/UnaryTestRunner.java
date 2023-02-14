public class UnaryTestRunner {
    public static void main(String[] args) {
        UnaryTest unaryTest = new UnaryTest();
        int a = 3;
        int b = -7;
        boolean t = true;
        boolean f = false;

        System.out.println("------------------------------------------------");
        System.out.println("NOT sucessful: " + (unaryTest.not(t) == !t));
        System.out.println("NOT sucessful: " + (unaryTest.not(f) == !f));
        System.out.println("Positive sucessful: " + (unaryTest.positive(a) == +a));
        System.out.println("Positive sucessful: " + (unaryTest.positive(b) == +b));
        System.out.println("Negative sucessful: " + (unaryTest.negative(a) == -a));
        System.out.println("Negative sucessful: " + (unaryTest.negative(b) == -b));
        System.out.println("------------------------------------------------");

    }
}
