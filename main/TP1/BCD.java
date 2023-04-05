package TP1;

public class BCD implements BCDEncoder {
    @Override
    public String encode(int a) {
        String result = "";
        if (a ==0){
            result += '0';
        }
        while(a != 0){
            if (a%2 == 0){
                result += "0";
            }
            else if (a%2 == 1){
                result += '1';
            }
            a = a/2;
        }
        String finalResult = "";
        for (int i=result.length()-1; i >=0; i--){
            finalResult += result.charAt(i);
        }
        return finalResult;
    }

    @Override
    public int decode(String a) {
            int res = 0;
            for (int n = a.length() - 1; n >= 0; n--) {
                if (a.charAt(n) != '0') {
                    res += Math.pow(2, a.length() - n - 1);
                }
            }
            return res;
        }
}
