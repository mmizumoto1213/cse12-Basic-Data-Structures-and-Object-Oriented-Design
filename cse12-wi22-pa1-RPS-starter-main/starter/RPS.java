/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import java.util.Scanner;

/**
 * TODO: Add your class header (purpose and capabilities of the class)
 */
public class RPS extends RPSAbstract {
    
    /**
     * TODO: Add method header
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove)
    {
        // TODO

        if (playerMove.equals(cpuMove)) {
            return TIE_OUTCOME;
        }

        int playerMoveNum = -1;
        int cpuMoveNum = -1;
        for (int i = 0; i < possibleMoves.length; i++) {
            if (possibleMoves[i].equals(playerMove)) {
                playerMoveNum = i;
            } else if (possibleMoves[i].equals(cpuMove)) {
                cpuMoveNum = i;
            }
        }

        if (playerMoveNum != -1 && cpuMoveNum != -1) {
            if (playerMoveNum + 1 == cpuMoveNum || (playerMoveNum == possibleMoves.length - 1 && cpuMoveNum == 0)) {
                return PLAYER_WIN_OUTCOME;
            } else if (cpuMoveNum + 1 == playerMoveNum || (cpuMoveNum == possibleMoves.length - 1 && playerMoveNum == 0)) {
                return CPU_WIN_OUTCOME;
            } else {
                return TIE_OUTCOME;
            }
        }
        return INVALID_INPUT_OUTCOME;
    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
        
        String playerMove = "placeholder";
        String cpuMove = "placeholder";

        while (!playerMove.equals("q")) {
            System.out.println(PROMPT_MOVE);
            playerMove = in.nextLine();
            cpuMove = game.genCPUMove();
            if (!game.isValidMove(playerMove) && !playerMove.equals("q")) {
                System.out.println(INVALID_INPUT);
            }
            if (game.isValidMove(playerMove) && !playerMove.equals("q")) {
                game.play(playerMove, cpuMove);
            }
        }

        game.end();

        // TODO: Insert the code to play the game. 
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written 
        // to do most of the work!


        in.close();
    }
}
