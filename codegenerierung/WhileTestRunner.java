public class WhileTestRunner {
    public static void main(String[] args) {
        WhileTest whileTest = new WhileTest();
        int a = 1;
        int b = 100;

        System.out.println("------------------------------------------------");
        System.out.println(whileTest.countToB(a, b));
        System.out.println(whileTest.countToBBlock(a, b));
        System.out.println("------------------------------------------------");

    }
}
