package medianOfTwoSortedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] nums1 = {3,9,12,14,55,61};
        int[] nums2 = {};
        double result = FindMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;

        int[] concatedArr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, concatedArr, 0, nums1.length);
        System.arraycopy(nums2, 0, concatedArr, nums1.length, nums2.length);
        Arrays.sort(concatedArr);
        System.out.println(Arrays.toString(concatedArr));
        if( (nums1.length + nums2.length) % 2 == 0){
            int z = (nums1.length + nums2.length)/2;
            int e = concatedArr[z];
            int q = concatedArr[z-1];

            result = (e+q)/2.d;
            return result;
        }else {
            int z = (nums1.length + nums2.length)/2;
            return concatedArr[z];
        }

    }
}
