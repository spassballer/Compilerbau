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
        System.out.println("Add successful: " + (binaryTest.add(a, b) == a + b));
        System.out.println("Subtract successful: " + (binaryTest.subtract(a, b) == a - b));
        System.out.println("Multiply successful: " + (binaryTest.multiply(a, b) == a * b));
        System.out.println("Divide successful: " + (binaryTest.divide(a, b) == a / b));
        System.out.println("Modulo successful: " + (binaryTest.modulo(a, b) == a % b));
        System.out.println("AND(T,T) successful: " + (binaryTest.and(t, t) == (t && t)));
        System.out.println("AND(T,F) successful: " + (binaryTest.and(t, f) == (t && f)));
        System.out.println("OR(T,F) successful: " + (binaryTest.or(t, f) == (t || f)));
        System.out.println("OR(F,F) successful: " + (binaryTest.or(f, f) == (f || f)));
        System.out.println("Equal(Int) successful: " + (binaryTest.equal(a, b) == (a == b)));
        System.out.println("Equal(Int) successful: " + (binaryTest.equal(a, a) == (a == a)));
        System.out.println("Not Equal(Int) successful: " + (binaryTest.notEqual(a, b) == (a != b)));
        System.out.println("Not Equal(Int) successful: " + (binaryTest.notEqual(a, a) == (a != a)));
        System.out.println("Equal(boolean) successful: " + (binaryTest.equal(t, f) == (t == f)));
        System.out.println("Equal(boolean) successful: " + (binaryTest.equal(t, t) == (t == t)));
        System.out.println("Not Equal(boolean) successful: " + (binaryTest.notEqual(t, f) == (t != f)));
        System.out.println("Not Equal(boolean) successful: " + (binaryTest.notEqual(t, t) == (t != t)));
        System.out.println("Equal(char) successful: " + (binaryTest.equal(c, d) == (c == d)));
        System.out.println("Equal(char) successful: " + (binaryTest.equal(c, c) == (c == c)));
        System.out.println("Not Equal(char) successful: " + (binaryTest.notEqual(c, d) == (c != d)));
        System.out.println("Not Equal(char) successful: " + (binaryTest.notEqual(c, c) == (c != c)));
        System.out.println("Greater than successful: " + (binaryTest.greaterThan(a, b) == a > b));
        System.out.println("Greater than successful: " + (binaryTest.greaterThan(a, a) == a > a));
        System.out.println("Greater than successful: " + (binaryTest.greaterThan(b, a) == b > a));
        System.out.println("Greater equal successful: " + (binaryTest.greaterEqual(a, b) == a >= b));
        System.out.println("Greater equal successful: " + (binaryTest.greaterEqual(a, a) == a >= a));
        System.out.println("Greater equal successful: " + (binaryTest.greaterEqual(b, a) == b >= a));
        System.out.println("Lower than successful: " + (binaryTest.lowerThan(a, b) == a < b));
        System.out.println("Lower than successful: " + (binaryTest.lowerThan(a, a) == a < a));
        System.out.println("Lower than successful: " + (binaryTest.lowerThan(b, a) == b < a));
        System.out.println("Lower equal successful: " + (binaryTest.lowerEqual(a, b) == a <= b));
        System.out.println("Lower equal successful: " + (binaryTest.lowerEqual(a, a) == a <= a));
        System.out.println("Lower equal successful: " + (binaryTest.lowerEqual(b, a) == b <= a));
        System.out.println("String concat: " + binaryTest.concat(e, g).equals(e + g));
        System.out.println("------------------------------------------------");

    }
}
