public class SHA256 {
    //Таблица констант
    //Первые 32 бита дробный частей кубических корней первых 64 простых чисел
    //[от 2 до 311]
    private static int k[] = new int[] {
            0x428a2f98,0x71374491,0xb5c0fbcf,0xe9b5dba5,0x3956c25b,0x59f111f1,0x923f82a4,0xab1c5ed5,
            0xd807aa98,0x12835b01,0x243185be,0x550c7dc3,0x72be5d74,0x80deb1fe,0x9bdc06a7,0xc19bf174,
            0xe49b69c1,0xefbe4786,0x0fc19dc6,0x240ca1cc,0x2de92c6f,0x4a7484aa,0x5cb0a9dc,0x76f988da,
            0x983e5152,0xa831c66d,0xb00327c8,0xbf597fc7,0xc6e00bf3,0xd5a79147,0x06ca6351,0x14292967,
            0x27b70a85,0x2e1b2138,0x4d2c6dfc,0x53380d13,0x650a7354,0x766a0abb,0x81c2c92e,0x92722c85,
            0xa2bfe8a1,0xa81a664b,0xc24b8b70,0xc76c51a3,0xd192e819,0xd6990624,0xf40e3585,0x106aa070,
            0x19a4c116,0x1e376c08,0x2748774c,0x34b0bcb5,0x391c0cb3,0x4ed8aa4a,0x5b9cca4f,0x682e6ff3,
            0x748f82ee,0x78a5636f,0x84c87814,0x8cc70208,0x90befffa,0xa4506ceb,0xbef9a3f7,0xc67178f2
    };
    //Первые 32 бита дробных частей квадратных корней 2,3,5,7,11,13,17,19
    private static int h[] = new int[] {0x6A09E667, 0xBB67AE85, 0x3C6EF372, 0xA54FF53A,
            0x510E527F, 0x9B05688C, 0x1F83D9AB, 0x5BE0CD19};

    //Массив вспомогательных переменных
    private static int state[] = new int[8];
    //Блок данных
    private static int data[] = new int[64];
    //Размер рассматриваемых данных
    private static int dataLen = 0;
    //Кол-во битов
    private static long bitLen = 0;
    public static void init(){
        //Иницианализация переменных
        for(int i = 0; i < state.length; i++)
            state[i] = h[i];
        dataLen = 0;
        bitLen = 0;
    }
    public static byte[] getHash(byte[] bytes){
        //Заносим переданные данные в data
        for(int i = 0; i < bytes.length; i++) {
            data[dataLen++] = bytes[i];
            //Заносим по 64 байта (512 бит)
            if (dataLen == 64) {
                //Обновлем вспомогательные переменных
                update();
                bitLen += 512;
                dataLen = 0;
            }
        }
        //Рассмотрение оставшихся данных + 1 и нули
        int i = dataLen;
        //Если в данном блоке данных есть место под единицу и
        //64 бита под длину сообщения в порядке big-endian
        //(от старшего к младшему биту)
        if(i < 56){
            data[i++] = 128;
            while(i < 56)
                data[i++] = 0;
        }
        //Если же места под все не хватает, то
        //делаем доп. обновление.
        else {
            //Добавляем 1
            data[i++] = 128;
            //Пока есть место добавляем нули
            while(i < 64)
                data[i++] = 0;
            //Собранный блок данных прогоняем
            update();
            //Собираем новый блок, очищая первые 56 байт
            for(int j = 0; j < 56; j++)
                data[j] = 0;
        }

        //Подсчитываем итоговую длину сообщения
        bitLen += dataLen * 8;
        //Вносим в блок данных в порядке big-endian
        for(int j = 0; j < 8; j++)
            data[63 - j] = (int)(bitLen >> (j * 8));
        //Делаем последнее обновление вспомогательных переменных
        update();

        //Т.к. мы используем порядок битов little-endian (от младшего
        //к старшему), а SHA256 - big-endian, то вместе с преобразованием
        //вспомогательных переменных в массив байт, так же изменим и порядок
        byte hash[] = new byte[32];
        for (i = 0; i < 4; ++i)
            for(int k = 0, j = 0; k < state.length; k++, j += 4)
                hash[i + j] = (byte)((state[k] >> (24 - i * 8)) & 0xff);
        return hash;
    }
    //Функция обновления вспомогательных переменных
    //для рассматриваемого блока данных
    private static void update(){
        //Массив слов
        int m[] = new int[64];
        //Временный массив вспомогательных переменных
        int abc[] = new int[8];
        //Т.к. максимальная длина блока это 512 битов
        //то первые 16 слов будут заняты данными
        int i = 0;
        for(int j = 0; i < 16; i++, j += 4)
            m[i] = (data[j] << 24) | (data[j + 1] << 16) | (data[j + 2] << 8) | data[j + 3];
        //Расчет остальных слов
        for(; i < 64; i++)
            m[i] = sig1(m[i - 2]) + m[i - 7] + sig0(m[i - 15]) + m[i - 16];
        //Иницианализация временного массива
        for(int j = 0; j < abc.length; j++)
            abc[j] = state[j];
        int t1, t2;
        for(i = 0; i < 64; i++){
            t1 = abc[7] + ep1(abc[4]) + ch(abc[4],abc[5],abc[6]) + k[i] + m[i];
            t2 = ep0(abc[0]) + maj(abc[0],abc[1],abc[2]);
            //Сдвиг вспомогательных сверху вниз
            for(int j = abc.length - 1; j >= 1; j--)
                abc[j] = abc[j - 1];
            //к 'e' добавляем t1
            abc[4] += t1;
            //'a'
            abc[0] = t1 + t2;
        }
        //Изменения главного массив вспомогательных переменных
        for(int j = 0; j < abc.length; j++)
            state[j] += abc[j];
    }
    /*
        Вспомогательные функции
     */
    private static int ch(int x, int y, int z){
        return (x & y) ^ ((~x) & z);
    }
    private static int maj(int x, int y, int z){
        return (x & y) ^ (x & z) ^ (y & z);
    }
    private static int ep0(int x){
        return Integer.rotateRight(x, 2) ^
               Integer.rotateRight(x, 13) ^
               Integer.rotateRight(x, 22);
    }
    private static int ep1(int x){
        return Integer.rotateRight(x, 6) ^
               Integer.rotateRight(x, 11) ^
               Integer.rotateRight(x, 25);
    }
    private static int sig0(int x){
        return Integer.rotateRight(x, 7) ^
               Integer.rotateRight(x, 18) ^
               (x >>> 3);
    }
    private static int sig1(int x){
        return Integer.rotateRight(x, 17) ^
               Integer.rotateRight(x,19) ^
                (x >>> 10);
    }
}