package Chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public int readIntegerFromStdin(String text) {
        int x = 0;
        Scanner e = new Scanner(System.in);

        try {
            System.out.println(text);
            x = e.nextInt();
            if (x < 0) {
                System.out.println("Die Zahl darf nicht negativ sein, bitte wiederolen.");
                readIntegerFromStdin(text);
            }
        } catch (InputMismatchException ime) {
            System.out.println("Die Eingabe war nicht richtig, bitte wiederholen. " + ime);
            readIntegerFromStdin(text);
        } catch (NumberFormatException nfe) {
            System.out.println("Das ist keine Zahl, bitte wiederholen. " + nfe);
            readIntegerFromStdin(text);
        }
        return x;
    }

    public String readStringFromStdin(String text) {
        String s = "";
        Scanner e = new Scanner(System.in);

        try {
            System.out.println(text);
            s = e.nextLine();
            if (s == "") {
                System.out.println("Die Eingabe war unvollständig, bitte wiederholen.");
                readStringFromStdin(text);
            }

        } catch (InputMismatchException ime) {
            System.out.println("Die Eingabe ist falsch, bitte wiederholen." + ime);
            readStringFromStdin(text);
        } catch (NullPointerException npe) {
            System.out.println("Es wurde keine Eingabe getätigt, bitte wiederholen." + npe);
            readStringFromStdin(text);
        }
        return s;
    }
}
