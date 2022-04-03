package subway.io;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return Input.scanner.nextLine();
    }

    public static Character readChar() {
        return readLine().charAt(0);
    }

    public static int readInt() throws NumberFormatException {
        return Integer.parseInt(readLine());
    }
}
