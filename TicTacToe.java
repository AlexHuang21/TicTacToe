import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[][] array = new String[3][3];
        boolean bool = false;

        System.out.println("\nWelcome to tic tac toe! Place your \"X\" or \"O\" by typing in the\n"
                + "X coordinate followed by the Y coordinate on the tic tac toe board.\n"
                + "The X-axis of the board from left to right goes \"0, 1, 2\", and the\n"
                + "Y-axis of the board from top to bottom goes \"0, 1, 2\", as well. A \"-\"\n"
                + "character represents an empty space that is free to use. Good luck!\n");

        System.out.println("\nPlayer 1's turn!\n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = "- ";
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int x, y;
        int count = 0;

        while (!bool) {
            y = console.nextInt();
            x = console.nextInt();
            System.out.println();

            try {
                if (count % 2 == 0 && array[x][y] == "- ") {
                    System.out.println("\nPlayer 2's turn!\n");
                    array[x][y] = "X ";

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(array[i][j]);
                        }
                        System.out.println();
                    }

                    count++;

                } else if (array[x][y] == "- ") {
                    System.out.println("\nPlayer 1's turn!\n");
                    array[x][y] = "O ";

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(array[i][j]);
                        }
                        System.out.println();
                    }

                    count++;
                } else {
                    System.out.println("This spot is already taken! Try again.");
                }
                System.out.println();

                for (int i = 0; i < 3; i++) {
                    if ((((array[i][0] == array[i][1] && array[i][0] == array[i][2]) && array[i][0] != "- ")
                            || (array[0][i] == array[1][i] && array[0][i] == array[2][i]) && array[0][i] != "- ")) {
                        bool = true;
                    }
                }

                if ((array[0][0] == array[1][1] && array[0][0] == array[2][2]
                        || array[0][2] == array[1][1] && array[0][2] == array[2][0]) && array[1][1] != "- ") {
                    bool = true;
                }
            } catch (Exception e) {
                System.out.println("That's not a spot on the board! Try again.");
            }
        }

        winCon(bool, count);
        System.out.println("Thanks for playing!\n");
        console.close();
    }

    public static void winCon(boolean bool, int count) {
        if (bool && count % 2 == 0) {
            System.out.println("Player 2 wins!");
        } else if (bool) {
            System.out.println("Player 1 wins!");
        } else if (count == 9) {
            System.out.println("Cat's game!");
        }
    }
}