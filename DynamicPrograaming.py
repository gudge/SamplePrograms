import sys
import random
import cProfile
import timeit
import time
import functools
#from bitString import BitArray
import os, signal

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

def hashing_func(str_len, c):
  #{
	#value = functools.reduce(lambda x, y: pow(100, str_len - (x+1)) * ord(c) + y, [x for x in range(0, str_len - 1)]) 
	#value = functools.reduce(lambda x, y: x + y, [x for x in range(0, str_len - 1)]) 
	#print ('value = %d \n' % (value))
	y = 0
	for x in range(0, str_len - 1):
	  #{
		y =  pow(10, str_len - (x+1)) * ord(c) + y
	#}
	value = y
	return value
#}

def hashing():
  #{
	print ("Hashing\n")
	print ('Value = %d \n' % hashing_func(10 , 'c'))
#}

def foo():
  #{
	#print ("Hello")
	pass
#}

def exercise_3_1():	
  #{
	xlist = random.sample(range(100), 80)
	xlist = list(map(lambda x: x % 2, xlist))
	for i in range(0, len(xlist)):
	  #{
		if xlist[i] == 0:
		  xlist[i] = '('
		else:  
		  xlist[i] = ')'
	#}  
	brack_cnt = 0
	for i in range(0, len(xlist)):
	  #{
		if xlist[i] == '(':
		  brack_cnt += 1
		else:
		  #{
			if brack_cnt == 0:
			  #{
				print ('Error = %d \n' % i)
				print (xlist[0:i+1])
				break
			#}
			brack_cnt -= 1
		#}	
	#}

	return
#}

def setup_linked_list(xlist):	
  #{
	len2 = len(xlist)
	ylist = [ref(xlist[i]) for i in range(len2)]
	for i in range(len2-1): 
	  ylist[i].setN(ylist[i+1])
	ylist[len2 - 1].setN(None)  
	return ylist
#}

class ref:
  #{
		def __init__(self, obj): self.obj = obj
		def get(self):	return self.obj
		def set(self):  self.obj = obj
		def setN(self, obj):	self.n = obj
		def getN(self):	return self.n
		def print(self):	print ('%d' % self.obj)
#}

def exercise_3_2():	
  #{

	len2 = 90000
	xlist = random.sample(range(100000000), len2)

	#set up linked list
	ylist = setup_linked_list(xlist)

	#reversing
	curr = ylist[0]
	next2 = curr.getN()
	for i in range(len2 - 1):
	  #{
		tmp = next2.getN()
		next2.setN(curr)
		curr = next2
		next2 = tmp
	#}

	#comparison
	for i in range(len2):
	  #{
		if curr.get() != xlist[len2 - i - 1]:
		  #{  
			print ('Error')
			break
		#}  
		curr = curr.getN()
	#}
	print ('Comparison Finished Successfully\n')
#}

def print_list(ylist):
  #{
	curr = ylist[0]
	xlist = [curr.get() for curr in ylist] 
	print (xlist)
	for i in range(len(ylist)):
	  #{
		pass
		#break
	  	#curr.print()		
		#curr = curr.getN()
	#}
#}

def exercise_3_4():	
  #{
	n = 100
	xlist = random.sample(range(n), 10)
	#print (xlist)
	ylist = setup_linked_list(xlist)
	#print_list(ylist)
	#array with counters
	my_dict = [0] * (n + 1) 
	for i in range(len(xlist)):
	  #{  
		my_dict[xlist[i]] += 1
	#}	
	for i in range(n + 1):
	  #{
		if my_dict[i] == 1:
		  print (i)
	#}
	return	
#}

def exercise_3_5():
  #{
	return
#}

def exercise_3_6():	
  #{
	return
#}

