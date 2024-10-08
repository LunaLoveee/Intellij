package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count0 = 0, count1 = 0;

        if (str.charAt(0) == '0') {
            count0++;
        }
        else {
            count1++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (str.charAt(i) == '0') {
                    count0++;
                }
                else {
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
