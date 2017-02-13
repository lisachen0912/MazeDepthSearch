import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> implements Iterable<TreeNode<T>> {
        T data;
        TreeNode<T> parent;
        List<TreeNode<T>> children;
        boolean goal = false;
        boolean visited = false;

        public TreeNode(T data) {
            this.data = data;
            this.children = new LinkedList<TreeNode<T>>();
        }

        public TreeNode<T> addChild(T child) {
            TreeNode<T> childNode = new TreeNode<T>(child);
            childNode.parent = this;
            this.children.add(childNode);
            return childNode;
        }

        public boolean hasChild(){
            if (children.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
 
        public String setGoal() {
            goal = true;
            return data.toString();
        }

        public String setVisited(){
            visited = true;
            return data.toString();
        }

        public boolean isGoal(){
            return goal;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public Iterator<TreeNode<T>> iterator() {
            // TODO Auto-generated method stub
            return null;
        }
    }