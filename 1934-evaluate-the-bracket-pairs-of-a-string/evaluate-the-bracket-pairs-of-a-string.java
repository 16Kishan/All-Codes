class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list: knowledge){
            map.put(list.get(0), list.get(1));
        }
        int start = -1;
        int end = -1;
        String res = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                start = i;
            } else if(c==')'){
                end = i;
                String key = s.substring(start+1, end);
                if(map.containsKey(key)){
                    res = res+map.get(key);
                } else {
                    res = res+"?";
                }
            } else if(start==-1 || start<end){
                res = res+c;
            }
        }
        return res;
        
    }
}