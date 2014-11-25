import java.io.File;
import java.io.RandomAccessFile;

class X {
	public static void main(String[] args) {
		try {
		    
		} finally {
		    
		}
		
		try {

		} catch (Exception e) {
		    
		} catch (ArithmeticException a) {
		    
		}
	}
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } finally {
	        if (input != null) {
	            input.close();
	        }
	    }
	}
}


