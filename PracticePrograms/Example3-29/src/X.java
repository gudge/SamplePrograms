import java.util.Random;


class X {
	int[] n;
	int[] m;
	int[] store;
	int[] store2;
	int []m2;
	final static int nos = 10;
	X() throws Exception {
		Random random = new Random();
		do {
			n = new int[random.nextInt(nos)];
		} while (n.length == 0);	

		if (n.length == 0)
			return;
//	    System.out.println(n.length);

	    for( int i = 0 ; i < n.length ; i++ ) {
	    	  do {
	    		  n[i] = random.nextInt(nos);
	    	  } while (n[i] == 0 || n[i] == 1);
	    }
   
//	    for (int i = 0;i < n.length; i++) {
//	    	System.out.println(n[i]);
//	    }
	    store = new int[n.length];
	    store[0] = n[0];
	    for (int i = 1; i < n.length; i++) {
	    	store[i] = store[i - 1] * n[i]; 
	    }
	    store2 = new int[n.length];
	    store2[n.length - 1] = n[n.length - 1];
	    for (int i = n.length - 2; i >= 0; i--) {
	    	store2[i] = store2[i + 1] * n[i]; 
	    }
	    m = new int[n.length];
	    m[0] = n.length > 1 ? store2[1] : 0;
	    m[n.length - 1] = n.length > 1 ? store[n.length - 2] : 0;
	    for (int i = 1; i < n.length - 1; i++) {
	    	m[i] = store[i-1] * store2 [i+1];
	    }
	    store2 = null;
	    store = null;

//	    for (int i = 0; i < n.length; i++) {
//	    	System.out.println(m[i]);
//	    }

	    m2 = new int[n.length];
	    for (int i = 0; i < n.length; i++) {
	    	m2[i] = 1;
	    	for (int j = 0; j < n.length; j++) {
	    		if (i == j)
	    			continue;
	    		m2[i] = m2[i] * n[j];
	    	}
	    }
	    for (int i = 0; i < n.length; i++) {
	    	if (m2[i] != m[i]) {
	    		System.out.println("Wrong\n");
	    		break;
	    	}
	    }
	}
	public static void main(String[] args) throws Exception {
		new X();
	}
}