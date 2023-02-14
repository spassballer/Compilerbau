public class BinaryTestRunner {
    public static void main(String[] args) {
        BinaryTest binaryTest = new BinaryTest();
        int a = 3;
        int b = 7;
        boolean t = true;
        boolean f = false;
        char c = 'c';
        char d = 'd';
        String e = "abc";
        String g = "de";

        System.out.println("------------------------------------------------");
        System.out.println("Add sucessful: " + (binaryTest.add(a, b) == a + b));
        System.out.println("Subtract sucessful: " + (binaryTest.subtract(a, b) == a - b));
        System.out.println("Multiply sucessful: " + (binaryTest.multiply(a, b) == a * b));
        System.out.println("Divide sucessful: " + (binaryTest.divide(a, b) == a / b));
        System.out.println("Modulo sucessful: " + (binaryTest.modulo(a, b) == a % b));
        System.out.println("AND(T,T) sucessful: " + (binaryTest.and(t, t) == t && t));
        System.out.println("AND(T,F) sucessful: " + (binaryTest.and(t, f) == t && f));
        System.out.println("OR(T,F) sucessful: " + (binaryTest.or(t, f) == t && f));
        System.out.println("OR(F,F) sucessful: " + (binaryTest.or(f, f) == f && f));
        System.out.println("Equal(Int) sucessful: " + (binaryTest.equal(a, b) == (a == b)));
        System.out.println("Equal(Int) sucessful: " + (binaryTest.equal(a, a) == (a == a)));
        System.out.println("Not Equal(Int) sucessful: " + (binaryTest.notEqual(a, b) == (a != b)));
        System.out.println("Not Equal(Int) sucessful: " + (binaryTest.notEqual(a, a) == (a != a)));
        System.out.println("Equal(boolean) sucessful: " + (binaryTest.equal(t, f) == (t == f)));
        System.out.println("Equal(boolean) sucessful: " + (binaryTest.equal(t, t) == (t == t)));
        System.out.println("Not Equal(boolean) sucessful: " + (binaryTest.notEqual(t, f) == (t != f)));
        System.out.println("Not Equal(boolean) sucessful: " + (binaryTest.notEqual(t, t) == (t != t)));
        System.out.println("Equal(char) sucessful: " + (binaryTest.equal(c, d) == (c == d)));
        System.out.println("Equal(char) sucessful: " + (binaryTest.equal(c, c) == (c == c)));
        System.out.println("Not Equal(char) sucessful: " + (binaryTest.notEqual(c, d) == (c != d)));
        System.out.println("Not Equal(char) sucessful: " + (binaryTest.notEqual(c, c) == (c != c)));
        System.out.println("Greater than sucessful: " + (binaryTest.greaterThan(a, b) == a > b));
        System.out.println("Greater than sucessful: " + (binaryTest.greaterThan(a, a) == a > a));
        System.out.println("Greater than sucessful: " + (binaryTest.greaterThan(b, a) == b > a));
        System.out.println("Greater equal sucessful: " + (binaryTest.greaterEqual(a, b) == a >= b));
        System.out.println("Greater equal sucessful: " + (binaryTest.greaterEqual(a, a) == a >= a));
        System.out.println("Greater equal sucessful: " + (binaryTest.greaterEqual(b, a) == b >= a));
        System.out.println("Lower than sucessful: " + (binaryTest.lowerThan(a, b) == a < b));
        System.out.println("Lower than sucessful: " + (binaryTest.lowerThan(a, a) == a < a));
        System.out.println("Lower than sucessful: " + (binaryTest.lowerThan(b, a) == b < a));
        System.out.println("Lower equal sucessful: " + (binaryTest.lowerEqual(a, b) == a <= b));
        System.out.println("Lower equal sucessful: " + (binaryTest.lowerEqual(a, a) == a <= a));
        System.out.println("Lower equal sucessful: " + (binaryTest.lowerEqual(b, a) == b <= a));
        System.out.println("String concat: " + binaryTest.concat(e, g).equals(e + g));
        System.out.println("------------------------------------------------");

    }
}
