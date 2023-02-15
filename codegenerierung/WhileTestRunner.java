public class WhileTestRunner {
    public static void main(String[] args) {
        WhileTest whileTest = new WhileTest();
        int a = 1;
        int b = 100;
        int c = 1;
        int d = 100;

        System.out.println("------------------------------------------------");
        while(a < b){ a++; }
        System.out.println("1. Test successful: " + (whileTest.countToB(a, b) == a));
        while(c < d){ c++; d--; }
        System.out.println("2. Test successful: " + (whileTest.countToBBlock(c, d) == d));
        System.out.println("------------------------------------------------");

    }
}
