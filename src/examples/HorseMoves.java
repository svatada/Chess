package examples;

import java.util.ArrayList;
import java.util.List;

public class HorseMoves {
    public static final int MIN_BOX_INDEX = 0;
    public static final int MAX_BOX_INDEX = 7;
    private static final int MAX_POSSIBLE_HORSE_MOVES = 8;
    private static final int X_POSITIOM[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int Y_POSITION[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final String CO_ORDINATES = "(%d, %d)";

    // Driver program to check findPossibleMoves()
    public static void main(String[] args) {
        int stepCount = 0;
        List<String> visits = null;
        examples.HorseMoves chess = new examples.HorseMoves();
        for (int i = MIN_BOX_INDEX; i <= MAX_BOX_INDEX; i++) {
            for (int j = MIN_BOX_INDEX; j <= MAX_BOX_INDEX; j++) {
                visits = new ArrayList();
                visits.add(String.format(CO_ORDINATES, i, j));
                chess.moveHorse(visits, i, j);
                if (visits.size() == 64) {
                    System.out.println("Solution: " + stepCount++);
                    System.out.println(visits);
                }
            }
        }
    }

    public void moveHorse(List visits, int a, int b) {
        String move = null;
        for (int i = 0; i < MAX_POSSIBLE_HORSE_MOVES; i++) {
            int x = a + X_POSITIOM[i];
            int y = b + Y_POSITION[i];
            move = String.format(CO_ORDINATES, x, y);
            // Check valid moves
            if (x >= MIN_BOX_INDEX && y >= MIN_BOX_INDEX && x <= MAX_BOX_INDEX &&
                    y <= MAX_BOX_INDEX && !visits.contains(move)) {
                visits.add(move);
                moveHorse(visits, x, y);
            }
        }
    }
}
