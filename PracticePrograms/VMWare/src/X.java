
class Y {
	void foo(String[] items) {
		
		for (int i = 0, len = items.length; i < len; i++) {
			boolean isNo = true;
			Integer j = null;
			try {
				j = Integer.parseInt(items[i]);
			} catch (NumberFormatException e) {
				isNo = false;
			}
			if (isNo) {
				System.out.println(j);
			} else {
				System.out.println("?");
			}

		}
	}

	void foo2(int[] items) {
		if (items == null || items.length == 0) {
			System.out.println('?');
			return;
		}
		if (items.length == 1) {
			System.out.println(items[0]);
			System.out.println('?');
			return;
		}
		int[] a = new int[2];
		boolean notset = true;
		if (items[0] > items[1]) {
			a[0] = items[0];
			a[1] = items[1];
			notset = false;
		} else if (items[1] > items[0]){
			a[0] = items[1];
			a[1] = items[0];
			notset = false;
		} else {
			a[0] = items[0];
			
		}

		for (int i = 2, l = items.length; i < l; i++) {
			int j = items[i];
			if (notset) {
				if (j < a[0]) {
				   a[1] = j;
				   notset = false;
				} else if (j > a[0]){
					a[0] = j;
				}
			} else {
				if (j > a[0]) {
					a[1] = a[0];
					a[0] = j;
				} else if (j != a[0] && j > a[1]){
					a[1] = j;
				}
			}
		}
		System.out.println(a[0]);
		if (!notset)
			System.out.println(a[1]);
		else
			System.out.println("?");
	}

	public int foo3(int[] items) {
	     if (items.length == 1) {
	    	 return items[0];
	     }
	     int cnt = 1;
	     int a = items[0];
	     for (int i = 1, l = items.length; i < l; i++) {
	    	 int j = items[i];
	    	 if (j == a) {
	    		 cnt++;
	    	 } else {
	    		 if (cnt == 1) {
	    			 a = j;
	    			
	    		 } else {
	    			 cnt--;
	    		 }
	    	 }
	     }
	     int cnt2 = 1;
	     a = items[0];
	     if (cnt != 1) {
	    	 for (int i = 1, l = items.length; i < l; i++) {
	    		 int j = items[i];
	    		 if (j == a) {
	    			 cnt2++;
	    			 if (cnt == cnt2)
	    				 break;
	    		 } else {
	    			 if (cnt2 == 1)
	    				 a = j;
	    			 else 
	    				 cnt2--;
	    		 }
	    	 }
	     }
	     return a;
	}

	public int func(int[] scores) {
		if (scores == null || scores.length == 0)
			return 0;
		if (scores.length == 1)
			return 1;
		
		int cnt = 1;
		int max = 1;
		for (int i = 0, l = scores.length; i < l-1; i++) {
			if (scores[i+1] > scores[i]) {
				cnt++;
				if (cnt > max) {
					max = cnt;
				}
			} else {
				cnt = 1;
			}
		}
		return max;
	}
}

class X {

	public static void main(String[] args) {
		Y y = new Y();
		String[] items = new String[] {"1", "2.3", "4"};
		//y.foo(items);
		int[] i = new int[] {3, 1, 2, 3};
		i = new int[] {1, 3, 1, 3, 1, 3, 3, 1};
		//y.foo2(i);
		System.out.println(y.foo3(i));
		//System.out.println(y.func(new int[] {1, 2, 3, 4}));
		//System.out.println(y.func(new int[] {1, 7, 2, 3, 5, 4, 6}));
	}
}
