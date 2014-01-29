import sys

def foo():
#{
	print ("Hello")
#}

def main(argv=None):
#{  
	if argv is None:
  		argv = sys.argv
	foo()	
#}   


if __name__ == "__main__":
#{  
	sys.exit(main())
#}	

