package freqSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class frequencySort {
    public static void main(String[] args) {
        String str = "Aabb";

        String result = freqSort(str);

        System.out.println(result);
    }

    public static String freqSort(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : chars){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for(char key : charMap.keySet()){
            int freq = charMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.length - 1; i >= 0; i-- ){
            if(bucket[i]!= null){
                for(char c : bucket[i]){
                    for(int n = 0; n < i; n++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();

    }
}
