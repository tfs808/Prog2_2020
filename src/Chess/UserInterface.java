package Chess;

import java.io.IOException;

public class UserInterface {
    ChessEngine engine;
    Console console;

    public void setEngine(ChessEngine engine) {
        this.engine = engine;
    }

    public void begin () throws IOException, StatusException {
        while (true) {
            if (engine.getStatus() == ChessStatus.ACTIVE) {
                System.out.println("Was wollen Sie tun?");
                System.out.println("1. Zug \n 2. Rochade 3. Aufgeben 4. Schachmatt");
                int cmd = console.readIntegerFromStdin("Bitte geben Sie die entsprechende Zahl ein.");
                switch (cmd) {
                    case 1:
                        System.out.println("Geben Sie die Koordinaten der Figur an, die Sie bewegen möchten und wohin.");
                        int fromx = console.readIntegerFromStdin("Von X:") - 1;
                        int fromy = console.readIntegerFromStdin("Von Y:") - 1;
                        int tox = console.readIntegerFromStdin("Nach X:") - 1;
                        int toy = console.readIntegerFromStdin("Nach Y:") - 1;
                        engine.sendMove(fromx, fromy, tox, toy);
                        break;
                    case 2:
                        System.out.println("Geben Sie die Koordinaten des Turms an, mit dem Sie den Rochade Zug ausführen möchten.");
                        int rfromx = console.readIntegerFromStdin("Turm X:") - 1;
                        int rfromy = console.readIntegerFromStdin("Turm Y:") - 1;
                        engine.sendRochade(rfromx, rfromy);
                        break;
                    case 3:
                        engine.sendAbandon();
                        break;
                    case 4:
                        engine.sendCheckMate();
                        break;
                }
            }
            else if (engine.getStatus() == ChessStatus.END) {
                System.out.println("Das Spiel ist beendet");
                System.exit(0);
            }
        }
    }
}
