package TP1;

public class Ascii implements AsciiEncoder{

    @Override
    public String encode(String binary) {
        String result = "";
        for (int i = 0; i <= binary.length() - 1 ; i += 8) {
            String group = binary.substring(i, Math.min(i + 8, binary.length()));
            int decimal = Integer.parseInt(group, 2);
            result += (char) decimal;
        }
        return result;
    }

    @Override
    public String decode(String ascii) {
        return null;
    }
}
