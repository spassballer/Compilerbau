class InstVarTest {
    int number;

    void set(int newNumber){
        number = newNumber;
    }

    int get(){
        return number;
    }

    int test(int a){
        InstVarTest instVarTest;
        instVarTest = new InstVarTest();

        instVarTest.set(a);
        return instVarTest.get();
    }
}
