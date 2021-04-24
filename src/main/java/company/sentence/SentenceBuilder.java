package company.sentence;

import company.parser.Token;
import company.parser.TokenType;
import company.filter.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceBuilder {
    private List<Token> tokens;
    private List<Sentence> sentences;

    public SentenceBuilder(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void filter(Filter<Token> tokenFilter){
        tokens = tokens.stream().filter(tokenFilter::check).collect(Collectors.toList());
    }

    public void buildSentences() {
        sentences = new ArrayList<>();
        List<Token> currentSentenceTokens = new ArrayList<>();
        for (Token token : tokens) {
            if (token.getType() == TokenType.WHITESPACE && currentSentenceTokens.isEmpty()) {
                continue;
            }

            currentSentenceTokens.add(token);

            if (token.getValue().equals(".")) {
                sentences.add(new Sentence(currentSentenceTokens));
                currentSentenceTokens = new ArrayList<>();
            }
        }
    }
}
