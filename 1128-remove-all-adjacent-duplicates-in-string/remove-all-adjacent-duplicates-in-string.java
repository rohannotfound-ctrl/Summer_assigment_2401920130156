class Solution {
    public String removeDuplicates(String s) {
      StringBuilder st= new  StringBuilder();
      for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        int n=st.length();
        if(n>0 && st.charAt(n-1)==ch){
            st.deleteCharAt(n-1);
        }else{
            st.append(ch);
        }
      }
      return st.toString();  
    }
}