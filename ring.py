import random

class Node(object):
    def __init__(self, right):
        self.next_neighbour = right
        self.identifier = random.randrange(2**32)
        self.message = [self.identifier, 0]
        print("Initialising: " + str(self.message))

    def receive_message(self, message):
        if message[0] == self.identifier:
            print message
        else:
            message[-1] += 1
            self.send_message(message)

    def send_message(self, message):
        self.right_neighbour.receive_message(message)

# creating a circle
node_list = [Node(None) for node_index in range(10)]

for index, node in enumerate(node_list[:-1]):
    node.right_neighbour = node_list[index + 1]

node_list[-1].right_neighbour = node_list[0]

# pass message
for node_item in node_list:
    node_item.send_message(node_item.message)
