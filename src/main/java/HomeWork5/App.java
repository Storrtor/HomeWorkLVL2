package HomeWork5;

import java.util.Arrays;

public class App {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        createArrayOne();
        crateArrayTwo();
    }

    /**
     * 1) Создают одномерный длинный массив.
     * 2) Заполняют этот массив единицами;
     * 3) Засекают время выполнения: long a = System.currentTimeMillis();
     * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
     * 5) Проверяется время окончания метода System.currentTimeMillis();
     * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
     *
     * По замерам времени:
     * Для первого метода надо считать время только на цикл расчета
     */
    public static void createArrayOne(){
        float[] arr = new float[size];
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

    }

    /**
     * Аналогично первому, но разбивает массив на два массива,
     * в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
     *
     * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */
    public static void crateArrayTwo(){
        float[] arr = new float[size];
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, 0, a1, 0, h);
                for (int i = 0; i < h; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
                System.arraycopy(a1, 0, arr, 0, h);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, h, a2, 0, h);
                for (int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a2, 0, arr, h, h);
            }
        });
        t1.start();
        t2.start();

        System.out.println(System.currentTimeMillis() - a);

    }

}
