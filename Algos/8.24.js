class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
    }
    /**
     * Determines if this list is empty.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {boolean}
     */
    isEmpty() {
        return this.head === null;
    }

    /**
     * Determines the length of this list.
     * - Time: O(n) linear, n = length of list
     * - Space: O(1) constant
     * @returns {number} The length.
     */
    length() {
        let len = 0;
        let runner = this.head;

        while (runner) {
            len += 1;
            runner = runner.next;
        }
        return len;
    }

    /**
     * Prints all the nodes in the list to the console.
     * of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {SinglyLinkedList} This list.
     */
    printValues() {
        if (this.head == null) {
            console.log("LIST EMPTY");
            return;
        }
        // IF THE LIST IS NOT EMPTY
        var runner = this.head;
        while (runner != null) {
            console.log(runner.value);
            runner = runner.next;
        }
    }
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * - Time: (?).
     * - Space: (?).
     * @param {any} data The data to be added to the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBack(data) {
        if (this.isEmpty()) {
            this.head = new Node(data);
            return this;
        }

        let runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }

        runner.next = new Node(data);

        return this;
    }

    /**
     * Adds each item of the given array to the back of this list.
     * - Time: (?).
     * - Space: (?).
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    seedFromArr(vals) {
        for (const item of vals) {
            this.insertAtBack(item);
        }

        return this;
    }

    /**
     * Creates a new node with the given data and inserts that node at the front
     * of this list.
     * - Time: (?).
     * - Space: (?).
     * @param {any} data The data for the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtFront(data) {
        let newHead = new Node(data);
        newHead.next = this.head;
        this.head = newHead;

        return this;
    }

    /**
     * Removes the first node of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {any} The data from the removed node.
     */
    removeAtFront() {
        if (this.isEmpty()) return null;

        let oldHead = this.head;
        this.nead = oldHead.next;
        oldHead.next = null;

        return oldHead.data;
    }

    /**
     * Calculates the average of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {number|NaN} The average of the node's data.
     */
    average() {
        if (this.isEmpty()) return null;

        let sum = 0;
        let runner = this.head;
        while (runner != null) {
            sum += runner.data;
            runner = runner.next;
        }

        return sum / this.length();
    }

    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: (?).
     * - Space: (?).
     * @param {any} val The data to search for in the nodes of this list.
     * @returns {boolean}
     */
    contains(val) {
        if (this.isEmpty()) return null;

        let runner = this.head;
        while (runner != null) {
            if (runner.data === val) {
                return true;
            }
            runner = runner.next;
        }

        return false;
    }

    /**
     * Removes the last node of this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {any} The data from the node that was removed.
     */
    removeBack() {
        if (this.isEmpty()) return null;

        if (this.head.next === null) {
            this.head = this.removeAtFront();
        }

        let runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        let node = runner.next;
        runner.next = null;

        return node.data;
    }

    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: (?).
     * - Space: (?).
     * @param {any} val The data to search for in the nodes of this list.
     * @param {?node} current The current node during the traversal of this list
     *    or null when the end of the list has been reached.
     * @returns {boolean}
     */
    containsRecursive(val, current = this.head) {
        if (current === null) return false;

        if (current.data === val) return true;

        return this.containsRecursive(val, current.next);
    }

    /**
     * Retrieves the data of the second to last node in this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {any} The data of the second to last node or null if there is no
     *    second to last node.
     */
    secondToLast() {
        if (this.isEmpty()) return null;

        let runner = this.head;

        while (runner.next.next != null) {
            runner = runner.next;
        }

        return runner.data;
    }

    /**
     * Removes the node that has the matching given val as it's data.
     * - Time: (?).
     * - Space: (?).
     * @param {any} val The value to compare to the node's data to find the
     *    node to be removed.
     * @returns {boolean} Indicates if a node was removed or not.
     */
    removeVal(val) {
        if (this.isEmpty()) return null;

        let runner = this.head;

        while (runner.next != null) {
            if (runner.next.data === val) {
                let removedNode = runner.next;
                let currentNode = runner;
                let nextNode = runner.next.next;

                removedNode.next = null;
                currentNode.next = nextNode;

                return true;
            }
            runner = runner.next;
        }

        return false;
    }

    /**
     * Retrieves the data of the kth to last node in this list.
     * - Time: (?).
     * - Space: (?).
     * @returns {any} The data of the kth to last node or null if there is no
     *    kth to last node.
     */
    kthToLast(k) {
        if (this.isEmpty()) return null;

        runner = this.head;
        for (let i = 0; i < k; i++) {
            if (runner === null) return null;

            runner = runner.next;
        }

        return runner.data;
    }

    // WEEK 4
    // ========== MONDAY ==========

    /**
     * Reverses this list in-place without using any extra lists.
     * - Time: (?).
     * - Space: (?).
     * @returns {SinglyLinkedList} This list.
     */

    reverse() {
        //if empty
        if (this.head == null) {
            return false;
        }
        //if only one node
        if (!this.head.next) {
            return this.head;
        }
        var prev = null; // Setting a previous runner to hold the hold a value
        var current = this.head;
        var next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        return this;
    }

    // ========== TUESDAY =========

    /**
     * Determines whether the list has a loop in it which would result in
     * infinitely traversing unless otherwise avoided. A loop is when a node's
     * next points to any node that is behind it.
     * - Time: (?).
     * - Space: (?).
     * @returns {boolean} Whether the list has a loop or not.
     */
    hasLoop() {
        //if empty
        if (this.head == null) {
            return false;
        }
        //if only one node
        if (!this.head.next) {
            return false;
        }
        //lagger
        var lagger = this.head;
        //leader
        while (lagger != null) {
            var leader = this.head;
            while (leader != null) {
                if (leader == lagger) {
                    return true;
                }
                if (leader.next == null) {
                    return false;
                }
                leader = leader.next;
            }
            if (leader.next == null) {
                return false;
            }
            leader = leader.next;
        }
        return false;
    }

    /**
     * Removes all the nodes that have a negative integer as their data.
     * - Time: (?).
     * - Space: (?).
     * @returns {SinglyLinkedList} This list after the negatives are removed.
     */
    removeNegatives() {
        //if empty
        if (this.isEmpty() == true) {
            console.log("EMPTY");
            return this;
        }
        //if no head.next && head.value > -1
        if (this.head.next == null && this.head.value > -1) {
            console.log("EMPTY");
            return this;
        }
        //lagger leader
        if (this.head.data < 0) {
            while (this.head.data < 0) {
                this.head = this.head.next;
            }
        }
        var lagger = this.head;
        var leader = lagger.next;
        //while leader is not null (traverses the entire list)
        while (leader.next != null) {
            //if leader value is less than 0, assign laggers next to be leader next
            if (leader.data < 0) {
                //reassign memory pointer for lagger's next to be the node after the negative value
                return (lagger.next = leader.next);
            }
            //increment lagger and leader
            lagger = lagger.next;
            leader = leader.next;
        }
        //return the list - all negs should have been reassigned
        return this;
    }

    getSecondToLastNode() {
        if (this.isEmpty()) return null;

        let runner = this.head;

        while (runner.next.next != null) {
            runner = runner.next;
        }

        return runner;
    }

    getLastNode() {
        if (this.isEmpty()) return null;

        let runner = this.head;

        while (runner.next != null) {
            runner = runner.next;
        }

        return runner;
    }
}

var t1 = new SinglyLinkedList();
var seeder = [0, -1, 3, 4, -2];
t1.seedFromArr(seeder);
console.log("***************BEFORE1*****************");
console.log(t1);
t1.removeNegatives();
console.log("***************AFTER1*****************");
console.log(t1);

// has loop test case
var sllArr = [3, 5, -2, 3, -7, 9, 1, 0 - 2, 8];
const sll = new SinglyLinkedList();
sll.seedFromArr(sllArr);
var secondToLastNode = sll.getSecondToLastNode();
var lastNode = sll.getLastNode();
lastNode.next = secondToLastNode;
console.log("*************** HAS LOOP (expect true) *****************");
console.log(sll.hasLoop());

// remove Negatives Test Case
var sllArr2 = [-4, -2, 3, 5, -2, 9, 1, 0 - 2, 8];
const sll2 = new SinglyLinkedList();
sll2.seedFromArr(sllArr2);
console.log("***************BEFORE2*****************");
console.log(sll2);
sll2.removeNegatives();
console.log("***************AFTER2*****************");
console.log(sll2);
