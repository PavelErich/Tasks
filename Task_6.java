public class Task_6 {
    public static void main(String[] args){
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
    }
    //Функция принимает номер числа в последовательности Улама
    //Возвращает само число.
    public static int ulam(int number){
        if(number < 1) throw new IllegalArgumentException("The 'number' cannot " +
                "be less than 1");
        if(number <= 4) return number;
        //Алгоритм основан на полном переборе
        int seq[] = new int[number];
        seq[0] = 1; seq[1] = 2;
        int z = 0, n = 3;
        for(int i = 2; i < number; n++, z = 0){
            for(int j = 0; j < i; j++)
                for(int k = 0; k < i; k++)
                    if(seq[j] < seq[k] && seq[j] + seq[k] == n)
                        z++;
            //Если кол-во получить n = 1
            if(z == 1)
                seq[i++] = n;
        }
        return n - 1;
    }
}