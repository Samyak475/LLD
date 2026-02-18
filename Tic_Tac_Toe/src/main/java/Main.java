public class Main {
    public static  void main(String[] args){
        TicTacToeSystem ticTacToeSystem = new TicTacToeSystem();
        ticTacToeSystem.initialiseGame();
        System.out.println("Winner of game is "+ ticTacToeSystem.startGame());
    }
}
