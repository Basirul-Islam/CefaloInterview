import java.util.Scanner;

public class Problem01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String notation = sc.next();
        System.out.println(decodeSymbolicNotation(notation));

    }

    static int decodeSymbolicNotation(String notation) {

        int block01Value = 0, block02Value = 0, block03Value = 0;
        int r = 0, w = 0, x = 0, dash = 0;
        String finalBlockValue;
        char[] charArr = notation.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'r') {
                r += 4;
            } else if (charArr[i] == 'w') {
                w += 2;
            } else if (charArr[i] == 'x') {
                x += 1;
            } else if (charArr[i] == '-') {
                dash += 0;
            }
            if (i == 2) {
                block01Value = r + w + x + dash;
                r = w = x = dash = 0;
            } else if (i == 5) {
                block02Value = r + w + x + dash;
                r = w = x = dash = 0;
            } else if (i == 8) {
                block03Value = r + w + x + dash;
            }
        }
        finalBlockValue = String.valueOf(block01Value) + String.valueOf(block02Value) + String.valueOf(block03Value);
        return Integer.parseInt(finalBlockValue);
    }
}
