#include <iostream>
#include <cmath>
#include <string>
#include <ctime>
#include <vector>

class Node {
    public:
        int identifier;
        std::pair<int,int> message;

        // maintain a pointer to our neighbour, to avoid infinite recursion issues
        Node* neighbour;

        // our constructor
	Node() {

            // setup our identifier
	    this->identifier = rand(); // can only go upto 2^15, but that is fine
		
	    // setup our message
            this->message = std::make_pair(this->identifier, 0);
	};

        void receive_message(std::pair<int,int> message) {

	   if (message.first == this->identifier) {
               // boilerplate needed to print out our vector appropriately
               std::cout << "[" << message.first << "," << message.second << "]" << std::endl;
	   } else {
               message.second += 1;
               this->send_message(message);
	   }
	};

        void send_message(std::pair<int, int> message) {
	    this->neighbour->receive_message(message);
	};
};

int main() {

    srand(time(NULL));

    std::vector<Node> nodes;

    for ( auto i : {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ) { 
	nodes.push_back(Node());
    }

    for (int i = 0; i < 9; i++) {
	nodes[i].neighbour = &nodes[i+1];
    }

    nodes[nodes.size() - 1].neighbour = &nodes[0];

    for (auto node : nodes) {
        node.send_message(node.message);
    }

    return 0;
}
