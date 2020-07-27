import java.util.*;

public class WordFrequencyGame {

    private final String SPLIT_PATTERN = "\\s+";

    private final String CALCULATE_MESSAGE = "Calculate Error";


    public String getResult(String inputStr) {

        if (inputStr.split(SPLIT_PATTERN).length==1) {
            return inputStr + " 1";
        } else {

            try {

                String[] wordInfo = inputStr.split(SPLIT_PATTERN);

                List<Input> inputList = new ArrayList<>();
                for (String word : wordInfo) {
                    Input input = new Input(word, 1);
                    inputList.add(input);
                }

                Map<String, List<Input>> map =getListMap(inputList);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Input w : inputList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_MESSAGE;
            }
        }
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList){
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
