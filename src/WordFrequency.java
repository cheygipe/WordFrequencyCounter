import java.io.FileReader;
import java.util.*;

public class WordFrequency {

    static String readerToString(FileReader fileReader) throws Exception {
        int i;
        StringBuilder text = new StringBuilder();

        while ((i = fileReader.read()) != -1) {
            text.append((char) i);
        }

        return text.toString();
    }

    static ArrayList<String> wordsToList(String text) {
        StringBuilder word = new StringBuilder();
        ArrayList<String> wordsList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\n' || text.charAt(i) == '\r') {
                if (word.length() > 0) {
                    wordsList.add(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(text.charAt(i));
            }
            if (i == text.length() - 1 && word.length() > 0) {
                wordsList.add(word.toString());
                word = new StringBuilder();
            }
        }
        return wordsList;
    }

    static int numberOfCharacters(String text) {
        String textWithoutLineBreak = text.replaceAll("([\\r\\n])", "");
        return textWithoutLineBreak.length();
    }

    static Map<Integer, List<String>> wordFrequencyCounter(ArrayList<String> wordsList) {
        int wordCounter;
        Map<Integer, List<String>> map = new TreeMap<>();
        ArrayList<String> nonRepeatedWords = new ArrayList<>();

        nonRepeatedWords.add(wordsList.get(0));

        for (int i = 0; i < wordsList.size(); i++) {
            for (String each : wordsList) {
                if (!nonRepeatedWords.contains(each)) {
                    nonRepeatedWords.add(each);
                }
            }
        }

        for (String nonRepeatedWord : nonRepeatedWords) {
            wordCounter = 0;
            for (String each : wordsList) {
                if (nonRepeatedWord.equals(each)) {
                    wordCounter++;
                }
            }
            map.computeIfAbsent(wordCounter, k -> new ArrayList<>());
            map.get(wordCounter).add(nonRepeatedWord);
        }

        sortListWordsAlphabetically(map);
        return map;
    }

    static void sortListWordsAlphabetically(Map<Integer, List<String>> map) {
        Comparator<String> myComparator = (string1, string2) -> {
            if (string1 == null && string2 == null) return 0;
            if (string1 == null) return 1;
            if (string2 == null) return -1;
            return string1.compareTo(string2);
        };

        for (List<String> list : map.values()) {
            list.sort(myComparator);
        }
    }

    static void printWordFrequencies(Map<Integer, List<String>> map) {
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        for (int i = keys.size() - 1; i >= 0; i--) {
            if (map.get(keys.get(i)).size() > 1) {
                for (int j = 0; j < map.get(keys.get(i)).size(); j++) {
                    System.out.printf("%-30.30s  %-30.30s%n", map.get(keys.get(i)).get(j) + ":", keys.get(i));
                }
            } else {
                System.out.printf("%-30.30s  %-30.30s%n", map.get(keys.get(i)).get(0) + ": ", keys.get(i));
            }
        }
    }

    static void printingController(String text) {
        Map<Integer, List<String>> map = wordFrequencyCounter(wordsToList(text));

        System.out.printf("%-30.30s  %-30.30s%n", wordsToList(text).size(), "words");
        System.out.printf("%-30.30s  %-30.30s%n", numberOfCharacters(text), "characters");
        System.out.println("------------------------------------------");
        printWordFrequencies(map);
    }

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("C:\\Users\\user\\Documents\\WordFrequencyCounter\\words.txt");
        String text = readerToString(fileReader);

        printingController(text);
    }
}
