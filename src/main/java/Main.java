public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"0", "1", "2", "3"},
                {"9", "3", "6", "9"},
        };

        try {
            System.out.println("Сумма значений массива - " + getSum(arr, 4));
        } catch (MyArraySizeException e) {
            System.out.println("Суммирование невозможно. Неверный размер массива.");
        } catch (MyArrayDataException e) {
            System.out.println("Невозможно вычислить сумму массива. В ячейке " + e.getCoordinates() + " некорректные данные");
        }
    }

    public static int getSum(String[][] arr, int arraySize) throws MyArrayDataException, MyArraySizeException {
        int result = 0;

        if (arr.length != arraySize) {
            throw new MyArraySizeException("Неверный размер массива", arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arraySize) {
                throw new MyArraySizeException("Неверный размер массива", arr[i].length);
            }

            for (int j = 0; j < arr[i].length; ++j) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать элемент массива в числовое значение", i, j);
                }
            }
        }

        return result;
    }
}