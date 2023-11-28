package org.elasticsearch.analyzer.tokenfilters;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class PersianSamePronunciationNormalizerFilter extends TokenFilter {

    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    private PersianSamePronunciationNormalizer normalizer;

    protected PersianSamePronunciationNormalizerFilter(TokenStream input) {
        super(input);
        normalizer = new PersianSamePronunciationNormalizer();
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            String token = new String(termAttribute.buffer(), 0, termAttribute.length()).trim();

            if (token.length() > 0) {
                String term = normalizer.normalize(token);
                termAttribute.setEmpty();
                termAttribute.append(term);
            }

            return true;
        }

        return false;
    }
}
