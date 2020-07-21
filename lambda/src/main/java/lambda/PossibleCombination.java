package lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class PossibleCombination {

    private final String[] elements;
    private final CombinationOption option ;

    public PossibleCombination(String[] elements, CombinationOption option) {
        this.elements = elements;
        this.option = option;
    }

    
    public Stream<String> getAll() {
        List<String> allSublists = new ArrayList<>(Arrays.asList(elements));
        int lengthOfList = elements.length;
        while (lengthOfList > 1) {
            List<String> subSet = Arrays.asList(elements);
            int subSetLength = elements.length;
            while (subSetLength >= lengthOfList) {
                subSet = getSubset(elements, subSet);
                subSetLength--;
            }
            allSublists.addAll(subSet);
            lengthOfList--;
        }
        return allSublists.stream();
    }

   
    private List<String> getSubset(String[] elements, List<String> allSubset) {
        List<String> subSet = new ArrayList<>();
        for (String element : elements) {
            Stream<String> stream = allSubset.stream();
            if (option.equals(CombinationOption.EXCLUDE_DUPLICATED)) {
                stream = stream.filter((sub) -> {
                    return !sub.contains(element); //avoiding duplicated names
                });
            }
            subSet.addAll(
                    stream
                    .map(sub -> element + sub)
                    .collect(Collectors.toList()
                )
            );
        }
        return subSet;
    }
}