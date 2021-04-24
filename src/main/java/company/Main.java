package company;

import company.filter.WordFilter;
import company.parser.Parser;
import company.parser.Token;
import company.sentence.Sentence;
import company.sentence.SentenceBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            String text = new BufferedReader(new FileReader("src\\res.txt")).lines().collect(Collectors.joining());
            Parser parser = new Parser(text);
            List<Token> tokens = parser.parse();

            SentenceBuilder sentenceBuilder = new SentenceBuilder(tokens);
            sentenceBuilder.filter(new WordFilter(5)); // TODO input length
            sentenceBuilder.buildSentences();

            for (Sentence sentence : sentenceBuilder.getSentences()) {
                System.out.println(sentence.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
