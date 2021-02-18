public class Task_10 {
    public static void main(String[] argc){
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }
    //Принимает 3 аргумента типа int
    //Возвращает true - если числа являются ребрами прямоугольного
    //треугольника, иначе false
    public static boolean rightTriangle(int x, int y, int z){
        long _x = (long)x * x;
        long _y = (long)y * y;
        long _z = (long)z * z;
        //Проверяем все случаи возможной Пифагоровой тройки
        return _x + _y == _z || _x + _z == _y || _y + _z == _x;
    }
}