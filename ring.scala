import scala.util.Random
import scala.math

class Node() {

    // unique identifier
    val identifier = scala.util.Random.nextInt(scala.math.pow(2,32).toInt);

    // unique message - note that List is immutable
    var message: List[Int] = List(this.identifier, 0);

    var neighbour: Node = null;

    // return type is Unit since we return nothing
    def receive_message(message: List[Int]): Unit = message match {

        // the following could be done with either if-else statements,
        // or the case statement. Pattern matching is more idiomatic, hence
        // why this was chosen.

        // if the first element of the message matches our identifier
        case this.identifier :: _ => { println(message); }

        // otherwise
        case _ => {
            // function parameter is of type List, and is thus immutable, so we need to create a new copy 
            val new_message: List[Int] = List[Int](message.head, message.last + 1);
	    this.send_message(new_message);
        }
    }

    def send_message(message: List[Int]) = {
        this.neighbour.receive_message(message);
    }
}

object Ring {

    def main(args: Array[String]): Unit = {
        // note that this yields a Vector!
    	var node_list = for (item <- 1 to 10) yield new Node();

        // link first n-1 elements together
    	node_list.dropRight(1).zipWithIndex.foreach((element) => {element._1.neighbour = node_list(element._2 + 1)})

        // link the last element to the first element
        node_list.last.neighbour = node_list.head;

        node_list.foreach((n) => {n.send_message(n.message)})
    }
}
