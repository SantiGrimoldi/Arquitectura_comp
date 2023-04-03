package TP1;

public class Calculator_api implements Calculator {

    @Override
    public String sum(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        String aOutput = a;
        String bOutput = b;

        if (aLength > bLength) bOutput = fill(b, aLength);
        if (bLength > aLength) aOutput = fill(a, bLength);

        return sumAux(aOutput, bOutput, aOutput.length()-1, "", false);
    }

    private String sumAux(String a, String b, int i, String result_aux, boolean carry){

        if (i == -1) {
            if (carry){
                result_aux = "1"+result_aux;
            }
            return result_aux;
        }


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

    private String fill(String letter, int j) {
        String zero = "";
        int dif = j - letter.length();
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
        int aLength = a.length();
        int bLength = b.length();
        boolean firstTime = true;

        int counter = 0;
        String actualResult = "";

        for (int i = bLength -1; i >= 0; i--){
            String tempResult = "";
            for (int j = aLength -1 ; j >= 0; j--){
                if (a.charAt(j) == '0' || b.charAt(i) == '0'){
                    tempResult = "0" + tempResult;
                }
                else tempResult = "1" + tempResult;
            }
            if (!firstTime) {
                int counterCopy = counter;
                while (counterCopy > 0) {
                    tempResult = tempResult + "0";
                    counterCopy--;
                }
                actualResult = sum(actualResult, tempResult);
            }
            else {
                actualResult = tempResult;
                firstTime = false;
            }
            counter ++;
        }
        return actualResult;
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

