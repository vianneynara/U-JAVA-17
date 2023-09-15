public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem node) {
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
                    curr.setNext(node).setPrevious(curr);
                    return true;
                }
            } else if (diff > 0) {
                if (curr.previous() != null) {
                    curr.previous().setNext(node).setPrevious(curr.previous());
                    node.setNext(curr).setPrevious(node);
                } else {
                    node.setNext(this.root).setPrevious(node);
                    this.root = node;
                }
                return true;
            } else {
                System.out.println(node.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem node) {
        ListItem curr = this.root;
        while (curr != null) {
            int diff = curr.compareTo(node);
            if (diff == 0) {
                if (curr == this.root) {
                    this.root = curr.next();
                } else {
                    curr.previous().setNext(curr.next());
                    if (curr.next() != null) {
                        curr.next().setPrevious(curr.previous());
                    }
                }
                return true;
            } else if (diff < 0) {
                curr = curr.next();
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        } else {
            System.out.println("The list is empty");
        }
    }
}
