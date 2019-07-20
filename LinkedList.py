class Node:
	def __init__(self, x):
		self.val = x
		self.next = None

class LinkedList:

	def __init__(self, head):
		self.head = None

	def isPalindrome(self, head):
		rev = None
		slow = fast = head
		while fast and fast.next:
			fast = fast.next.next
			rev = slow
			rev.next = rev
			slow = slow.next

		if fast:
			slow = slow.next

		while rev and rev.val == slow.val:
			slow = slow.next
			rev = rev.next

		return not rev

	def insert_at_end(self, val):
		new_node = Node(val)
		if self.head is None:
			self.head = new_node
			return 
		else:
			temp = self.head
			while(temp.next):
				temp = temp.next
		temp.next = new_node

	def insert_at_start(self, val):
		new_node = Node(val)
		new_node.next = self.head
		self.head = new_node

	def insert_after(self, prev_node, val):
		if prev_node is None:
			print("The given node must exist in the linked list") 
			return
		new_node = Node(val)
		new_node.next = prev_node.next
		prev_node.next = new_node

	def delete(self, val):
		temp = self.head
		if prev_node == head:
			self.head = temp.next
			temp = None 
			return 

		while(temp is not None):
			if temp.val == val:
				break
			prev = temp 
			temp = temp.next

		if temp == None:
			return 

		prev.next = temp.next
		temp = None 

	def traverse(self, val):
		temp = self.head
		while(temp):
			temp = temp.next
			print(temp.val)

	