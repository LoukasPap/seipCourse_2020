package math;

public class MyMath {
	
	public int factorial(int n) {
		if(n<0 || n>12) {
			throw new IllegalArgumentException("n should be between 0 and 12");
		}else {
			if(n!=0) {
				int f = n;
				for(int i=1; i<(f); i++) {
					n *= (f-i);
				}
			}else{
				n = 1;
			}
		}
		return n;
	}
}
