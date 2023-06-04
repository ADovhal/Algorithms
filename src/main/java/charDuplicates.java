import java.util.*;

public class charDuplicates {
    public static void main(String[] args) {


        Integer[] numArray = {1,1,1,3,3,4,3,2,4,2};
        boolean res = containsDuplicates(numArray);

        System.out.println(res);

    }

//    private static boolean containsDuplicates(int[] numArray) {
//        Set<Integer> numSet = new HashSet<>();
//        for(int n : numArray){
//            if(numSet.contains(n)){
//                return true;
//            }
//            numSet.add(n);
//        }
//        return false;
//    }
    private static boolean containsDuplicates(Integer[] numArray) {

        List<Integer> list =  Arrays.asList(numArray);
        Set<Integer> numSet = new HashSet<>(list);

        return list.size() != numSet.size();
    }
}
