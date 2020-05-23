Problem:
Given a string, find the length of the longest substring without repeating characters.

Solution:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int c=0;int final_count=0;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int j=0;j<s.length();j++){
             for(int i=j;i<s.length();i++) {
                char ch=s.charAt(i);
                if(!map.containsKey(ch)) {
                    map.put(ch,1);
                    c++;
                }
                else { 
                    map.clear();
                    final_count=Integer.max(c,final_count);
                    c=0;
                    break;
                }
            }
        }
       
        final_count=Integer.max(c,final_count);
        return final_count;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}