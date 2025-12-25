import java.util.*;



public class scrabble {

    public static int letterValue(char c) {
        if (c == 'A' || c == 'E') return 1;
        if (c == 'D' || c == 'R') return 2;
        if (c == 'B' || c == 'M') return 3;
        if (c == 'V' || c == 'Y') return 4;
        return 8;
    }

    public static boolean DoubleLetter(int square) {
        return square % 3 == 0 && (square / 3) % 2 == 1;
    }

    public static boolean TripleLetter(int square) {
        return square % 5 == 0 && !DoubleLetter(square);
    }

    public static boolean DoubleWord(int square) {
        return square % 7 == 0
                && !DoubleLetter(square)
                && !TripleLetter(square);
    }

    public static boolean TripleWord(int square) {
        return square % 8 == 0
                && !DoubleLetter(square)
                && !TripleLetter(square)
                && !DoubleWord(square);
    }

    public static int scoreWord(char[] word, int start) {
        int total = 0;
        int wordmult = 1;

        for (int i = 0; i < 4; i++) {
            int square = start + i;
            int letterscore = letterValue(word[i]);

            if (DoubleLetter(square)) letterscore *= 2;
            else if (TripleLetter(square)) letterscore *= 3;
            else if (DoubleWord(square)) wordmult = 2;
            else if (TripleWord(square)) wordmult = 3;

            total += letterscore;
        }

        return total * wordmult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] word = new char[4];
        for (int i = 0; i < 4; i++) {
            word[i] = sc.next().charAt(0);
        }

        for (int i = 1; i <= 5; i++) {
            int start = sc.nextInt();
            System.out.println(i + ". " + scoreWord(word, start));
        }
    }
}
