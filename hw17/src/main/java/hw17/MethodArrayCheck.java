package hw17;

public class MethodArrayCheck {
    public  int[] arrayCheckingElements(int[] array, int a) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                index = i;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Масив не містить  " + a);
        }
        int[] result = new int[array.length - index - 1];
        int resultIndex = 0;
        for (int i = index + 1; i < array.length; i++) {
            result[resultIndex] = array[i];
            resultIndex++;
        }
        return result;
    }


}
