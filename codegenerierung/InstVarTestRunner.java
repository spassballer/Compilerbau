public class InstVarTestRunner {
    public static void main(String[] args) {
        InstVarTest instVarTest = new InstVarTest();
        int a = 20;

        System.out.println("------------------------------------------------");
        System.out.println("1. Test sucessfull: "+(instVarTest.test(a)==a));
        System.out.println("------------------------------------------------");
    }

}
