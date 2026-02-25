class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans= new ArrayList<>();
        int pfreq []=new int [256];
        int sfreq []=new int [256];
        int low=0;
        int len=0;
        for(int i=0;i<p.length(); i++){
            pfreq[p.charAt(i)]++;
        }
        for(int high=0; high<s.length(); high++){
               sfreq[s.charAt(high)]++;
               len=high-low+1;
            
               while(len>p.length()){
                    sfreq[s.charAt(low)]--;
                    low++;
                    len = high - low + 1;
                   
               }
                     if(isAnagram(sfreq,pfreq)){
                    ans.add(low);
                  }
        }
        return ans;
    }

    public boolean isAnagram(int []sfreq, int [] pfreq){
        for(int i=0;i<256; i++ ){
            if(pfreq[i]!=sfreq[i]){
                return false;
            }
        }
        return true;
    }
}