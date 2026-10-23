
class Solution {
    public String simplifyPath(String path) {
      Stack <String> st=new Stack<>();
      for(String part: path.split("/")){
        if(part.equals("")|| part.equals(".")){
            continue;
        } else if(part.equals("..")){
            if(!st.isEmpty()){
                st.pop();
            }
        }
        else{
            st.push(part);
        }
      }
      StringBuilder ans= new StringBuilder();
      for (String dir:st){
        ans.append("/").append(dir);
      } 
      return ans.length()==0 ? "/" :ans.toString();
    }
}