package org.elasticsearch.analyzer.tokenfilters;

/**
 * Created by Nariman on 10/29/2017.
 */
public class PersianSamePronunciationNormalizer {

    public String normalize(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'ظ':
                case 'ذ':
                case 'ض':
                    stringBuilder.append('ز');
                    break;
                case 'ح':
                    stringBuilder.append('ه');
                    break;
                case 'ص':
                case 'ث':
                    stringBuilder.append('س');
                    break;
                case 'ط':
                    stringBuilder.append('ت');
                    break;
                case 'غ':
                    stringBuilder.append('ق');
                    break;
                default:
                    stringBuilder.append(text.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}