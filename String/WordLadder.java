class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str,wordSet)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }
    
    public List<String> neighbors(String s, Set<String> wordList){
        List<String> res = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char [] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String word = new String(chars);
                if(wordList.remove(word)){
                    res.add(word);
                }
            }
        }
        System.out.println(res.toString());
        return res;
    }
}