public class Task_10 {
    public static void main(String[] args){
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
    }
    //Функция возвращает иллюстрацию центрированного
    //шестиугольника в виде многострочной прямоугольной строки
    //иначе возвращает 'Invalid'
    public static String hexLattice(int n){
        int index = 1;
        int nn = 1;
        //Определяем является ли n, частью последовательности
        while(nn < n){ 
            index++;
            nn = 3*index*index - 3*index + 1;
        }
        if(nn != n) return "Invalid";
        index--;
        String res = "";

        //Верхняя часть + средняя линия
        int count_space = index;
        int count_o     = index + 1;
        int line        = 0;
        for(; line < index + 1; line++, count_o++, count_space--)
            res += getNextLine(count_space, count_o) + '\n';

        //Нижняя часть
        count_o = index * 2;
        count_space = 1;
        for(line = 0; line < index; line++, count_o--, count_space++)
            res += getNextLine(count_space, count_o) + (line != index ? '\n' : "");

        return res.substring(0, res.length() - 1);
    }
    //Функция возвращает строку, где сначала идет countSpace пробелов
    //а потом через пробел countO символов o
    public static String getNextLine(int countSpace, int countO){
        String res = "";
        for(int j = 0; j < countSpace; j++)
            res += " ";
        for(int j = 0; j < countO; j++)
            res += "o ";
        return res;
    }
}