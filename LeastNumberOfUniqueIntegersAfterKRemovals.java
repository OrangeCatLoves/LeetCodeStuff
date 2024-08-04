/*class Solution {
    // Passed 40/43
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int minKey = 0; // To be reassigned
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (Integer key : map.keySet()) {
                if (minVal > map.get(key)) {
                    minVal = map.get(key);
                    minKey = key;
                }
            }
            map.put(minKey, map.get(minKey) - 1);
            if (map.get(minKey) == 0) {
                map.remove(minKey);
            }
            minVal = Integer.MAX_VALUE;
        }
        return map.keySet().size();
    }
}*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap< Integer ,Integer> map = new HashMap<>();

        // Entry in HAsh MAP
        for (int i : arr) map.put( i , map.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Entry in Priority Queue
        for (Map.Entry<Integer,Integer> i : map.entrySet()) pq.add(i.getValue());

        while (k > 0) {

            int temp = pq.peek();
            k -= temp;
            if ( k >= 0 ) pq.poll();

        }
        return pq.size();
    }
}