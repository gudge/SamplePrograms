import sys
import random
import cProfile
import timeit
import time

def binomial_coefficient():
  #{
	#   n          n - 1        n - 1
	#         =             + 
	#   k          k  - 1       k
	nos = random.randint(1, 10000)
	nos = 3000
	# A two dimensional array allocation
	#bc = [[ None ] * nos ] * nos
	bc = [[ None ] * (nos + 1) ] * 2
	bc[0][0] = 1
	i = 1
	start = time.time()
	while True:
	  #{
		bc[0][i] = 1
		j = 1
		while True:
		  #{
			bc[1][j] ==  bc[0][j-1] + bc[0][j]
			j = j + 1
			if j == i + 1:
			  #{
				break
			#}  
		#}  
		i += 1
		if i == nos + 1:
		  #{
			break
		#}
	#}  
	print (bc[1][nos])
	print ('%d time = %f\n' % (nos, (time.time() - start)))
#}

def fibonacci():
  #{
	#nos = random.sample(range(100), 1)
	#random.shuffle(nos)
	nos = random.randint(1, 10000)
	#print(nos)
	fib2 = [0, 1]	
	nos = 50000
	#fibnos = [None] * nos
	#start = default_timer() 
	start = time.time()
	i = 0
	while True:
	  #{
		fib = fib2[0] + fib2[1]
		#print ('% iteration : %d\n' % (i, fib))
		#fibnos[i] = fib
		fib2[1] = fib
		fib2[0] = fib2[1]
		i = i + 1
		if i == nos:
		  #{
			break
		#}  
	#}  
	#stop = timeit.default_timer() 
	#print (fibnos)
	#print (stop - start)
	print ('%d time = %f\n' % (nos, (time.time() - start)))
#}

def foo():
  #{
	#print ("Hello")
	pass
#}

def main(argv=None):
  #{  
	if argv is None:
	  argv = sys.argv
	foo()	
	#fibonacci()
	#cProfile.run('fibonacci()')

	binomial_coefficient()
#}   


if __name__ == "__main__":
  #{  
	sys.exit(main())
#}	

