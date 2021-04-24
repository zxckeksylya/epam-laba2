package company.sentence;

import company.parser.Token;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sentence {
    private final List<Token> tokens;

    public List<Token> getTokens() {
        return tokens;
    }

    public Sentence(List<Token> tokens)  {
        if(!Objects.equals(tokens.get(tokens.size() - 1).getValue(), ".")){
            throw new IllegalArgumentException("The sentence must end with a dot");
        }
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return tokens.stream().map(Token::toString).collect(Collectors.joining());
    }
}
