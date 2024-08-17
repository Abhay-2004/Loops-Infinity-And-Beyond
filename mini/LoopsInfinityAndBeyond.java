package mini;

/**
 * Utility class with static methods for loop practice.
 */
/**
 * 
 * @author Abhay Prasanna Rao
 *
 */
public class LoopsInfinityAndBeyond {

	/**
	 * Private constructor to disable instantiation.
	 */

	private LoopsInfinityAndBeyond() {
	}
	/**
	 * 
	 * @param s (The input String)
	 * @return Length of the FlyingSaucer
	 */
	public static int flyingSaucerLength(String s) {
	    int leftIndex = s.indexOf("("); // Find the index of the first opening bracket
	    if (leftIndex == -1) {
	        return 0; // If no opening bracket is found, return 0
	    }
	    int rightIndex = s.indexOf(")", leftIndex); // Find the index of the closing bracket, starting from the position of the opening bracket
	    if (rightIndex == -1) {
	        return 0; // If no closing bracket is found, return 0
	    }
	    int equalsCount = 0; // Initialize a counter for the number of equals signs
	    for (int i = leftIndex + 1; i < rightIndex; i++) {
	        if (s.charAt(i) == '=') {
	            equalsCount++; // Count the number of equals signs between the opening and closing brackets
	        } else {
	            return 0; // If a character other than '=' is encountered, the string does not represent a valid flying saucer, so return 0
	        }
	    }
	    return rightIndex - leftIndex + 1; // Return the length of the flying saucer, which is the distance between the opening and closing brackets plus one
	}
	/**
	 * 
	 * @param s (The input String)
	 * @return The number of flying saucers in the input string
	 */
	public static int countFlyingSaucers(String s) {
        boolean fakeufo = false;
	    int count = 0;
	    boolean[] counted = new boolean[s.length()];
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(' && !counted[i]) {
	            for (int j = i + 1; j < s.length() + i; j++) {
	                int k = j % s.length();
	                if (s.charAt(k) == '=' && !counted[k]) {
	                    for (int l = k + 1; l < s.length() + k; l++) {
	                        int m = l % s.length();
	                        if (s.charAt(m) == ')' && !counted[m]) {
	                            for (int n = i + 1; n < m; n++) {
	                                if (s.charAt(n) == '*') {
	                                    fakeufo = true;
	                                    break;
	                                }
	                            }
	                            if (!fakeufo) {
	                                count++;
	                                counted[i] = true;
	                                counted[k] = true;
	                                counted[m] = true;
	                            }
	                            break;
	                        }
	                    }
	                    break;
	                }
	            }
	        }
	    }
	    return count;
	}
	
	/**
	 * 
	 * @param s (The input String)
	 * @return Modified String
	 */

	public static String fixFlyingSaucer(String s) {
	 String newstr ="";
	 boolean YESUFO = false;
	
	 for(int i = 0;i<s.length();i++) {
		 if(s.charAt(i)== '*'&& (!YESUFO)) {
			 newstr += s.charAt(i);
		 }
		 else if(s.charAt(i) == '(') {
			 YESUFO = true;
			 newstr += s.charAt(i);
			 
		 }
		 else if (s.charAt(i)==')') {
			 YESUFO = false;
			 newstr += s.charAt(i);
		 }
		 else if(s.charAt(i)== '=') {
			 newstr += s.charAt(i);
		 } 



	 }
	 return newstr;
	 
	}

	/**
	 * 
	 * @param s (The input String)
	 * @return The modified string with the flying saucer moved from the right to left
	 */
	public static String flyingSaucersFly(String s) {
		String beforeUFO ="";
		String UFO= "";
		String afterUFO ="";
		String UFOafterFly = "";
		boolean TRUEUFO = false;
		int a = 0;
		if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == ')' || s.charAt(s.length() - 1) == '=')   {
			
			s = s.charAt(s.length()-1) + s.substring(0, s.length()-1);		
		}

		else {
			
			for(int i = 0; i <s.length();i++ ) {
				if(s.charAt(i) == '('){
					a = i;
					beforeUFO = s.substring(0,a);
					TRUEUFO = true;
					
				
					
				}
				else if(s.charAt(i) == '*'&& (TRUEUFO)) {
					TRUEUFO = false;
					
				}
				
				else if(s.charAt(i) == ')' && (TRUEUFO)) {
					afterUFO = s.substring(i+1);
					UFO = s.substring(a,i+1);
					UFOafterFly += beforeUFO + afterUFO.charAt(0) +UFO + afterUFO.substring(1);
					s = UFOafterFly;
					TRUEUFO = false;
				}

				

			}
			
		}
		return s;
	}


}
