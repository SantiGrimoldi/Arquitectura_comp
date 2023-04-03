package TP1;

public class Calculator_api implements Calculator {

    @Override
    public String sum(String a, String b) {
        char char_a;
        char char_b;
        String result = "";
        String carry = "0";
        if (a.length()<b.length()){
            int difference = b.length() - a.length();
            String zeros = "";
            for (int i = 0;i<difference;i++){
                zeros+="0";
            }
            zeros+=a;
            a= zeros;

        }
        if(b.length()<a.length()){
            int difference = a.length() - b.length();
            String zeros = "";
            for (int i = 0;i<difference;i++){
                zeros+="0";
            }
            zeros+=b;
            b = zeros;
        }
        a = swap(a);
        b = swap(b);

        for(int i= 0;i<a.length();i++){
            char_a = a.charAt(i);
            char_b = b.charAt(i);
            boolean positive_a = char_a == '1';
            boolean positive_b = char_b =='1';
            if (positive_a&&positive_b){
                if(carry=="1"){
                    result+=1;

                }
                else{
                    carry = "1";
                    result += 0;
                }
            }
            if((positive_a&& !positive_b) ||(!positive_a&&positive_b)){
                if (carry=="1"){
                    carry ="1";
                    result+=0;
                }
                else {
                    result+=1;

                }
            }
            if(!positive_a&&!positive_b){
                if(carry=="1"){
                    result+=1;
                    carry = "0";
                }
                else {
                    result+=0;
                }
            }
        }
        if(carry=="1"){
            result+=1;
        }


        return swap(result);
    }

    String swap(String a){
        String solution ="";
        for(int i =a.length()-1; i>=0;i--){
            solution+=a.charAt(i);
        }
        return solution;
    }
    @Override
    public String sub(String a, String b) {
        String complementoB = sum(complemento(b), "1");

        String resultadoComplemento = sum(a, complementoB);
        String resultadoFinal = "";
        for (int i = 1; i<resultadoComplemento.length(); i++){
            resultadoFinal += resultadoComplemento.charAt(i);
        }
        return resultadoFinal;

    }
    public static String complemento(String a) {
        String complemento = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                complemento += '1';
            } else {
                complemento += '0';
            }
        }
        return complemento;
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
        //primero pasar a decimal
        int n = Integer.parseInt(binary, 2);
        String hex = Integer.toHexString(n);
        return hex.toUpperCase();
    }

    @Override
    public String fromHex(String hex) {

        int n = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(n);
        while (bin.length() < 8) {
            bin = "0" + bin;
        }
        return bin;
    }
}

