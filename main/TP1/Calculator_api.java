package TP1;

public class Calculator_api implements Calculator {

    @Override
    public String sumGuardiola(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        String aOutput = a;
        String bOutput = b;

        if (aLength < 7) aOutput = fill(a);
        if (bLength < 7) bOutput = fill(b);

        return sumAux(aOutput, bOutput, 7, "", false);
    }

    private String sumAux(String a, String b, int i, String result_aux, boolean carry){

        if (i == -1) return result_aux;

        char a_ = a.charAt(i);
        char b_ = b.charAt(i);

        if (!carry) {
            if (a_ == '1' & b_ == '0' || a_ == '0' & b_ == '1') {
                return sumAux(a, b, i-1, "1" + result_aux, false);
            } else if (a_ == '0' & b_ == '0') {
                return sumAux(a, b, i-1, "0" + result_aux, false);
            } else {
                return sumAux(a, b, i-1,  "0" + result_aux, true);
            }
        }

        else {
            if (a_ == '1' & b_ == '0' || a_ == '0' & b_ == '1') {
                return sumAux(a, b, i-1, "0" + result_aux, true);
            } else if (a_ == '0' & b_ == '0') {
                return sumAux(a, b, i-1, "1" + result_aux, false);
            } else {
                return sumAux(a, b, i-1, "1" + result_aux, true);
            }
        }
    }

    public String fill(String letter) {
        String zero = "";
        int dif = 8-letter.length();
        for (int i = 0; i < dif; i++){
            zero += "0";
        }
        return zero + letter;
    }

    @Override
    public String sub(String a, String b) {
        return null;
    }

    @Override
    public String mult(String a, String b) {
        return null;
    }

    @Override
    public String div(String a, String b) {
        return null;
    }

    @Override
    public String toHex(String binary) {
        return null;
    }

    @Override
    public String fromHex(String hex) {
        return null;
    }
}
