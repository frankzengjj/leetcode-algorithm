class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            return p2[0] - p1[0] == 0 ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        List<int[]> resList = new LinkedList<>();
        for (int[] person: people) {
            resList.add(person[1], person);
        }
        return resList.toArray(new int[][]{});
    }
}