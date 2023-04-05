package TP1;

public class Ascii implements AsciiEncoder{

    @Override
    public String encode(String binary) {
        String result = "";
        int decimal = 0;
        int bitValue = 128;
        int bitCount = 0;

        for (int i = 0; i < binary.length(); i++) {
            int bit = binary.charAt(i) - '0';
            decimal += bit * bitValue;
            bitValue /= 2;
            bitCount++;

            if (bitCount == 8) {
                result += (char) decimal;
                decimal = 0;
                bitValue = 128;
                bitCount = 0;
            }
        }

        if (bitCount > 0) {
            decimal += (bitValue - 1);
            result += (char) decimal;
        }

        return result;
    }

    @Override
    public String decode(String ascii) {
        return null;
    }
}
