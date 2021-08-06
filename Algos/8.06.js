class SLNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    printValues() {
        if (this.head == null) {
            console.log("LIST EMPTY");
            return;
        }
        // IF THE LIST IS NOT EMPTY
        var runner = this.head;
        var printstring = "";
        while (runner != null) {
            printstring += runner.value + " ";
            runner = runner.next;
        }
        console.log(printstring);
    }

    insertAtBack(data) {
        var newNode = new SLNode(data);
        if (this.head == null) {
            this.head = newNode;
            return this;
        }
        if (this.head.next == null) {
            this.head.next = newNode;
            return this;
        }
        var runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
        return this;
    }

    seedFromArr(arr) {
        for (var i = 0; i < arr.length; i++) {
            this.insertAtBack(arr[i]);
        }
        return this;
    }

    insertAtFront(value) {
        var newHead = new SLNode(value);
        if (this.head != null) {
            newHead.next = this.head;
        }
        this.head = newHead;
        return this;
    }

    average() {
        var sum = 0;
        var numberOfNodes = 0;
        var runner = this.head;
        while (runner.next != null) {
            sum = sum + runner.value;
            runner = runner.next;
            numberOfNodes++;
        }
        sum += runner.value;
        var average = sum / numberOfNodes;
        console.log(
            "SUM",
            sum,
            ", NUMBER OF NODES",
            numberOfNodes,
            ", AVERAGE",
            average
        );
        return average;
    }

    contains(value) {
        if (this.head == null) {
            return false;
        }
        var runner = this.head;
        while (runner != null) {
            if (runner.value == value) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    removeBack() {
        if (this.head == null || this.head.next == null) {
            return false;
        }
        var runner = this.head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;
        return this;
    }

    containsRecursive(val, current = this.head) {
        if (current == null) {
            return false;
        } else if (current.value == val) {
            return true;
        } else {
            current = current.next;
            return this.containsRecursive(val, current);
        }
    }

    secondToLast() {
        //retrieves data of 2nd to last node
        if (this.head == null || this.head.next == null) {
            return false;
        }

        var walker = null;
        var runner = this.head;
        while (runner.next != null) {
            walker = runner;
            runner = runner.next;
        }

        return walker.value;
    }

    removeVal(value) {
        //removes the node
        if (this.head == null) {
            return false;
        }
        var walker = this.head;
        while (walker != null) {
            var runner = walker.next;
            if (walker.value == value) {
                while (runner != null) {
                    walker = walker.next;
                    runner = runner.next;
                }
            }
            runner = runner.next;
        }
    }
    kthToLast(k) {
        if (this.head == null) {
            console.log("LIST EMPTY");
            return false;
        }
        if (this.head.next == null && k == 1) {
            return this.head.value;
        }
        let count = 1;
        let walker = this.head;
        // IF THE LIST IS NOT EMPTY
        var runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
            count++;
        }
        if (k > count) {
            return null;
        }
        for (let i = 0; i < count - k; i++) {
            walker = walker.next;
        }
        return walker.value;
    }
}

var newList3 = new SLL();
newList3.insertAtFront(100);
newList3.insertAtFront(200);
newList3.insertAtFront(300);
newList3.insertAtFront(400);
newList3.insertAtFront(500);
newList3.insertAtFront(600);
newList3.insertAtFront(700);
//newList3.printValues();
console.log("\n\n");
newList3.removeAtFront();
newList3.printValues();

console.log(newList3.containsRecursive(100));
console.log(newList3.containsRecursive(500));
console.log(newList3.recursiveMax());

console.log(newList3.secondToLast());
console.log(newList3.removeVal(200));
newList3.printValues();

newList3.printValues();
console.log(newList3.kthToLast(1));
console.log(newList3.kthToLast(2));
console.log(newList3.kthToLast(3));
console.log(newList3.kthToLast(7));
console.log(newList3.kthToLast(8));
console.log(newList3.average());
