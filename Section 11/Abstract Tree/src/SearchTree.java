public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem node) {
        // Means the root hasn't been initialized yet
        if (this.root == null) {
            this.root = node;
            return true;
        }
        
        ListItem curr = this.root;
        while (curr != null) {
            int diff = curr.compareTo(node);
            if (diff < 0) {
                if (curr.next() != null) {
                    curr = curr.next();
                } else {
                    curr.setNext(node);
                    return true;
                }
            } else if (diff > 0) {
                if (curr.previous() != null) {
                    curr = curr.previous();
                } else {
                    curr.setPrevious(node);
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem node) {
        if (node != null) {
            System.out.println("Deleting node " + node.getValue());
        }

        ListItem curr = this.root;
        ListItem parent = curr;

        while (curr != null) {
            int diff = (curr.compareTo(node));
            if (diff < 0) {
                parent = curr;
                curr = curr.next();
            } else if (diff > 0) {
                parent = curr;
                curr = curr.previous();
            } else {
                
                performRemoval(curr, parent);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem node, ListItem parent) {
        if (node.next() == null) {
            if (parent.next() == node) {
                parent.setNext(node.previous());
            } else if (parent.previous() == node) {
                parent.setPrevious(node.previous());
            } else {
                this.root = node.previous();
            }
        } else if (node.previous() == null) {
            if (parent.next() == node) {
                parent.setNext(node.next());
            } else if (parent.previous() == node) {
                parent.setPrevious(node.next());
            } else {
                this.root = node.next();
            }
        } else {
            ListItem curr = node.next();
            ListItem leftmostParent = node;

            while (curr.previous() != null) {
                leftmostParent = curr;
                curr = curr.previous();
            }

            node.setValue(curr.getValue());
            if (leftmostParent == node) {
                node.setNext(curr.next());
            } else {
                leftmostParent.setPrevious(curr.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
