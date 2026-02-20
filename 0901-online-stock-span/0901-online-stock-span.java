// Brute force

// class StockSpanner {
//     List<Integer> list;

//     public StockSpanner() {
//         list = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         list.add(price);
//         int count = 1;

//         for(int i=list.size()-2; i>=0; i--) {
//             if(list.get(i) <= price) count++;
//             else break;
//         }

//         return count;
//     }
// }







// Optimal Solution

class StockSpanner {
    Stack<int[]> st;
    int idx;

    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx += 1;
        
        while(!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        
        int ans = idx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[] {price, idx});

        return ans;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */ 