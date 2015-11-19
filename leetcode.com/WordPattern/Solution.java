import java.util.StringTokenizer;

public class Solution {
	
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
		
        if (pattern.isEmpty() || str.isEmpty()) {
            return false;
        }        

        StringTokenizer tokenizer = new StringTokenizer(str);
        HashMap<Character, String> mapPatternToText = new HashMap<>();
        HashMap<String, Character> mapTextToPattern = new HashMap<>();        

        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();           

            if (index >= pattern.length()) {
                return false;
            }           

            char character = pattern.charAt(index++);           

            String value = mapPatternToText.get(character);
            if (value == null) {
                mapPatternToText.put(character, token);
            } else if (!value.equals(token)) {
                return false;
            }           

            Character charValue = mapTextToPattern.get(token);
            if (charValue == null) {
                mapTextToPattern.put(token, character);
            } else if (!charValue.equals(character)) {
                return false;
            }
        }        

        if (index < pattern.length()) {
            return false;
        }        

        return true;
    }

}