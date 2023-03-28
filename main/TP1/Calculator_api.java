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

