public class Task_10 {
    public static void main(String[] args) {
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }

    //Функция возращает общее кол-во уникальных символов
    //Между всеми парами концов книги.
    public static int countUniqueBooks(String text, char symbol) {
        //Строка с уникальными символами
        String uniqChars = "";
        int index = 0;
        int count = 0;
        for (int i = 1; i < text.length() && i != 0; i++) {
            index = text.indexOf(symbol, i);
            for (int j = i; j < index; j++) {
                int q = uniqChars.indexOf(text.charAt(j));
                if (q == -1) {
                    uniqChars += text.charAt(j);
                    count++;
                }
            }
            i = text.indexOf(symbol, index + 1);
        }
        return count;
    }
}
