package HomeWork2;

public class App {

    public static void main(String[] args) {

        String[][] a = new String[][]{{"10","9","8","7"},{"0","2","0","0"},{"0","0","7","0"},{"1","1","1","1"}};
        String[][] b = new String[][]{{"1","2","2","2"},{"1","1","1","1"}};

        sumArray(a);
        //sumArray(b);
    }

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     *
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
     *
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
     * и вывести результат расчета.
     * @param array
     */
    public static int sumArray(String array[][]){
        int a = 0;
        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Передайте массив размером 4х4");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    a += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex){
                    throw new MyArrayDataException("Данные не являющиеся числами в ячейке: " + i + " " + j);
                }
            }
        }
        System.out.println("Сумма = " + a);
        return a;
    }
}