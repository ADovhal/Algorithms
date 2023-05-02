package sortings;

public class MinElementOfArray {

    public static void main(String[] args) {
        int[] array = {14,9,12,61,55,3};

        int minValue = array[0];
        int valIndex = 0;

        for (int i = 0; i < array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
                valIndex = i;
            }
        }

        System.out.println("min value in array is: "+minValue);
        System.out.println("index of element: " + valIndex);

    }
}
