package dictionary.api.features.share.helper;

public class CachingHelper {
    public static String buildCacheKey(String word, String sourceLan, String targetLang){
        String s = "_";
        return word + s + sourceLan + s + targetLang;
    }
}
