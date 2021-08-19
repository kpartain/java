class BSTNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BST {
    constructor() {
        this.root = null;
    }
    search(val) {
        if (this.root === null) {
            return false;
        }
        var runner = this.root;
        while (runner != null) {
            if (runner.value === val) {
                return true;
            } else if (val < runner.value) {
                runner = runner.left;
            } else if (val > runner.value) {
                runner = runner.right;
            }
        }
        return false;
    }

    insertIterative(val) {
        if (this.root === null) {
            this.root = new BSTNode(val);
        }
        while (runner != null) {
            if (val < runner.value) {
                if (runner.left === null) {
                    runner.left = new BSTNode(val);
                    return;
                }
                runner = runner.left;
            } else if (val > runner.value) {
                if (runner.right === null) {
                    runner.right = new BSTNode(val);
                    return;
                }
                runner = runner.right;
            }
        }
    }
    insertRecursive(val, current = this.root) {
        let newNode = new BSTNode(val);
        if (this.root === null) {
            this.root = newNode;
            return;
        }
        if (val < current.value) {
            if (current.left == null) {
                current.left = newNode;
                return newNode;
            } else {
                return this.insertRecursive(val, current.left);
            }
        } else if (val > current.value) {
            if (current.right == null) {
                current.right = newNode;
                return newNode;
            } else {
                return this.insertRecursive(val, current.right);
            }
        }
    }

    isEmpty() {
        this.root == null ? true : false;
    }

    min() {
        if (this.root === null) {
            return null;
        }
        var runner = this.root;
        while (runner.left != null) {
            runner = runner.left;
        }
        return runner.value;
    }

    max() {
        if (this.root === null) {
            return null;
        }
        var runner = this.root;
        while (runner.right != null) {
            runner = runner.right;
        }
        return runner.value;
    }

    minRecursive(current = this.root) {
        if (current == null) {
            return false;
        }
        if (current.left == null) {
            return current.value;
        }
        current = current.left;
        return this.minRecursive(current);
    }

    maxRecursive(current = this.root) {
        if (current == null) {
            return false;
        }
        if (current.right == null) {
            return current.value;
        }
        current = current.right;
        return this.maxRecursive(current);
    }

    printInOrder(node = this.root) {
        if (node == null) {
            return;
        }
        this.printInOrder(node.left);
        console.log(node.value);
        debugger;
        return this.printInOrder(node.right);
    }

    sortedArrToBST(arr) {
        this.root = this.sortedArrToBSTHelper(arr);
    }
    sortedArrToBSTHelper(arr) {
        if (arr.length < 1) {
            return null;
        }
        var midIndex = Math.floor(arr.length / 2);
        var newNode = new BSTNode(arr[midIndex]);
        newNode.left = this.sortedArrToBSTHelper(arr.slice(0, midIndex));
        newNode.right = this.sortedArrToBSTHelper(
            arr.slice(midIndex + 1, arr.length)
        );
        return newNode;
    }

    size(node = this.root) {
        if (node == null) {
            return 0;
        }
        var count = this.size(node.left) + this.size(node.right) + 1; //root
        return count;
    }

    height(node = this.root) {
        if (node == null) {
            return 0;
        }
        var leftCount = this.height(node.left); //root
        var rightCount = this.height(node.right); //root
        if (leftCount == rightCount) {
            return leftCount + 1;
        } else if (leftCount > rightCount) {
            return leftCount + 1;
        } else {
            return rightCount + 1;
        }
    }
}
console.log("BINTREE ONE********************************");
var binTree = new BST();
binTree.insertRecursive(5); //1
binTree.insertRecursive(7); //2
binTree.insertRecursive(6); //3
binTree.insertRecursive(1); //4
binTree.insertRecursive(4); //5
binTree.insertRecursive(3); //6
binTree.insertRecursive(2); //7
binTree.insertRecursive(8); //8
binTree.insertRecursive(9); //9
console.log("SIZE before:", binTree.size());
console.log("HEIGHT before:", binTree.height());
binTree.insertRecursive(20); //10
binTree.insertRecursive(40); //11
binTree.insertRecursive(50); //12
console.log("SIZE after:", binTree.size());
console.log("HEIGHT after:", binTree.height());

console.log("BINTREE TWO********************************");
var binTree2 = new BST();
binTree2.insertRecursive(5);
binTree2.insertRecursive(2);
binTree2.insertRecursive(1);
binTree2.insertRecursive(30);
binTree2.insertRecursive(4);
binTree2.insertRecursive(8);
binTree2.insertRecursive(6);
binTree2.insertRecursive(12);
binTree2.insertRecursive(9);
console.log("SIZE before:", binTree2.size());
console.log("HEIGHT before:", binTree2.height());
binTree2.insertRecursive(0);
binTree2.insertRecursive(40);
binTree2.insertRecursive(20);
console.log("SIZE after:", binTree2.size());
console.log("HEIGHT after:", binTree2.height());
