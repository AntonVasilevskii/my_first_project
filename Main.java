import java.util.*;

public class Main {

    static boolean whoseTurn(char[][] CharArrayDouble){
        int countX = 0;
        int countO = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (CharArrayDouble[i][j] == 'X') {
                    countX++;
                } else if (CharArrayDouble[i][j] == 'O') {
                    countO++;
                }
            }
        }
        if(countX - countO == 0){
            return true;
        } else {
            return false;
        }
    }

    static boolean gameNotFinished(char[][] CharArrayDouble){
        boolean zero = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(CharArrayDouble[i][j] == ' '){
                    zero = true;
                    break;
                }
            }
            if(zero){
                break;
            }
        }
        return zero;
    }

    static boolean winsX(char[][] CharArrayDouble){
        char x = 'X';
        boolean win;
        if(CharArrayDouble[0][0] == x && CharArrayDouble[0][1] == x && CharArrayDouble[0][2] == x){
            win = true;
        } else if(CharArrayDouble[1][0] == x && CharArrayDouble[1][1] == x && CharArrayDouble[1][2] == x){
            win = true;
        } else if(CharArrayDouble[2][0] == x && CharArrayDouble[2][1] == x && CharArrayDouble[2][2] == x){
            win = true;
        } else if(CharArrayDouble[0][0] == x && CharArrayDouble[1][1] == x && CharArrayDouble[2][2] == x){
            win = true;
        } else if(CharArrayDouble[2][0] == x && CharArrayDouble[1][1] == x && CharArrayDouble[0][2] == x){
            win = true;
        } else if(CharArrayDouble[0][0] == x && CharArrayDouble[1][0] == x && CharArrayDouble[2][0] == x){
            win = true;
        } else if(CharArrayDouble[0][1] == x && CharArrayDouble[1][1] == x && CharArrayDouble[2][1] == x){
            win = true;
        } else if(CharArrayDouble[0][2] == x && CharArrayDouble[1][2] == x && CharArrayDouble[2][2] == x){
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    static boolean winsO(char[][] CharArrayDouble){
        char o = 'O';
        boolean win;
        if(CharArrayDouble[0][0] == o && CharArrayDouble[0][1] == o && CharArrayDouble[0][2] == o){
            win = true;
        } else if(CharArrayDouble[1][0] == o && CharArrayDouble[1][1] == o && CharArrayDouble[1][2] == o){
            win = true;
        } else if(CharArrayDouble[2][0] == o && CharArrayDouble[2][1] == o && CharArrayDouble[2][2] == o){
            win = true;
        } else if(CharArrayDouble[0][0] == o && CharArrayDouble[1][1] == o && CharArrayDouble[2][2] == o){
            win = true;
        } else if(CharArrayDouble[2][0] == o && CharArrayDouble[1][1] == o && CharArrayDouble[0][2] == o){
            win = true;
        } else if(CharArrayDouble[0][0] == o && CharArrayDouble[1][0] == o && CharArrayDouble[2][0] == o){
            win = true;
        } else if(CharArrayDouble[0][1] == o && CharArrayDouble[1][1] == o && CharArrayDouble[2][1] == o){
            win = true;
        } else if(CharArrayDouble[0][2] == o && CharArrayDouble[1][2] == o && CharArrayDouble[2][2] == o){
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    static char[][] inputCoordinat(char[][] CharArrayDouble, char turn) {  // Ввод координат и их проверка
        Scanner scanner = new Scanner(System.in);
        String text;
        boolean check = true;
        while (check) {
            text = scanner.nextLine();
            System.out.println("Enter the coordinates: " + text);
            text = text.trim();   // считываем введенную строку и убираем пробелы в начале и в конце строки
            if (text.matches("[1-3]\\s+[1-3]")) {
                String[] mas = text.split("\\s+");
                int[] numbers = new int[mas.length];
                for (int i = 0; i < mas.length; i++) {
                    numbers[i] = Integer.parseInt(mas[i]);
                }
                int x = numbers[0];
                int y = numbers[1];
                int i = 0;
                int j = 0;
                switch (x){
                    case 1:
                        j = 0;
                        break;
                    case 2:
                        j = 1;
                        break;
                    case 3:
                        j = 2;
                        break;
                    default:
                        break;
                }
                switch (y){
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 1;
                        break;
                    case 3:
                        i = 0;
                        break;
                    default:
                        break;
                }
                if(CharArrayDouble[i][j] == ' ' && turn == 'X'){
                    CharArrayDouble[i][j] = 'X';
                    check = false;
                } else if(CharArrayDouble[i][j] == ' ' && turn == 'O'){
                    CharArrayDouble[i][j] = 'O';
                    check = false;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    check = true;
                }
            } else if(text.matches("[4-9]\\s+[4-9]")){ // Если большие цифры, нодо доработать!!
                System.out.println("Coordinates should be from 1 to 3!");
                continue;

            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
        return CharArrayDouble;
    }

    static void getField(char[][] CharArrayDouble){ // Вывод поля.
        System.out.println("---------");
        System.out.println("| " + CharArrayDouble[0][0] + " " + CharArrayDouble[0][1] + " " + CharArrayDouble[0][2] + " |");
        System.out.println("| " + CharArrayDouble[1][0] + " " + CharArrayDouble[1][1] + " " + CharArrayDouble[1][2] + " |");
        System.out.println("| " + CharArrayDouble[2][0] + " " + CharArrayDouble[2][1] + " " + CharArrayDouble[2][2] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        int maxField = 3;
        char[][] CharArrayDouble = new char[maxField][maxField];
        for(int i = 0; i < maxField; i++){
            for(int j = 0; j < maxField; j++){
                CharArrayDouble[i][j] = ' ';
            }
        }
        getField(CharArrayDouble); // Выводим пустое поле
        boolean gameOver;
        do{
            if(whoseTurn(CharArrayDouble)){ // чей ход?
                CharArrayDouble = inputCoordinat(CharArrayDouble, 'X'); // Вводим координаты и заполняем поле (ходит Х)
            } else {
                CharArrayDouble = inputCoordinat(CharArrayDouble, 'O'); // Вводим координаты и заполняем поле (ходит O)
            }
            getField(CharArrayDouble); // Выводим заполненное поле
            if(winsX(CharArrayDouble)){
                System.out.println("X wins");
                break;
            } else if(winsO(CharArrayDouble)){
                System.out.println("O wins");
                break;
            } else if(!gameNotFinished(CharArrayDouble)){
                System.out.println("Draw");
                break;
            } else {
                gameOver = true;
            }
        }while (gameOver);
    }
}