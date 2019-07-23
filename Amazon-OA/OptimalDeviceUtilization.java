import java.util.*;
class Solution {
    public List<List<Integer>> optUtil(int deviceCap, List<List<Integer>> fore, List<List<Integer>> back) {
        List<List<Integer>> res = new ArrayList<>();
        fore.sort((List<Integer> l1, List<Integer> l2) -> (l1.get(1)-l2.get(1)));
        // System.out.println(fore.toString());
        back.sort((List<Integer> l1, List<Integer> l2) -> (l1.get(1)-l2.get(1)));
        int m = fore.size(), n = back.size();
        int l = 0, r = n-1, diff = Integer.MAX_VALUE;
        int resL = 0, resR = 0;
        while (l<m && r>=0) {
            int tempDiff = deviceCap - (fore.get(l).get(1) + back.get(r).get(1)); 
            if ( tempDiff < diff && tempDiff > 0) {
                diff = tempDiff;
                resL = fore.get(l).get(0); 
                resR = fore.get(r).get(0);
            } else if (tempDiff == 0) {
                res.add(Arrays.asList(fore.get(l).get(0), back.get(r).get(0)));
            }

            if ( fore.get(l).get(1) + back.get(r).get(1) > deviceCap) {
                r--;
            } else {
                l++;
            }
        }
        if (res.isEmpty())
            res.add(Arrays.asList(resL, resR));
        return res;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,5);
        List<Integer> l2 = Arrays.asList(2,2);
        List<Integer> l3 = Arrays.asList(3,5);
        List<List<Integer>> fore = new ArrayList<>(){{add(l1); add(l2); add(l3);}};
        System.out.println(new Solution().optUtil(7, fore, fore).toString());
    }
}