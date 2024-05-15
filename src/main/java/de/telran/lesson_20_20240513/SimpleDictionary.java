package de.telran.lesson_20_20240513;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SimpleDictionary {

//    3.* Разбить текст на слова с помощью шаблона регулярного выражения и расчитать
//    словарь встречающихся слов для этого текста
//            (подсчитать количество одинаковых слов, встречающихся в этом тексте).
    public static void main(String[] args) {
        String text = "A regular expression is a sequence of characters that forms a search pattern.\n" +
                "When you search for data in a text, you can use this search pattern to describe what you are searching for.\n" +
                "A regular expression can be a single character, or a more complicated pattern.\n" +
                "Regular expressions can be used to perform all types of text search and text replace operations.";

        Map<String, Long> dictionary = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\w+");//
        Matcher matcher = pattern.matcher(text);
        String word = null;

        // Стандарт

        // 1й вариант
        while (matcher.find()) {
            word = matcher.group().toLowerCase();
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, 1L);
            } else {
                dictionary.put(word, dictionary.get(word) + 1);
            }
        }
        System.out.println(dictionary);

        // 2й вариант
        while (matcher.find()) {
            word = matcher.group().toLowerCase();
            dictionary.put(word, dictionary.getOrDefault(word, 0L) + 1);
        }
        System.out.println(dictionary);

        // Lambda
        // 1й вариант
        dictionary = pattern.matcher(text)
                .results()
                .map(w -> w.group().toLowerCase())
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(dictionary);

        //2й  вариант
        dictionary = Arrays.stream(text.toLowerCase().split("\\W+"))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(dictionary);
    }

}
