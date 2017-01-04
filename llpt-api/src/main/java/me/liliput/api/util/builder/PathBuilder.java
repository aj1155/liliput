package me.liliput.api.util.builder;

import lombok.extern.slf4j.Slf4j;
import me.liliput.api.domain.ShortUrl;
import me.liliput.api.util.builder.exception.UrlShorteningFailureException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1002731 on 2017. 1. 4..
 * Email : eenan@sk.com
 */
@Slf4j
public class PathBuilder {

    private ShortUrl shortUrl = new ShortUrl();

    // HOST PATH
    private static final String REGEX_URL="^(?:[a-z]*\\:\\/\\/)(?:\\w+:\\w+@)?(?:(?:[-\\w]+\\.)+(?:[a-zA-Z]*))(?::[\\d]{1,5})?.*";

    // SCHEME
    private static final String REGEX_SHEMEURL = "^((http|https):\\/\\/.*)";

    // SCHEME CHECK HTTP
    private static final String REGEX_HTTPURL = "^((http(s?)):\\/\\/.*)";

    private static final String REGEX_SHORTURL= "^(http(s?)\\:\\/\\/((\\w+\\.)?)nexters\\.me.*)";
    private static final String REGEX_INVALID_URL_STRING = "^(.*(<script|%3Cscript|<javascript|%3Cjavascript|<SCRIPT|%3CSCRIPT|<JAVASCRIPT|%3CJAVASCRIPT).*)";
    private static final String REGEX_URL_HOST="^(?:[a-zA-Z]*\\:\\/\\/|~\\/|\\/)(?:\\w+:\\w+@)?(?:(?:[-\\w]+\\.)+(?:[a-zA-Z]*))(?::[\\d]{1,5})?";
    private static final String REGEX_URL_SHEMEURL="^(?:[a-zA-Z]*\\:\\/\\/|~\\/|\\/)?";

    public PathBuilder setWebUrl(String url) throws UrlShorteningFailureException {

        // UTF8 Encoding
        url = UTF8EncodeURL(url);
        checkValidUrl(url);
        this.shortUrl = new ShortUrl();
        this.shortUrl.setOriginUrl(url);
        return this;
    }

    public ShortUrl build(String source, int length) {
        shortUrl.setPath(shorten(source, length));
        return shortUrl;
    }

    public ShortUrl build(String source, String prefixPath, int length) {
        shortUrl.setPath(prefixPath + shorten(source, length));
        return shortUrl;
    }

    public String getPathGenerateSource() {
        return String.valueOf(new Date().getTime());
    }


    public void checkValidUrl(String url) throws UrlShorteningFailureException {
        // Check Scheme
        if (!url.matches(REGEX_SHEMEURL)) {
            log.debug("INVALID_SCHEME : {} ", url);
            throw new UrlShorteningFailureException.InvalidUrlException("올바른 SCHEME이 아닙니다.");
        }

        // Check invalid url string
        if (url.matches(REGEX_INVALID_URL_STRING)) {
            log.debug("INVALID_URL_STRING : {} ", url);
            throw new UrlShorteningFailureException.InvalidUrlException("URL의 허용되지 않는 STRING이 포함되어있습니다.");
        }

        if(isHttpUrl(url)) {
            checkInvalidHttpUrl(url);
        }

    }

    private boolean isHttpUrl(String url) {
        return url.matches(REGEX_HTTPURL);
    }

    private void checkInvalidHttpUrl(String url) throws UrlShorteningFailureException.InvalidUrlException {
        // Check URL
        if (!url.matches(REGEX_URL)) {
            log.debug("INVALID_URL : {} ", url);
            throw new UrlShorteningFailureException.InvalidUrlException("올바른 주소가 아닙니다.");
        }

        if(url.matches(REGEX_SHORTURL)) {
            log.debug("INVALID_NEXTERSME_URL : {} ", url);
            throw new UrlShorteningFailureException.InvalidUrlException("nexters.me는 줄일 수 없습니다.");
        }
    }

    public String shorten(String url, int length) {
        String shorten = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(url.getBytes());
            long md5 = new BigInteger(1, digest.digest()).longValue();
            String smd5 = convertTo62Base(Math.abs(md5));
            shorten = smd5.substring(0,length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return shorten;
    }

    private String convertTo62Base(long toBeConverted) {

        String[] elements = {
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                "p","q","r","s","t","u","v","w","x","y","z","1","2","3","4",
                "5","6","7","8","9","0","A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
                "Y","Z"
        };

        StringBuilder convertedString = new StringBuilder();
        int numOfDiffChars = elements.length;

        if(toBeConverted < numOfDiffChars + 1 && toBeConverted > 0) {
            convertedString.append(elements[(int) (toBeConverted - 1)]);
        }

        else if(toBeConverted > numOfDiffChars) {
            long mod = 0;
            long multiplier = 0;
            boolean determinedTheLength=false;
            for(int j=20; j>=0; j--) {
                multiplier=(long) (toBeConverted/Math.pow(numOfDiffChars,j));
                if(multiplier>0 && toBeConverted >= numOfDiffChars) {
                    convertedString.append(elements[(int) multiplier]);
                    determinedTheLength=true;
                }
                else if(determinedTheLength && multiplier==0) {
                    convertedString.append(elements[0]);
                }
                else if(toBeConverted < numOfDiffChars) {
                    convertedString.append(elements[(int) mod]);
                }

                mod=(long) (toBeConverted%Math.pow(numOfDiffChars,j));
                toBeConverted=mod;
            }

        }

        return convertedString.toString() + convertedString.toString();
    }

    private String convertHostLowerCase(String url) {
        Pattern patternScheme = Pattern.compile(REGEX_URL_SHEMEURL);
        Matcher matcherScheme = patternScheme.matcher(url);
        if (matcherScheme.find()) {
            url = matcherScheme.replaceFirst(matcherScheme.group().toLowerCase());
        }

        Pattern patternUrl = Pattern.compile(REGEX_URL_HOST);
        Matcher matcherUrl = patternUrl.matcher(url);
        if (matcherUrl.find()) {
            url = matcherUrl.replaceFirst(matcherUrl.group().toLowerCase());
        }
        return url;
    }

    public String UTF8EncodeURL(String longUrl) {

        if (longUrl.indexOf("://") <= 0) {
            longUrl = "http://" + longUrl;
        }

//        longUrl = decodeUrl(longUrl);

        // 호스트만 소문자로 바꿔준다.
        return convertHostLowerCase(longUrl);
    }

    private String decodeUrl(String longUrl) {
        try {
            longUrl = URLDecoder.decode(longUrl, "UTF-8");

            URL url = new URL(longUrl);
            longUrl = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), URLEncoder.encode(url.getQuery(), "UTF-8"), url.getRef()).toASCIIString();

            longUrl = longUrl
                    .replace("%21", "!")
                    .replace("%22", "\"")
                    .replace("%23", "#")
                    .replace("%24", "$")
                    .replace("%25", "%")
                    .replace("%26", "&")
                    .replace("%27", "\'")
                    .replace("%28", "(")
                    .replace("%29", ")")
                    .replace("%2A", "*")
                    .replace("%2B", "+")
                    .replace("%2C", ",")
                    .replace("%2D", "-")
                    .replace("%2E", ".")
                    .replace("%2F", "/")
                    .replace("%3A", ":")
                    .replace("%3B", ";")
                    .replace("%3C", "<")
                    .replace("%3D", "=")
                    .replace("%3E", ">")
                    .replace("%3F", "?")
                    .replace("%40", "@")
                    .replace("%5B", "[")
                    .replace("%5C", "\\")
                    .replace("%5D", "]")
                    .replace("%5E", "^")
                    .replace("%5F", "_")
                    .replace("%60", "`")
                    .replace("%7B", "{")
                    .replace("%7C", "|")
                    .replace("%7D", "}")
                    .replace("%7E", "~");
        } catch (URISyntaxException | MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return longUrl;
    }
}
