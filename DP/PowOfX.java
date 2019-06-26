class Solution {
    private double pow(double x, long n, Map<Long, Double> map) {
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        double res=pow(x, n/2, map) * pow(x, n-n/2, map);
        map.put(n, res);
        return res;
    }
	
    public double myPow(double x, int n) {
        long power = (long)n;
        Map<Long, Double> map=new HashMap<>();
		double result=pow(x,Math.abs(power),map);
		if(n<0)
			result=1/result;
		return result;
    }
    

}