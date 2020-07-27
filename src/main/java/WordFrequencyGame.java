import java.util.*;

public class WordFrequencyGame {

    private  final String SPLIT_PATTERN = "\\s+";

    private final String CALCULATE_MESSAGE = "Calculate Error";

    private final String LINE = "\n";

    private final String SPACE = " ";


    public String getResult(String inputStr) {

        if (inputStr.split(SPLIT_PATTERN).length==1) {
            return inputStr + " 1";
        } else {
            try {
                List<WordInfo> inputList = calculteWorldFrequency(inputStr);

                for (String word : words) {
                    WordInfo wordInfo = new WordInfo(word, 1);
                    inputList.add(wordInfo);
                }

                Map<String, List<WordInfo>> wordInfosMap = getListMap(inputList);

                List<WordInfo> wordInfos = new ArrayList<>();


                for (Map.Entry<String, List<WordInfo>> entry : wordInfosMap.entrySet()) {
                    WordInfo input = new WordInfo(entry.getKey(), entry.getValue().size());
                    wordInfos.add(input);
                }
                inputList = wordInfos;

                inputList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner(LINE);
                for (WordInfo w : inputList) {
                    String s = w.getValue() + SPACE + w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_MESSAGE;
            }
        }
    }

    private List<WordInfo> calculteWorldFrequency(String inputStr) {
        return null;
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> inputList) {
        Map<String, List<WordInfo>> wordInfosMap = new HashMap<>();
        for (WordInfo input : inputList) {
            if (!wordInfosMap.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                wordInfosMap.put(input.getValue(), arr);
            } else {
                wordInfosMap.get(input.getValue()).add(input);
            }
        }
        return wordInfosMap;
    }
}
