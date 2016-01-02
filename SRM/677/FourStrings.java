/* SRM 677 Div 2, Lev 2.
 * This code passes 5 example tests but fails system tests. On Topcoder site, 
 * it's unclear what caused failure. I'll continue to work on this and fix 
 * the issue. */
public class FourStrings {
	
	public static String superString(String a, String b) {
		int i=0, aLen = a.length(); 
		int j=0, bLen = b.length(); 
		
		if (aLen == 0) return b; 
		if (bLen == 0) return a;
		
		while(i<aLen) {
			while(j<bLen) {
				if (a.charAt(i) == b.charAt(j)) {
					i++; j++;
				
					/* end of string a */
					if (i==aLen) return a.concat(b.substring(j));
					
					/* end of string b */
					if (j==bLen) return a;
				} else {
					/* mismatch, right shift b by 1 (brute force search) */
					i = i-j+1; 
					j = 0;
					
					/* end of string a */
					if (i==aLen) return a.concat(b);
				}
			}
		}
		
		return a.concat(b); /* will never reach here */
	}
	
	public static String minString(String a, String b) {
		if (a.length() <= b.length()) return a; 
		return b;
	}
	
	public static int shortestLength(String a, String b, String c, String d) {
		String s1, s2; 
		
		s1 = minString(superString(a, b), superString(b, a)); 
		s2 = minString(superString(c, d), superString(d, c)); 
		
		return minString(superString(s1, s2), superString(s2, s1)).length();
	}
	
	public static void main(String[] a) {
		System.out.println("" + shortestLength("abc", "ab", "bc", "b"));
		System.out.println("" + shortestLength("a", "bc", "def", "ghij"));
		System.out.println("" + shortestLength("top", "coder", "opco", "pcode"));
		System.out.println("" + shortestLength("thereare", "arelots", "lotsof", "ofcases")); 
		System.out.println("" + shortestLength("aba", "b", "b", "b")); 
		System.out.println("" + shortestLength("b", "b", "b", "b"));
	}
}
