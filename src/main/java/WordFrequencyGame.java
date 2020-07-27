import java.util.*;

public class WordFrequencyGame {

    private final String SPLIT_PATTERN = "\\s+";

    private final String CALCULATE_MESSAGE = "Calculate Error";


    public String getResult(String inputStr) {

        if (inputStr.split(SPLIT_PATTERN).length==1) {
            return inputStr + " 1";
        } else {

            try {

                String[] words = inputStr.split(SPLIT_PATTERN);

                List<WordInfo> inputList = new ArrayList<>();
                for (String word : words) {
                    WordInfo wordInfo = new WordInfo(word, 1);
                    inputList.add(wordInfo);
                }

                Map<String, List<WordInfo>> wordInfosMap =getListMap(inputList);

                List<WordInfo> list = new ArrayList<>();
                for (Map.Entry<String, List<WordInfo>> entry : wordInfosMap.entrySet()) {
                    WordInfo input = new WordInfo(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfo w : inputList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_MESSAGE;
            }
        }
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> inputList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo input : inputList){
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            }
            else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
