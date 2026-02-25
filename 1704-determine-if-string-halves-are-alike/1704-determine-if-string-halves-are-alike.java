class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int len=s.length();
        int vowel=0;
        char c;
        for(int i=0;i<len/2;i++){
            c=s.charAt(i);
          if(c=='a' || c=='e' || c=='i'|| c=='o'||c=='u'){
            vowel++;
          }
        } for(int i=len/2;i<len;i++){
            c=s.charAt(i);
          if(c=='a' || c=='e' || c=='i'|| c=='o'||c=='u'){
            vowel--;
          }
         
        }
         return vowel==0;
    }
}