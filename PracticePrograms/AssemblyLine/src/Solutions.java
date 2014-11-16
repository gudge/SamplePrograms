

class Solutions {
	public static void main(String[] args) {
		// a[i][j]
		// s[i][j]
		
		
		// T array which denotes time taken to leave chasis.
		// We have t calculate two arrays.
		
		// If we enter 1 station
		
		// T1[i] :  mimimum time taken to exit station i in AL1
		// T2[i] :  miminum time taken to exit station i at AL2.
		
		// T1[1] = e[1] + a[1][1]
		// T2[1] = e[2] + a[2][1]
		
		// T1[i] = Min(T2[i-1] + TR[2][i-1], T1[i-1]) + a[1][i] 
		// T2[i] = Min(T1[i-1] + TR[1][i-1], T2[i-1]) + a[2][i]
		
		// min(T1[i] + 
	}
}