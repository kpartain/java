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
        // BST IS EMPTY
        if (this.root === null) {
            return false;
        }
        // BST IS NOT EMPTY
        var runner = this.root;

        while (runner != null) {
            // IS THE VALUE WITHIN THE NODE
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
        // IS THE BST EMPTY?
        if (this.root === null) {
            this.root = new BSTNode(val);
        }
        // HAVE YOUR RUNNER END UP IN THE COORECT SPOT
        // CREATE A NODE ON THE CORRECT SIDE OF THAT NODE
        while (runner != null) {
            // CHECK TO SEE IF VALUE TO INSERT IS LESS THAN RUNNER VALES
            if (val < runner.value) {
                // CHECK TO SEE IF THERE IS AN EMPTY PLACE TO CREATE NEW NODE
                if (runner.left === null) {
                    runner.left = new BSTNode(val);
                    return;
                }
                // IF THERE IS AN EXISTING NODE, KEEP ON RUNNING THROUGH BST
                runner = runner.left;
            }
            // CHECK TO SEE IF VALUE TO INSERT IS GREATER THAN RUNNER VALES
            else if (val > runner.value) {
                if (runner.right === null) {
                    runner.right = new BSTNode(val);
                    return;
                }
                runner = runner.right;
            }
        }
    }
    insertRecursive(val, current = this.root) {
        //Base Case first
        let newNode = new BSTNode(val);
        if (this.root === null) {
            this.root = newNode;
        }

        //Forward progress
        if (val < current.value) {
            if (current.left == null) {
                current.left = newNode;
                return newNode;
            } else {
                current = current.left;
            }
        } else if (val > current.value) {
            if (current.right == null) {
                current.right = newNode;
                return newNode;
            } else {
                current = current.right;
            }
        }

        //Recursive call
        return this.insertRecursive(val, current);
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
        // 1. BASE CASE - WHEN THE NODE GIVEN IS NULL
        if (current == null) {
            return false; //If the bst is empty
        }
        //If we find the value we are looking for, and there is no smaller value
        if (current.left == null) {
            return current.value;
        }
        // 2. FORWARD PROGRESS
        current = current.left;
        // 3. RECURSIVE CALL
        return this.minRecursive(current);
    }

    maxRecursive(current = this.root) {
        // 1. BASE CASE - WHEN THE NODE GIVEN IS NULL
        if (current == null) {
            return false; //If the bst is empty
        }
        //If we find the value we are looking for, and there is no smaller value
        if (current.right == null) {
            return current.value;
        }
        // 2. FORWARD PROGRESS
        current = current.right;
        // 3. RECURSIVE CALL
        return this.maxRecursive(current);
    }
}
