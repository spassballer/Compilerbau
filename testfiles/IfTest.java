class IfTest {
    int a;
    boolean onlyIf(boolean a){
        if(a){
            a = !a;
            return a;
        }
        return a;
    }

    boolean bothIfAndElse(boolean a, boolean b){
        if(a == b){
            return a;
        }else {
            return b;
        }
    }

    void testVoidReturn(int a, int b){
        while(a < 100){
            if(a == b){
                return;
            }
            a = a + 3;
        }
    }
}
