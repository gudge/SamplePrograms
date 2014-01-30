import sys
import random

def fibonacci():
#{
	#nos = random.sample(range(100), 1)
	#random.shuffle(nos)
	nos = random.randint(1, 50)
	#print(nos)
	if (nos == 50):
	#{  
		return
	#}  
	fib2 = [0, 1]	
	i = 0
	while True:
	#{
    	if i == nos:
        #{
        	break
		#}  
	#}  
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

