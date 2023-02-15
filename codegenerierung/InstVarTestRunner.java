public class InstVarTestRunner {
    public static void main(String[] args) {
        InstVarTest instVarTest = new InstVarTest();
        int a = 20;

        System.out.println("------------------------------------------------");
        System.out.println("Instance creation and usage test successful: "+(instVarTest.test(a)==a));
        System.out.println("Null test successful: "+(instVarTest.nullTest() == null));
        System.out.println("------------------------------------------------");
    }

}
