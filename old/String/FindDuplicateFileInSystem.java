class Solution {
    /**
        abcd: root/a/1.txt, root/c/3.txt
        efgh: root/a/2.txt, root/c/d/4.txt, root/4.txt
        
    */
    
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>(); // content: paths
        for (String path: paths) {
            String[] arr = path.split("\\s+");
            for (int i=1; i<arr.length; i++) {
                String content = arr[i].substring(arr[i].indexOf("(")+1,arr[i].indexOf(")"));
                String filename = arr[i].substring(0, arr[i].indexOf("("));
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(arr[0]+"/"+filename);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> pathList: map.values()) {
            if (pathList.size() > 1) res.add(pathList);
        }
        return res;
    }
}