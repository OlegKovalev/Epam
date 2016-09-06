package uniqueCharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacterCounter {

    static Map<String, Integer> cache = new HashMap<>();

    public static int countUniqueCharacter(final String sample){
        if (cache.containsKey(sample)) {
            return cache.get(sample);
        }
        int length = sample.length();
        Set<Character> occurred = new HashSet<>(length);
        Set<Character> duplicates = new HashSet<>();

        for(int i=0; i < length; i++){
            Character c = new Character(sample.charAt(i));
            if(occurred.contains(c)){
                duplicates.add(c);
            } else {
                occurred.add(c);
            }
        }
        occurred.removeAll(duplicates);
        cache.put(sample, occurred.size());
        return occurred.size();
    }
}
