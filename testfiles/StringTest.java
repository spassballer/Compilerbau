class StringTest {
    String a;
    String amethod(String x, String y){
        return x + y;
    }

    void bmethod(String x){
        x = x + "abcdefg";
    }

    void cmethod(String x){
        String f;
        f = "abc";
        f = f + "";
    }
}
