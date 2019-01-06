package advanced;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int leafSum = 0;

    public int getResult() {
        return leafSum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        leafSum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private static long modulo = (long) (1e9 + 7);
    public int getResult() {
        return (int) (product % modulo);
    }

    public void visitNode(TreeNode node) {
        visit(node.getValue(), node.getColor());
    }

    public void visitLeaf(TreeLeaf leaf) {
        visit(leaf.getValue(), leaf.getColor());
    }

    private void visit(int value, Color color) {
        if (color.equals(Color.RED)) {
            if (0 == value) {
                value = 1;
            }
            product = (product * value) % modulo;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int a = 0;
    private int b = 0;

    public int getResult() {
        //implement this
        return Math.abs(a - b);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            a += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            b += leaf.getValue();
        }
    }
}

public class JavaTreeVis {

    private static Tree traceMatrix(Map<Integer, Set<Integer>> map, int current,
                                    int[] values, Color[] colors, TreeNode currentNode) {
        char depth = (char) currentNode.getDepth();
        Set<Integer> links = map.get(current);
        boolean isNode = (null != links && !links.isEmpty());
        if (!isNode) {
            return new TreeLeaf(values[current], colors[current], depth);
        } else {
            for (int j : links) {
                Set<Integer> linked = map.get(j);
                if (null != linked && linked.contains(current)) {
                    linked.remove(current);
                }
                Tree child = traceMatrix(map, j, values, colors,
                        new TreeNode(values[j], colors[j], depth + 1));
                currentNode.addChild(child);
            }
            return currentNode;
        }
    }

    private static Tree getLinkMatrix(Scanner scan, int n, int[] values, Color[] colors) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            Set<Integer> set;
            if (!map.containsKey(a - 1)) {
                set = new HashSet<>();
                map.put(a - 1, set);
            } else {
                set = map.get(a - 1);
            }
            set.add(b - 1);

            if (!map.containsKey(b - 1)) {
                set = new HashSet<>();
                map.put(b - 1, set);
            } else {
                set = map.get(b - 1);
            }
            set.add(a - 1);
        }

        return traceMatrix(map, 0, values, colors, new TreeNode(values[0], colors[0], 0));
    }

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] values = new int[n];
        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            values[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int c = scan.nextInt();
            colors[i] = (1 == c) ? Color.GREEN : Color.RED;
        }

        return getLinkMatrix(scan, n, values, colors);
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}