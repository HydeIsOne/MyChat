package homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));
    }

    public static int[] ArrayAfter4(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }

        if ((!list.contains(4)) || (list.get(list.size()-1)==4)) throw new RuntimeException();

        int index = list.lastIndexOf(4);
        int[] newArray = new int[array.length - index - 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i + index + 1];
            if (i == newArray.length - 1) break;
        }
        return newArray;
    }


    public static boolean ArrayCheckNumbers(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        if (list.contains(1)&&list.contains(4)){
            return true;
        }
        else {
            return false;
        }
    }

}