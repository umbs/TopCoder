import java.util.Arrays;


public class ZigZag {
	static int zz[] = new int[51]; // length of seq at idx i
	static int from[] = new int[51]; // idx of prev num in seq 
	static int longest; 
	
	ZigZag() {
		Arrays.fill(zz, 1); 
	}
	
	static boolean signCheck(int lastLastIdx, int lastIdx, int curIdx, int[] chain) {
		int a = chain[lastLastIdx], b = chain[lastIdx], c = chain[curIdx]; 
		
		if(a < b)
			return (c < b); 
		else 
			return (b < c); 					
	}
	
	static int longestZigZag(int[] chain) {
		for(int i=0; i<chain.length; i++) {
			for(int j=0; j<i; j++) {
				if(zz[j] >= zz[i] && (signCheck(from[j], j, i, chain))) {
					zz[i] = zz[j]+1; 
					from[i] = j; 
					
					if(zz[i] > longest)
						longest = zz[i]; 
				}
			}
		}
	
		return longest; 
	}
	
	public static void main(String [] args) {
		//int chain[] = { 1, 7, 4, 9, 2, 5 }; 
		 //int chain[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }; 
		/*int chain[] = {44}; 
		int chain[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
		int chain[] = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }; 
		*/
		
		int chain[] = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }; 
		 
		System.out.println(longestZigZag(chain)); 
	}
}
