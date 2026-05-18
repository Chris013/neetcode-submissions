class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strings = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d{1,3}#");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){

            String match = matcher.group();
            int matchLength = match.length();
            int sLength = Integer.valueOf(match.split("#")[0]);
            strings.add(str.substring(matchLength, matchLength + sLength));

            str = str.substring(matchLength + sLength);
            matcher = pattern.matcher(str);
        }

        return strings;
    }
}
