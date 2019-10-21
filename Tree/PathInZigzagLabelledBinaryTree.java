class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);
        int d = (int)(Math.log(parent)/Math.log(2));

        while(parent != 1) {
            int offset = (int)Math.pow(2, d+1) - 1 - parent;
            parent = ((int)Math.pow(2, d) + offset) / 2;
            result.addFirst(parent);
            d--;
        }
        return result;
    }
}