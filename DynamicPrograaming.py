import sys
import random
import cProfile
import timeit
import time

def fibonacci():
  #{
	#nos = random.sample(range(100), 1)
	#random.shuffle(nos)
	nos = random.randint(1, 50)
	#print(nos)
	fib2 = [0, 1]	
	fibnos = [None] * nos
	#start = default_timer() 
	start = time.clock()
	i = 0
	while True:
	  #{
		fib = fib2[0] + fib2[1]
		#print ('% iteration : %d\n' % (i, fib))
		fibnos[i] = fib
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
	print (time.time() - start)
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
	#cProfile.run('fibonacci()')
	fibonacci()
#}   


if __name__ == "__main__":
  #{  
	sys.exit(main())
#}	

