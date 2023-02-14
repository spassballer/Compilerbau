class WhileTest {
    void a(int a, int b){
        while(a < b){
            a = a + 1;
        }
    }

    void b(int a, int b){
        while(a > b){
            a = a + 1;
        }
    }

    void c(boolean a, boolean b){
        while(a && b){
            a = b;
        }
    }

    void d(boolean a, boolean b){
        while(a || b){
            a = b;
        }
    }


}
