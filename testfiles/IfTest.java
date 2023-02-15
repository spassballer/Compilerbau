class IfTest {
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
}
