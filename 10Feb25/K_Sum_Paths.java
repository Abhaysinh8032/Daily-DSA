//K Sum Paths
//https://www.geeksforgeeks.org/problems/k-sum-paths/1


class Solution {
        int cnt;
        
    public int sumK(Node root, int k) {
        // code here
        cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        solve(root , k , map , 0);
        
        return cnt;
    }
    
    void solve(Node root , int k ,HashMap<Integer,Integer> map , int sum )
    {
        if(root == null) return;
        
        sum += root.data;
        
        if(sum == k) cnt++;
        if(map.containsKey(sum - k)) cnt += map.get(sum - k);
        map.put(sum , map.getOrDefault(sum , 0) + 1);
        
        solve(root.left , k , map , sum);
        solve(root.right , k , map , sum);
        
        map.put(sum , map.get(sum) - 1);
        if(map.get(sum) == 0) map.remove(sum);
    }
}