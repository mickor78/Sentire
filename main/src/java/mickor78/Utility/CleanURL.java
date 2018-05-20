package mickor78.Utility;

public class CleanURL {
    /**
     * Clean characters of URL
     *
     * @param url
     */
    public static String cleanURL(String url) {
        url = url.replace("\\", "\\");
        url = url.replaceAll(" ", "%20");
        url = url.replace("[", "%5B");
        url = url.replace("]", "%5D");
        return url;
    }
}
