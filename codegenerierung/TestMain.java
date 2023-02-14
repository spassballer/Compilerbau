public class TestMain {
    public static void main(String[] args) {
        BoolTest boolTest = new BoolTest();
        boolTest.bool = true;
        System.out.println(boolTest.a());
        System.out.println(boolTest.b(true, false));
        System.out.println(boolTest.c(true));

    }
}
