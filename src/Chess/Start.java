package Chess;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException, StatusException {
        int port = 62097;
        Console console = new Console();
        UserInterface ui = new UserInterface();
        TCPStreams tcpStreams = new TCPStreams();
        ChessSender sender = new StreamBindingSender(tcpStreams.getDOS());
        ChessEngine engine = new ChessEngine(sender);
        StreamBindingReceiver receiver = new StreamBindingReceiver(tcpStreams.getDIS(), engine);
        System.out.println("Möchten Sie ein Spiel hosten? Wenn nein,treten Sie einem Spiel bei.");
        String r = console.readStringFromStdin("y/n");
        if (r.equals("y")) {
            tcpStreams.setPort(port);
            tcpStreams.host();
        } else if (r.equals("n")) {
            tcpStreams.join("localhost", port);
        } else {
            System.out.println("Fehler, beende das Spiel.");
            System.exit(0);
        }
        receiver.start();
        engine.sendDice();
        ui.setEngine(engine);
        ui.begin();
    }
}