def exercise_3_8():
  #{
	#avl tree implementation
	#This implementation is based on 
	#http://www.eternallyconfuzzled.com/tuts/datastructures/jsw_tut_avl.aspx

	class avl_node:
	  #{
		def __init__(self, data, balance, link):
		  #{
			self.data = data
			self.balance = balance
			self.link = link
		#}
	#}

	def create_binary_tree():
	#{
	    return None
	#}

	def min_value_root(root):
	#{
    	if root.link[l] is None:	
			return root.data
		val = min_value_root(root.left)  
		if val >= root.data
	#}

	def validate_binary_search_tree(root):
	#{
	   	#This routine can be used for both the avl trees and normal BST   	 
		#Perform inorder traversal and check balance.

		#This solution is wrong.
		#if root == None:
		#	return  

		#validate_binary_search_tree(root.link[0])
		#validate_binary_search_tree(root.link[1])

		#if (root.link[0] != None and root.data <= root.link[0].data
		#	or
		#	root.link[1] != None and root.data > root.link[1].data):
		#{
		#	raising_signals()
		#}

		if root.balance <= -1 or root.balance >= 1:
			return  
	#}

	def single_rotation(root, l):
	#{
		# single rotation is for the subtree too long in the same direction
		#
	  	#     3                              4
		#    / \                           /   \
		#	x   4          --->       	  3     5
		#      / \                       / \   / \
		#	  y   5	                  	x   y a   b
		#        / \
		#       a   b
		#
		#  Each of these subtrees can be of ht 0 or 1
		#  0 : left rotation  1: right rotation 
		#   3 -> root
		#   
		save = root.link[not l]
		#   save = 4
		#
		root.link[not l] = save.link[l]
		#
		#
		save.link[l] = root
		return save #4 is the new root
	#}
	def double_rotation (root, l):
	#{
	  	#		When the subree is too long in the opposite direction. 
		#                 
		#		3               	3                        4
		#	   / \                 / \                     /   \
		#	  x	  5      --->     x   4 		---> 	  3     5
		#	 	 / \                 / \                 / \   / \
		#	    4   b               y   5               x   y a   b
		#      / \                     / \
		#     y   a                   a   b

		# I don't know but I think the author should assume that 1 (i.e right)
		# I think what the author is assumning if the rotation is right and then
		# left, one should call the API as  double_rotation(root, l)

		# Or the theory is 3 would come to the left of 4 as per the final figure.
		# Therefore it is called left rotation.
		# 1 struct jsw_node *jsw_double ( struct jsw_node *root, int dir )
		# 2 {	
		# 3   struct jsw_node *save = root->link[!dir]->link[dir];
		#	  save = 4  

		# 4 
		# 5   root->link[!dir]->link[dir] = save->link[!dir];
		#	  5->left = 4->right  

		# 6   save->link[!dir] = root->link[!dir];
		#		4-> right = 3 -> right 
		#		4 -> right = 5
	
		# 7   root->link[!dir] = save;
		# 8   3 -> right = 4

		# First rotation over

		# 9   save = root->link[!dir];
        #		save = 4		

		#10   root->link[!dir] = save->link[dir];
        #		3 -> right = 4->left  

		#11   save->link[dir] = root;
		#12   4 -> right = 3

		#13   return save;  4 It is the root
		#14 }

		# Right rotation followed by left rotation
		# Right rotation


		#root.link[not l] = single_rotation(root.link[not l], not l)

		#fn call : single_rotation(5, 1)
		#root = 5
		#save = root.link[0]
		#save = 4
		#root.link[0] = save.link[1]
		#5->left = 4->right
		#save.link[l] = root
		#4->right = 5
        # 3->right = 4 #function return


		# left rotation
		# single_rotation(root, l)
		# fn call: single_rotation(3, 0)
		#                 
		#		            	3               4
		#	                   / \            /   \
		#	            	  x   4    --->  3     5
		#	 	             / \            / \   / \
		#	                y   5          x   y a   b
		#                      / \
		#                     a   b
		#save = root.link[1]
		#save = 4
		#root.link[1] = save.link[0]
		#3->right = 4->left 
		#save.link[0] = root
		#4->left = 3

		#return single_rotation(root, l)

		#final code
		root.link[not l] = single_rotation(root.link[not l], not l)
		return single_rotation(root, l)
	#}

	root = create_binary_tree()
	validate_binary_search_tree(root)
	return
#}

def testing_not():	
#{
	i = 3;
	j = not i;
	print ('j = %d' % j)
	return
#}

def raising_signals():
#{
	raise Exception("Things went wrong\n")
#}

def main(argv=None):
  #{  
	if argv is None:
	  argv = sys.argv
	#foo()	
	#fibonacci()
	#cProfile.run('fibonacci()')

	#binomial_coefficient()
	#hashing()
	#exercise_3_1() 
	#exercise_3_2()
	#exercise_3_4()
	#exercise_3_5()
	#exercise_3_6()
	exercise_3_8()
	#raising_signals()
	#testing_not()
#}   


if __name__ == "__main__":
  #{  
	sys.exit(main())
#}	

