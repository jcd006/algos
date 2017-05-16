package com.algos.problems;

/**
 * Created by kiran on 4/24/2017.
 */
public class UnionFindQuickFind {

    int count;

    int [] a;

    public UnionFindQuickFind(int N) {
        count = N;
        a = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = i;
        }
    }

    public int find(int p) {
        return a[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        //If both are in the same connected component, skip
        if(pId == qId)
            return;

        for(int i=0;i<a.length;i++) {
            if(a[i] == pId) {
                a[i] = qId;
            }
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
        UnionFindQuickFind uf = new UnionFindQuickFind(size);
    }
}
