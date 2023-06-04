package GroupAnagrams;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {

        String[] strs = {"madm","mdma","tea", "ate","hate", "waitress","bat", "tab", "streswai", "waitresss"};

        groupAnagrams(strs);

        List<List<String>> strings = groupAnagrams(strs);

        System.out.println(strings);
    }

    public static List<List<String>> groupAnagrams(String[] strs){

        if(strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String i : strs){
            char[] chars = i.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(i);
        }

        return new ArrayList<>(map.values());
    }
}
