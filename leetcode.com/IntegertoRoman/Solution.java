public class Solution {

    public String intToRoman(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            num *= -1;
        }        

        String number = "";
        char [] romans = new char [] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};        

        int i = 0;
        while (num > 0) {
            int val = num % 10;
            String romVal = getValue(val, romans, i);
            number = romVal + number;
            num /= 10;
            i += 2;
        }        

        return number;
    }    

    private String getValue(int n, char [] romans, int i) {
        StringBuilder number = new StringBuilder();
        switch (n) {
            case 3: number.append(romans[i]);
            case 2: number.append(romans[i]);
            case 1: number.append(romans[i]);break;
            case 4: number.append(romans[i]);
                    number.append(romans[i + 1]);break;
            case 5: number.append(romans[i + 1]);break;
            case 6: number.append(romans[i + 1]);
                    number.append(romans[i]);break;
            case 7: number.append(romans[i + 1]);
                    number.append(romans[i]);
                    number.append(romans[i]);break;
            case 8: number.append(romans[i + 1]);
                    number.append(romans[i]);
                    number.append(romans[i]);
                    number.append(romans[i]);break;
            case 9: number.append(romans[i]);
                    number.append(romans[i + 2]);break;
            case 10:number.append(romans[i + 2]);break;
        }        

        return number.toString();
    }

}