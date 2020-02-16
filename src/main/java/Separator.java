import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Separator {

    public static List<List<Integer>> separate(int[] input, int parts) throws SeparatorException {
        checkIfDataIsCorrect(input, parts);
        int total = IntStream.of(input).sum();
        if(total % parts != 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> keysVal = new HashMap<>();
        for(int i : input) {
            keysVal.computeIfPresent(i, (a, b) -> b + 1);
            keysVal.putIfAbsent(i, 1);
        }

        List<List<Integer>> result = new ArrayList<>(parts);
        for(int i=0; i<parts; i++) {
            result.add(new ArrayList<>());
        }

        if(recursiveSeparate(keysVal, total/parts, result, 0, parts, parts)) {
            return result;
        }
        return new ArrayList<>();
    }

    private static void checkIfDataIsCorrect(int[] input, int parts) throws SeparatorException {
        if(parts < 2) {
            throw new SeparatorException(ErrorCode.PARTS_COUNT_MUST_BE_TWO_AT_LEAST);
        }
    }

    private static boolean recursiveSeparate(
            Map<Integer, Integer> values,
            int maxSum,
            List<List<Integer>> result,
            int currentSum,
            int remainingSequences,
            int maxSequences
    ) {
        for(int value : values.keySet()) {
            result.get(maxSequences - remainingSequences).add(value);
            currentSum += value;
            if(currentSum != maxSum && recursiveSeparate(createNewMapAndDeleteValue(values, value), maxSum, result, currentSum, remainingSequences, maxSequences)) {
                return true;
            }
            else if(notLastSequenceIsBuilt(currentSum == maxSum, remainingSequences)
                    && recursiveSeparate(createNewMapAndDeleteValue(values, value), maxSum, result, 0, remainingSequences - 1, maxSequences)
                    || lastSequenceIsBuilt(currentSum == maxSum, remainingSequences, values)
                    || lastSequenceIsBuiltButMainSequenceIsNotEmpty(currentSum == maxSum, remainingSequences, values)
                    && recursiveSeparate(createNewMapAndDeleteValue(values, value), maxSum, result, 0, remainingSequences, maxSequences)
            ) {
                return true;
            }
            currentSum -= value;
            result.get(maxSequences - remainingSequences).remove(result.get(maxSequences - remainingSequences).size()-1);
        }
        return currentSum == maxSum;
    }

    private static boolean notLastSequenceIsBuilt(boolean isSequenceBuiltBySum, int count) {
        return isSequenceBuiltBySum && count > 1;
    }

    private static boolean lastSequenceIsBuilt(boolean isSequenceBuiltBySum, int count, Map<Integer, Integer> values) {
        return isSequenceBuiltBySum && count == 1 && values.size() == 1 && values.values().contains(1);
    }

    private static boolean lastSequenceIsBuiltButMainSequenceIsNotEmpty(boolean isSequenceBuiltBySum, int count, Map<Integer, Integer> values) {
        return isSequenceBuiltBySum && count == 1 && values.size() >= 1 && values.values().stream().mapToInt(Integer::intValue).sum() > 1;
    }

    private static Map<Integer, Integer> createNewMapAndDeleteValue(Map<Integer, Integer> values, int value) {
        Map<Integer, Integer> newValues = new HashMap<>(values);
        if (newValues.get(value) == 1) {
            newValues.remove(value);
        } else {
            newValues.computeIfPresent(value, (a, b) -> b = b - 1);
        }
        return newValues;
    }

}
