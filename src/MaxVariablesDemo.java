public class MaxVariablesDemo {
    public static void main(String args[]) {

        final int a = 10;
        int b = 15;
        // a = 11; -> iria dar um erro
        b = 11; // atribuição válida



        // integers
        byte largestByte = Byte.MAX_VALUE;
        short largestShort = Short.MAX_VALUE;
        int largestInteger = Integer.MAX_VALUE;
        long largestLong = Long.MAX_VALUE;

        // real numbers
        float largestFloat = Float.MAX_VALUE;
        double largestDouble = Double.MAX_VALUE;

        // other primitive types
        char aChar = 'S';
        boolean aBoolean = true;

        // display them all
        System.out.println("The largest byte value is " + largestByte);
        System.out.println("The largest short value is " + largestShort);
        System.out.println("The largest integer value is " + largestInteger);
        System.out.println("The largest long value is " + largestLong);

        System.out.println("The largest float value is " + largestFloat);
        System.out.println("The largest double value is " + largestDouble);

        if (Character.isUpperCase(aChar)) {
            System.out.println("The character " + aChar + " is upper case.");
        } else {
            System.out.println("The character " + aChar + " is lower case.");
        }
        System.out.println("The value of aBoolean is " + aBoolean);
    }
}