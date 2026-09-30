class Solution {
    public int strStr(String txt, String part) {
        int m=part.length(),n=txt.length();
        for(int i=0;i<=n-m;i++){
            int j;
            for( j=0;j<m;j++){
                if(part.charAt(j)!=txt.charAt(i+j))
                break;
            }
                if(j==m)
                return i;
        }
        return -1;
    }
}