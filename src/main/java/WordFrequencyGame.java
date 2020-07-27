import java.util.*;

public class WordFrequencyGame {

    private  final String SPLIT_PATTERN = "\\s+";

    private final String CALCULATE_MESSAGE = "Calculate Error";

    private final String LINE = "\n";

    private final String SPACE = " ";

    public String getResult(String inputStr) {
        try {
            List<WordInfo> inputList = calculteWorldFrequency(inputStr);

            inputList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

            return generateWorldFrequenceResult(inputList);

        } catch (Exception e) {
            return CALCULATE_MESSAGE;
        }
    }

    private List<WordInfo> calculteWorldFrequency(String inputStr) {
        List<WordInfo> wordInfos = new ArrayList<>();
        List<String> words = Arrays.asList(inputStr.split(SPLIT_PATTERN));
        for (String word : new HashSet<>(words)) {
            int wordCount = (int) words.stream().filter(word::equals).count();
            wordInfos.add(new WordInfo(word, wordCount));
        }
        return wordInfos;
    }

    private String generateWorldFrequenceResult(List<WordInfo>  inputList) {
        StringJoiner joiner = new StringJoiner(LINE);
        for (WordInfo w : inputList) {
            String s = w.getValue() + SPACE + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}
