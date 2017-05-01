package com.algos.problems;

/**
 * Created by kiran on 4/24/2017.
 */
public class UnionFindQuickUnion {

    int count;

    int [] a;

    public UnionFindQuickUnion(int N) {
        count = N;
        a = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = i;
        }
    }

    public int find(int p) {
        while(p != a[p]) {
            p = a[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        //If both are in the same connected component, skip
        if(pRoot == qRoot)
            return;
        a[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        UnionFindQuickUnion uf = new UnionFindQuickUnion(size);
    }
}
