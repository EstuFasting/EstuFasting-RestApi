package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class StringTools {

    /**
     * @param source String to be searched the regex
     * @param regex  Regex to be extracted from source string
     * @return First substring which satisfies regex
     */
    public static Optional<String> extract(String source, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(source);
        return matcher.find() ? Optional.ofNullable(matcher.group(0)) : Optional.empty();
    }

    /**
     * A basic string comparison algorithm.
     * Calculates the minimum number of operations you must do to change one string to another.
     * In other words Levenshtein distance is Needleman-Wunch distance with G=1.
     *
     * @param s1 String to be compared with second string
     * @param s2 String to be compared with first string
     * @return <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein distance</a> between 2 string
     * @apiNote <a href="http://web.archive.org/web/20081224234350/http://www.dcs.shef.ac.uk/~sam/stringmetrics.html">Different string comparison algorithms</a>
     */
    public static int levenshteinDistance(String s1, String s2) {
        if (s1 == null || s2 == null) return Integer.MAX_VALUE;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++)
            for (int j = 0; j <= s2.length(); j++)
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else dp[i][j] = NumberUtils.min(
                            dp[i - 1][j - 1] + s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1,
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);

        return dp[s1.length()][s2.length()];
    }

}
