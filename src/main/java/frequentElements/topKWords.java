package frequentElements;

import java.util.*;

public class topKWords {
    public static void main(String[] args) {
        String[] wordsArray = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        //List<String> result = topKKWordss(wordsArray, k);
        String[] result = topKWordss(wordsArray, k);

        //System.out.println(Arrays.toString(result.toArray()));
        System.out.println(Arrays.toString(result));
    }

    private static String[] topKWordss(String[] wordsArray, int k) {
        Map<String, Integer> map = new HashMap<>();

        for( String word: wordsArray){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) -> {

            if(a.getValue() != b.getValue()){
                return a.getValue().compareTo(b.getValue());
            }
            return -a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k)
                pq.poll();
        }

        List<String> ans = new ArrayList<>();
        while(pq.size() > 0)
            ans.add(pq.poll().getKey());

        // check the order
        Collections.reverse(ans);

        return ans.toArray(new String[0]);

    }

    private static List<String> topKKWordss(String[] wordsArray, int k) {
        Map<String, Integer> map = new HashMap<>();

        for( String word: wordsArray){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) -> {

            if(a.getValue() != b.getValue()){
                return a.getValue().compareTo(b.getValue());
            }
            return -a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k)
                pq.poll();
        }

        List<String> res = new ArrayList<>();
        while(pq.size() > 0)
            res.add(pq.poll().getKey());

        // check the order
        Collections.reverse(res);
        return res;

    }
}
