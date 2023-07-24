package challenges;

public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        // returns false if either num1 or num2 is negative
        if (!(num1 >= 10 && num1 <= 99) || !(num2 >= 10 && num2 <= 99)) return false;

        int tempNum2; // created temporary variable for mutable num2 without changing original value
        while (num1 != 0) {
            tempNum2 = num2; // preparing-assigning temporary value for the loop after this
            while (tempNum2 != 0) {
                if (num1 % 10 == tempNum2 % 10) return true;
                tempNum2 /= 10; // truncate the least significant digit of the temporary value
            }
            num1 /= 10; // truncate the least significant digit of the num1 value
        }
        return false;
    }

//    public static boolean hasSharedDigit (int num1, int num2){
//        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) return false;
//
//        for (int i = num1; i > 0; i /= 10) {
//            for(int j = num2; j > 0 ; j /= 10) { // j gets reset to num2
//                if(i % 10 == j % 10){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    public static boolean hasSharedDigit(int num1, int num2){
//        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) return false;
//
//        return (num1/10 == num2/10 || num1%10 == num2%10 || num1/10 == num2%10 || num1%10 == num2/10);
//    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(121, 53));
    }
}
