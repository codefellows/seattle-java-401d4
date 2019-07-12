/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.util.HashSet;

public class Library {

    // { "words": string, "shouldRunWholeMethod": boolean }

    public String handleRepeatedWordRequest(RepeatedWordRequest request) {
        if(request.shouldRunWholeMethod) {
            return getRepeatedWord(request.words);
        } else {
            return "done";
        }
    }
    public String getRepeatedWord(String words) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words.split(" ")) {
            if (wordSet.contains(word)) {
                return word;
            } else {
                wordSet.add(word);
            }
        }
        return null;
    }
    public int addNumbers(PairOfNumbers numbers, Context c) {
        LambdaLogger logger = c.getLogger();
        logger.log("received the numbers " + numbers.a + " and " + numbers.b);
        return numbers.a + numbers.b;
    }
}

class RepeatedWordRequest {
    String words;
    boolean shouldRunWholeMethod;

    public void setWords(String words) {
        this.words = words;
    }

    public void setShouldRunWholeMethod(boolean b) {
        this.shouldRunWholeMethod = b;
    }
}
class PairOfNumbers{
    int a;
    int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}