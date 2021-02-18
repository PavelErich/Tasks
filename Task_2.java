public class Task_2 {
    public static void main(String[] args){
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
    }
    //Функция принимает figure, начальную позицию и позицию куда идет
    //Возвращает true - если ход возможен, иначе false
    //Примечание: для пешки ход назад на 1 клетку будет возвращать true
    //т.к. этот ход может быть сделан противником. (сверху вниз)
    public static boolean canMove(String figure, String from, String to){
        int x1 = from.charAt(0) - 'A';
        int y1 = from.charAt(1) - '0';
        int x2 = to.charAt(0) - 'A';
        int y2 = to.charAt(1) - '0';
        //Если координаты зашли за пределы поля или ход на одном месте
        if((x2 == 0 && x2 > 8) || (y2 == 0 && y2 > 8)
           || (x1 == x2 && y1 == y2))
            return false;
        if(figure == "Rook")
            return x1 == x2 || y1 == y2;
        else if(figure == "Knight"){
            int rx = Math.abs(x1 - x2);
            int ry = Math.abs(y1 - y2);
            return (rx == 1 && ry == 2) || (rx == 2 && ry == 1);
        }
        else if(figure == "Bishop")
            return Math.abs(x1 - x2) == Math.abs(y1 - y2);
        else if(figure == "Queen")
            return x2 == x1 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2);
        else if(figure == "King")
            return Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1;
        else if(figure == "Pawn")
            return Math.abs(y2 - y1) == 1;

        return false;
    }
}