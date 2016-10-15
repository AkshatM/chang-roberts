var Node = {
    neighbour: null,
    receive_message: function(message) {
		if (message[0] !== this.identifier) {
			message[1] += 1;
            this.send_message(message);
		} else {
			console.log(message);
		}
	},
    send_message: function(message) {
		this.neighbour.receive_message(message);
	}
};

var a = Object.create(Node);

// create a list of nodes with unique identifier
node_list = Array(10).fill(0)
			.map(() => Object.create(Node, {identifier: {value: Math.random() * Math.pow(2,32)}}));

// assign message to each node - only way to do this in Javascript
node_list.forEach((n) => n.message = [n.identifier, 0]);

// link together nodes in a chain
node_list.slice(0, node_list.length - 1)
		 .forEach((n, i) => n.neighbour = node_list[i+1]);

// complete the link by joining last node to first
node_list[node_list.length - 1].neighbour = node_list[0];

// send a message
node_list.forEach((n) => n.send_message(n.message));
