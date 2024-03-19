class Solution {
    public int divide(int dividend, int divisor) {
        int nflag = 0;
        int leftflag = 0;
        int tempCounter = 0;
        int tempdiv = 0;
        String diviOp;
        StringBuilder tempString = new StringBuilder();
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MAX_VALUE) {
            return -1;
        }
        if (dividend < 0) {
            nflag++;
            String temp = Integer.toString(dividend);
            diviOp = temp.substring(1, temp.length());
            try {
                dividend = Integer.parseInt(temp.substring(1, temp.length()));
            } catch (NumberFormatException e) {
                dividend = Integer.MAX_VALUE;
            }
        } else {
            diviOp = Integer.toString(dividend);
        }
        if (divisor < 0) {
            nflag++;
            String temp = Integer.toString(divisor);
            try {
                divisor = Integer.parseInt(temp.substring(1, temp.length()));
            } catch (NumberFormatException e) {
                divisor = Integer.MAX_VALUE;
                leftflag++;
            }
        }
        StringBuilder answer = new StringBuilder();
        if (nflag == 1) {
            answer.append('-');
        }
        for (int i = 0; i < diviOp.length(); i++) {
            tempString.append(diviOp.charAt(i));
            try {
                tempdiv = Integer.parseInt(tempString.toString());
            } catch (NumberFormatException e) {
                tempdiv = Integer.MAX_VALUE;
            }
            if (tempdiv >= divisor) {
                while (tempdiv >= divisor) {
                    tempdiv -= divisor;
                    tempCounter++;
                }
                answer.append(Integer.toString(tempCounter));
                tempCounter = 0;
                tempString.setLength(0);
                tempString.append(Integer.toString(tempdiv));
            } else {
                if (divisor > dividend) {
                    break;
                } else {
                    answer.append("0");
                }
            }
        }
        if (answer.toString().compareTo("") == 0 || answer.toString().compareTo("-") == 0) {
            return 0;
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(answer.toString());
        } catch (NumberFormatException e) {
            ans = Integer.MAX_VALUE;
        }

        if (leftflag == 1 && nflag == 1) {
            ans--;
        }
        return ans;
    }
}