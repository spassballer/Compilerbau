class IfTest {
    boolean if1(boolean a, boolean b){
        if(a == b){
            return a;
        }else {
            return b;
        }
    }

    boolean if2(boolean a, boolean b){
        if(a != b){
            return a;
        }else {
            return b;
        }
    }
    boolean if3(boolean a){
        if(a){
            return a;
        }else {
            return !a;
        }
    }

    int if4(int a, int b){
        if(a <= b){
            return a;
        }else {
            return b;
        }
    }
}
