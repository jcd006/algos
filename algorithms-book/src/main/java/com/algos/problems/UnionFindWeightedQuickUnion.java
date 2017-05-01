package com.algos.problems;

/**
 * Created by kiran on 4/24/2017.
 */
public class UnionFindWeightedQuickUnion {

    int count;

    int [] a;

    int [] sz;

    public UnionFindWeightedQuickUnion(int N) {
        count = N;
        a = new int[N];
        sz = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = i;
            //Initialize size array to 1
            sz[i] = 1;
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
        //If pRoot has lower depth attach to qRoot
        // and vice versa
        if(sz[pRoot] < sz[qRoot]) {
            a[pRoot] = qRoot;
            //Size of qRoot increases by size of pRoot;
            sz[qRoot]  += sz[pRoot];
        } else {
            a[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
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
        UnionFindWeightedQuickUnion uf = new UnionFindWeightedQuickUnion(size);
    }
}
