public class Task_8 {
    public static void main(String[] args){
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
    }
    //Функция принимает строку и возвращает её хеш
    //в виде hex-строки
    public static String getSha256Hash(String str){
        //Инициализируем переменные
        SHA256.init();
        byte[] bytes = SHA256.getHash(str.getBytes());
        return bytesToHex(bytes);
    }
    //Функция преобразования массива байт в hex-строку
    public static String bytesToHex(byte[] bytes){
        final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for(int i = 0; i < bytes.length; i++){
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}