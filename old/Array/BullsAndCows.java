class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretCount = new int[10], guessCount = new int[10];
        for(int i=0; i<secret.length(); i++) {
            secretCount[secret.charAt(i)-'0']+=1;
            guessCount[guess.charAt(i)-'0']+=1;
            if(secret.charAt(i)==guess.charAt(i)) {
                bulls++;
                secretCount[secret.charAt(i)-'0']-=1;
                guessCount[guess.charAt(i)-'0']-=1;
            }
        }
        for(int j=0; j<10; j++) {
            if(secretCount[j]!=0 && guessCount[j] !=0) {
                if(secretCount[j] == guessCount[j]) {
                    cows+=guessCount[j];
                } else {
                    cows+=Math.min(secretCount[j], guessCount[j]);
                }
            }
           
        }
        
        return bulls+"A"+cows+"B";
        
        
        
    }
}