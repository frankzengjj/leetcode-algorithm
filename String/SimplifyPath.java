class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        String[] fileNames = path.split("/");
        for(String dir: fileNames) {
            if(dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(dir.equals(".") || dir.equals("") || dir.equals("..")){
                continue;
            } else {
                stack.push(dir);
            }
        }
        
        if(stack.isEmpty()) return "/";
        for(String dir: stack) {
            sb.insert(0, "/"+dir);
        }
        return sb.toString();
        
    }
}