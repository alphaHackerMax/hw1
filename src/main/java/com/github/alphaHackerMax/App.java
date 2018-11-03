package com.github.alphaHackerMax;

/**
 * Homework 1
 * @author Maxim Stasenkov <a href="mailto:makcct@yandex.ru">mailMe</a>
 * @version 1.0.0
 * @since 03.11.2018
 */
public class App {
    /**
     * Class for storing and transferring the results of the summation.
     * @param <T> - can be Integer or Long
     * @see App.DTOIntegerSumm#strResultDescription field for storing the description string
     * @see App.DTOIntegerSumm#sum field to store the summation result or the value of the excess over the limit
     */
    public static class DTOIntegerSumm<T> {
        private String strResultDescription;
        private T sum;

        public void setStrResultDescription(String strResultDescription) {
            this.strResultDescription = strResultDescription;
        }

        public String getStrResultDescription() {
            return strResultDescription;
        }

        public T getSum() {
            return sum;
        }

        public void setSum(T Sum) {
            this.sum = Sum;
        }
    }

    /**
     * Method for summation of two integer value
     * @param x 1st operand
     * @param y 2nd operand
     * @param isCast TRUE - allows the use of a type cast
     * @return DTO object with two field: result description and sum
     */
    public static DTOIntegerSumm getIntegerSumm(int x, int y, boolean isCast){
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        int dp = 0;
        int dn = 0;
        int z;
        int dz;
        long q;
        String str;

        if ((x < 0) & (y < 0)) {
            dn = minIntValue - x;
        } else if ((x > 0) & (y > 0)) {
            dp = maxIntValue - x;
        } else {
            dp = 0;
            dn = 0;
        }

        if ((dp >= y & dn <= y) |
                (x > 0 & y < 0) | (x < 0 & y > 0) |
                (x == 0 | y == 0)) {
            str = "integer result ";
            z = x + y;
            DTOIntegerSumm<Integer> dtoIntegerSumm = new DTOIntegerSumm<>();
            dtoIntegerSumm.setStrResultDescription(str);
            dtoIntegerSumm.setSum(z);
            return dtoIntegerSumm;
        } else if ((dp < y) & !isCast) {
            dz = y - dp;
            str = "sum= " + maxIntValue + " + overload value ";
            DTOIntegerSumm<Integer> dtoIntegerSumm = new DTOIntegerSumm<>();
            dtoIntegerSumm.setStrResultDescription(str);
            dtoIntegerSumm.setSum(dz);
            return dtoIntegerSumm;
        } else if ((dn > y) & !isCast) {
            dz = y - dn;
            str = "sum= " + minIntValue + " + overload value ";
            DTOIntegerSumm<Integer> dtoIntegerSumm = new DTOIntegerSumm<>();
            dtoIntegerSumm.setStrResultDescription(str);
            dtoIntegerSumm.setSum(dz);
            return dtoIntegerSumm;
        } else if (((dp < y) | (dn > y)) & isCast) {
            q = (long) x + y;
            str = "casting ";
            DTOIntegerSumm<Long> dtoIntegerSumm = new DTOIntegerSumm<>();
            dtoIntegerSumm.setStrResultDescription(str);
            dtoIntegerSumm.setSum(q);
            return dtoIntegerSumm;
        } else {
            str = "NULL";
            DTOIntegerSumm<Integer> dtoIntegerSumm = new DTOIntegerSumm<>();
            dtoIntegerSumm.setStrResultDescription(str);
            dtoIntegerSumm.setSum(0);
            return dtoIntegerSumm;
        }
    }

    public static void main( String[] args ) {
        DTOIntegerSumm a = getIntegerSumm(1, 3, true);
        System.out.println(a.getStrResultDescription() + a.getSum());

        DTOIntegerSumm a1 = getIntegerSumm(-1, -3, true);
        System.out.println(a1.getStrResultDescription() + a1.getSum());

        DTOIntegerSumm a2 = getIntegerSumm(0, 3, true);
        System.out.println(a2.getStrResultDescription() + a2.getSum());

        DTOIntegerSumm a3 = getIntegerSumm(1, -3, true);
        System.out.println(a3.getStrResultDescription() + a3.getSum());

        DTOIntegerSumm a4 = getIntegerSumm(2147483647, 2, true);
        System.out.println(a4.getStrResultDescription() + a4.getSum());

        DTOIntegerSumm a5 = getIntegerSumm(-2147483648, -2, false);
        System.out.println(a5.getStrResultDescription() + a5.getSum());
    }
}
