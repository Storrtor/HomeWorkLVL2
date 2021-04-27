package HomeWork2;

public class App {

    public static void main(String[] args) {

        String[][] a = new String[][]{{"10","9","8","7"},{"0","2b","0","0"},{"0","0","7","0"},{"1","1","1","1"}};
        String[][] b = new String[][]{{"1","2","2","2"},{"1","1","1","1"}};

        sumArray(a);
        //sumArray(b);
    }

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * @param array
     */
    public static int sumArray(String array[][]){
        int a = 0;
        if (array.length != 4){
            throw new MyArraySizeException("Передайте массив размером 4х4");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    a += Integer.parseInt(array[i][j]);
                } catch (MyArrayDataException ex){
                    System.out.print("Неверные данные в ячейке: " + i + " j = " + j +"\n");
                    System.out.println("Сумма была посчитана без неверно введенных элементов. Для расчета правильной суммы введите корректные значения.");
                    ex.printStackTrace(System.out);
                }
            }
        }

        System.out.println(a);
        return a;
    }
}
