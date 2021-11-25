
public class Matcher {

    public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		//I moved first part about clip too large values 
    	
        //checking length diffrences
        if (actual.length != expected.length) {
            return false;
        }
        // I put it to one loop
        for (int i = 0; i < actual.length; i++) {
        	// Clip "too-large" values
            if (actual[i] > clipLimit) {
                actual[i] = clipLimit;
                //checking each entery
            } else if (Math.abs(expected[i] - actual[i]) > delta) {
                return false;
            }
        }
        return true;
    }
}