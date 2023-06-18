package hw17;

public class MethodArrayCheckComposition {

    public  boolean checkArray(int[] array) {
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : array) {
            if (num == 1) {
                hasOne = true;
            } else if (num == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour;
    }
}
