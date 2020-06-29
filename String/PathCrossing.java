class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add(x+","+y);
        for (char c: path.toCharArray()) {
            switch(c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
            if (!set.add(x+","+y)) return true;
        }
        return false;
    }
}