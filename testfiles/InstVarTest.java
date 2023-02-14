class InstVarTest {
    int number;

    void a(){
        InstVarTest instVarTest;
        instVarTest = new InstVarTest();
        int i;
        i = instVarTest.number;
        new String("abc");
        b();
    }

    int b(){
        return this.number;
    }
}
