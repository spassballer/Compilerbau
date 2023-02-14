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

    void c(int a, int b){
        while(a >= b && b == 5){
            a = a + 1;
        }
    }

    void d(int a, int b){
        while(a < b || b != 5){
            a = a + 1;
        }
    }


}
