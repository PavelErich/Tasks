public class Task_1 {
    public static void main(String[] args){
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
    }
    //Функция принимает размер множества
    //и возвращает кол-во различных способов разбиения
    //множества. Вычисление происходит с помощью
    //треугольника Пирса.
    public static int bell(int n){
        if(n <= 1) return 1;
        //Верхний ряд
        int ftmp[] = new int[n];
        //Нижний ряд
        int stmp[] = new int[n];
        //Начальная инициализация
        ftmp[0] = 1;
        for(int i = 0; i < n - 1; i++) {
            //Устанавливаем первое число, как самое правое
            //верхнего ряда
            stmp[0] = ftmp[i];
            //Расчитываем остальные элементы
            for (int j = 1; j <= i + 1; j++)
                stmp[j] = ftmp[j - 1] + stmp[j - 1];
            //Копируем нижний ряд в верхний
            for (int j = 0; j <= i + 1; j++)
                ftmp[j] = stmp[j];
        }
        return stmp[n - 1];
    }
}