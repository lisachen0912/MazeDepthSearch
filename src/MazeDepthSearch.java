import java.util.*;

/* Use depth search to find goal in the maze.
 * Scheduling Algorithms HW
 *
 * Maze tree:
 * root-S1 -S5 -S11 -S20
 *                  -S21
 *             -S12
 *         -S6 -S4
 *             -S22
 *     -S2 -S7 -S13
 *             -S14
 *             -S18
 *         -S8
 *     -S3 -S9 -S15
 *             -S16 -S23
 *                  -S24
 *         -S10 -S17
 *              -S25
 *         -S19
 */

public class MazeDepthSearch {
    static TreeNode<String> MazeRoot;
    static TreeNode<String> S0, S1, S2, S3, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16;
    static TreeNode<String> S4, S17, S18, S19, S20, S21, S22, S23, S24, S25;
    static Stack<String> S = new Stack<String>();

    public static void main(String[] args){
        createMaze();
        S13.setGoal();
        if (depthSearchMaze()) {
            System.out.println("FIND GOAL!!! path: " + S.toString());
        } else {
            System.out.println("FAIL!!!! NO GOAL");
        }
    }

    public static boolean depthSearchMaze() {
        TreeNode currentPoint;
        // put start point in the stack
        currentPoint = MazeRoot;
        S.push(currentPoint.data.toString());
        while(!S.isEmpty()) {
            currentPoint.setVisited();

            if (currentPoint.isGoal()) {
                S.push("Goal");
                return true;
            }

            if (currentPoint.hasChild()){
                int size = currentPoint.children.size();
                int num = 0;
                TreeNode child;
                while (num < size) {
                    child = (TreeNode) currentPoint.children.get(num);
                    if (child.isVisited()) {
                        // next point
                        num++;
                    } else {
                        // not visited
                        currentPoint = child;
                        S.push(currentPoint.data.toString());
                        break;
                    }
                };
                if (num >= size) {
                    // all visited, back to parent
                    currentPoint = currentPoint.parent;
                    S.pop();
                }
            } else {
                // dead end, back to parent
                currentPoint = currentPoint.parent;
                S.pop();
            }
            System.out.println("progress: " + S.toString());
        }
        return false;
    }

    public static void createMaze(){
        /*
         * Create maze tree
         * root-S1 -S5 -S11 -S20
         *                  -S21
         *             -S12
         *         -S6 -S4
         *             -S22
         *     -S2 -S7 -S13
         *             -S14
         *             -S18
         *         -S8
         *     -S3 -S9 -S15
         *             -S16 -S23
         *                  -S24
         *         -S10 -S17
         *              -S25
         *         -S19
         */
        MazeRoot = new TreeNode<String>("Start");
        S0 = MazeRoot.addChild("S0");
        {
            S1 = S0.addChild("S1");
            {
                S5 = S1.addChild("S5");
                {
                    S11 = S5.addChild("S11");
                    {
                        S20 = S11.addChild("S20");
                        S21 = S11.addChild("S21");
                    }
                    S12 = S5.addChild("S12");
                }
                S6 = S1.addChild("S6");
                {
                    S4 = S6.addChild("S4");
                    S22 = S6.addChild("S22");
                }
            }
            S2 = S0.addChild("S2");
            {
                S7 = S2.addChild("S7");
                {
                    S13 = S7.addChild("S13");
                    S14 = S7.addChild("S14");
                    S18 = S7.addChild("S18");
                }
                S8 = S2.addChild("S8");
            }
            S3 = S0.addChild("S3");
            {
                S9 = S3.addChild("S9");
                {
                    S15 = S9.addChild("S15");
                    S16 = S9.addChild("S16");
                    {
                        S23 = S16.addChild("S23");
                        S24 = S16.addChild("S24");
                    }
                }
                S10 = S3.addChild("S10");
                {
                    S17 = S10.addChild("S17");
                    S25 = S10.addChild("S25");
                }
                S19 = S3.addChild("S19");
            }
        }
    }
}

