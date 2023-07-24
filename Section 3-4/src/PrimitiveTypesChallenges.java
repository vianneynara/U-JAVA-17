public class PrimitiveTypesChallenges {
    public static void main(String[] args) {
        byte myByte = 127;
        short myShort = 32767;
        int myInt = 214748364;
        long myLong = 50000L + (10L * (myByte + myShort + myInt));

        System.out.println(myLong);
    }
}
