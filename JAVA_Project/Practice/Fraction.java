import java.text.ParseException;
import java.util.ArrayList;

public class Fraction {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int d = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / d;
        this.denominator = this.denominator / d;
    }

    private static int gcd(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        ArrayList<Integer> divisorsOfM = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                divisorsOfM.add(i);
            }
        }
        ArrayList<Integer> divisorsOfN = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorsOfN.add(i);
            }

        }
        int gcd = 1;
        for (int i : divisorsOfM) {
            if (divisorsOfN.contains(i) && i > gcd) {
                gcd = i;
            }

        }
        return gcd;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator cannot be zero!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction(int value) {
        this.numerator = value;
        this.denominator = 1;
    }

    public String toString() {
        int num = numerator;
        int den = denominator;

        if (den < 0) {
            num = -num;
            den = -den;
        }

        int g = gcd(Math.abs(num), Math.abs(den));
        num = num / g;
        den = den / g;

        if (den == 1) {
            return Integer.toString(num);
        } else {
            return num + "/" + den;
        }

    }

    /*
     * public static Fraction parseFraction(String str) throws ParseException {
     * if (str.contains("/")) {
     * String[] strArray = str.split("/");
     * if (strArray.length != 2) {
     * throw new ParseException("Invalid fraction: does not contain only one '/'.",
     * 0);
     * }
     * int numerator;
     * int denominator;
     * try {
     * numerator = Integer.parseInt(strArray[0]);
     * denominator = Integer.parseInt(strArray[1]);
     * } catch (NumberFormatException e) {
     * throw new
     * ParseException("Invalid fraction: numerator and denominator must be numbers."
     * , 0);
     * }
     * return new Fraction(numerator, denominator);
     * } else {
     * try {
     * int num = Integer.parseInt(str);
     * return new Fraction(num, 1);
     * } catch (NumberFormatException e) {
     * throw new ParseException("Invalid fraction: must be a valid integer.", 0);
     * }
     * }
     * 
     * }
     */

    public static Fraction paraFraction(String str) throws ParseException {
        char[] chars = str.toCharArray();
        int slashIndex = -1;
        int slashCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                slashIndex = i;
                slashCount++;
            }
            if (slashCount > 1) {
                throw new ParseException("Invalid fraction: does not contain only one '/'.", 0);
            }
        }
        int num;
        int den;
        if (slashIndex == -1) {
            num = parseCharArrayToInt(chars, 0, chars.length - 1);
            den = 1;
        } else {
            num = parseCharArrayToInt(chars, 0, slashIndex - 1);
            den = parseCharArrayToInt(chars, slashIndex + 1, chars.length - 1);
        }
        return new Fraction(num, den);
    }

    private static int parseCharArrayToInt(char[] chars, int start, int end) throws ParseException {
        try {
            return Integer.parseInt(new String(chars, start, end - start + 1));
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid fraction: numerator and denominator must be numbers.", 0);
        }
    }

    public Fraction add(Fraction f) {
        int numerator = this.numerator * f.denominator + f.numerator * this.denominator;
        int denominator = this.denominator * f.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction multiply(Fraction f) {
        int numerator = this.numerator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction add(int m) {
        Fraction f = new Fraction(m);
        return this.add(f);
    }

    public Fraction multiply(int m) {
        Fraction f = new Fraction(m);
        return this.multiply(f);
    }

    public boolean equals(Object o) {
        Fraction f = (Fraction) o;
        if (this.numerator * f.denominator == f.numerator * this.denominator) {
            return true;
        } else {
            return false;
        }
    }

}
