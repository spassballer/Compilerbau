class InstVarTest {
    int number;

    void set(int number){
        this.number = number;
    }

    int get(){
        return number;
    }

    void a(){
        InstVarTest instVarTest;
        instVarTest = new InstVarTest();
        instVarTest.set(5);
        int i;
        i = instVarTest.get();

    }
}
