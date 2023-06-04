package GroupAnagrams;

import java.util.*;

public class AnagramsV2 {
    public static void main(String[] args) {

        String[] strs = {"madm","mdma","tea", "ate","hate", "waitress","bat", "tab", "streswai", "waitresss"};

        List<List<String>> anagramGroups = groupAnagrams(strs);

        System.out.println(anagramGroups);
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
