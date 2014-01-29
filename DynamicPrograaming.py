import sys
import random

def fibonacci():
  #{
	#nos = random.sample(range(100), 1)
	#random.shuffle(nos)
	nos = random.randint(1, 50)
	print(nos)
	fib2 = list(0:2)	
	fib2[0] = 1
	fib2[1] = 1
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
	fibonacci()
#}   


if __name__ == "__main__":
  #{  
	sys.exit(main())
#}	

