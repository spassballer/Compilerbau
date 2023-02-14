class IfTest {
    boolean a(boolean a, boolean b){
        if(a == b){
            return a;
        }else {
            return b;
        }
    }

    boolean b(boolean a, boolean b){
        if(a != b){
            return a;
        }
        return b;
    }
    boolean c(boolean a){
        if(a){
            return a;
        }else {
            return !a;
        }
    }

    int d(int a, int b){
        if(a <= b){
            return a;
        }else {
            return b;
        }
    }

    String e(boolean a){
        if(!a){
            return null;
        }
        return "3";
    }
}
