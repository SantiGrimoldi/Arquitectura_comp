package TP1;

public class Ascii implements AsciiEncoder {

    @Override
    public String encode(String binary) {
        String result = "";
        int decimal = 0;
        int bitValue = 128;
        int bitCount = 0;

        for (int i = 0; i <= binary.length() - 1; i++) {
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
        //completo con 1s para que el octeto tenga 8 bits
        if (bitCount > 0) {
            int bitsMissing = 8 - bitCount;
            decimal += Math.pow(2, bitsMissing) - 1;
            result += (char) decimal;
        }

        return result;
    }

    @Override
    public String decode(String ascii) {
        String result = "";
        for (int i = 0; i <= ascii.length() - 1; i++) {
            int charValue = ascii.charAt(i);
            for (int j = 7; j >= 0; j--) {
                int decimal = (int) Math.pow(2, j);
                int bit = charValue / decimal;
                charValue -= bit * decimal;
                result += bit;
            }
        }
        return result;
    }
}
