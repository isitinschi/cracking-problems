import java.util.Set;
import java.util.HashSet;

public class Solution {

    public String getHint(String secret, String guess) {

        if (secret == null || guess == null || secret.length() != guess.length()) {
            return null;
        }
        if (secret.length() == 0) {
            return "0A0B";
        }        

        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;    
            } else {
                Integer count = secretMap.get(secret.charAt(i));
                if (count == null) {
                    count = 0;
                }
                secretMap.put(secret.charAt(i), count + 1);
                
                count = guessMap.get(guess.charAt(i));
                if (count == null) {
                    count = 0;
                }
                guessMap.put(guess.charAt(i), count + 1);
            }
        }        

        for (Character sC : secretMap.keySet()) {
            if (guessMap.containsKey(sC)) {
                if (guessMap.get(sC) < secretMap.get(sC)) {
                    cows += guessMap.get(sC);
                } else {
                    cows += secretMap.get(sC);
                }
            }
        }        

        return bulls + "A" + cows + "B";
    }

}