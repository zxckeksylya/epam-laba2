package company.filter;

import company.parser.Token;
import company.parser.TokenType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class WordFilter implements Filter<Token> {
    private static final HashSet<Character> consonants =
            new HashSet<>(Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'c', 'т', 'ф', 'x', 'ц', 'ч', 'ш', 'щ','b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'));
    private final int length;

    public WordFilter(int length) {
        this.length = length;
    }

    @Override
    public boolean check(Token value) {
        return !(value.getType() == TokenType.WORD &&
                isConsonant(value.getValue().toLowerCase(Locale.ROOT).toCharArray()[0]) &&
                value.getValue().length() == length);
    }

    private boolean isConsonant(char t) {
        return consonants.contains(t);
    }
}
