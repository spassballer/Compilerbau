class WhileTest {
    int countToB(int a, int b){
        while(a < b){
            a = a + 1;
        }
        return a;
    }

    int countToBBlock(int a, int b){
        while(a < b){
            a = a + 1;
            b = b - 1;
        }
        return b;
    }
}
