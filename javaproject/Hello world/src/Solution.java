class Solution {
    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] arr = new int[n];
        int i=0;
        while(i<n) {
            for (int k = n - 1; k >= i; k--) {
                arr[k]=0;
                if(labels.charAt(k)==labels.charAt(i)){
                    arr[k] = 1;
                }
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j][0] == k) {
                        arr[k] += arr[edges[j][1]];
                    }
                }
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int x=4;
        int[][] edges={{0,1},{1,2},{2,3},{3,4},{4,5},{5,6}};
//        for (int e: countSubTrees(7,edges,"aaabaaa")) {
//            System.out.println(e);
//        }
        System.out.println();
    }
}