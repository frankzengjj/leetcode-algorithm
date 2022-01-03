class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1: n; arr2: m
        if (arr1.length == 0) return new int[0];
        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num: arr2) set.add(num);
        List<Integer> remain = new ArrayList<>();
        
        // O(n)
        for (int num: arr1) {
            if (set.contains(num)) {
                map.put(num, map.getOrDefault(num, 0)+1);
            } else {
               remain.add(num);
            }
        }
        
        // O(nlogn)
        Collections.sort(remain);
        
        // O(nm)
        int j = 0;
        for (int i=0; i<arr2.length; i++) {
            int k = 0;
            while (k < map.get(arr2[i])) {
                res[j++] = arr2[i];
                k++;
            }
            map.remove(arr2[i]);
        }

        for (int i=0; i<remain.size(); i++) {
            res[j++] = remain.get(i);
        }
        return res;
    }
}