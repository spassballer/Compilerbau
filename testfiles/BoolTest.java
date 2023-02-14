class BoolTest {
    boolean bool;

    boolean a(){
        return bool;
    }

    boolean b(boolean a, boolean b){
        if(a == b){
            return a;
        } else {
            return b;
        }
    }

    boolean c(boolean a){
        return a || bool;
    }
    

    boolean d(boolean bool){
        return this.bool && bool;
    }
}
