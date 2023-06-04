package frequentElements;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class FrequentElements {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 3, 4, 4, 4};
        int quantity = 2;
        System.out.println(Arrays.toString(topKFr(numbers, quantity)));
    }

    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> numMap = new HashMap<>();
        for(Integer num : nums){
            if(!numMap.containsKey(num)){
                numMap.put(num, 0);
            }
            numMap.put(num, numMap.get(num) + 1 );
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numMap.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(entries.get(i).getKey());
        }


        return result;

    }

    public int[] topKFFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();



        for(Integer num : nums){
            if(!numMap.containsKey(num)){
                numMap.put(num, 0);
            }
            numMap.put(num, numMap.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numMap.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(entries.get(i).getKey());
        }

        int[] n = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            n[i] = result.get(i).intValue();
        }

        return n;
    }


    public int[] topKkkFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for( int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        int[] n = new int[k];
        for(int i = 0; i < k; i++){
            n[i] = pq.poll().getKey();
        }
        return n;

    }

    public static int[] topKFreq(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[Arrays.stream(nums).max().getAsInt()];
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1 ; i >= 0 && result.size() < k; i--){
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.subList(0,k)
                .stream()
                .mapToInt(i->i)
                .toArray();
    }

    public static List<Integer> topKKFreq(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length];
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1 ; i >= 0 && result.size() < k; i--){
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.subList(0,k);
    }

    public static int[] topKFr(int[] nums, int k) {
        Map<Integer, Integer> hm = new LinkedHashMap<>();

        for (int num : nums) {
            Integer val = hm.getOrDefault(num, 0);
            hm.put(num, (val + 1));
        }

        System.out.println("key: " + hm.keySet() + ", values: " + hm.values());

        List<Integer> sortedNums = hm.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println(sortedNums);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = sortedNums.get(i);
        }
        return result;
    }
}



