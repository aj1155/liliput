package me.liliput.api.util.builder.exception;

/**
 * Created by 1002731 on 2017. 1. 4..
 * Email : eenan@sk.com
 */
public class UrlShorteningFailureException extends BusinessException {

    public UrlShorteningFailureException(String message) {
        super(message);
    }


    public static CustomPathIsAlreadyInUseException customPathIsAlreadyInUse() {
        return new CustomPathIsAlreadyInUseException();
    }

    public static WebUrlIsAlreadyInUseException webUrlIsAlreadyInUseException() {
        return new WebUrlIsAlreadyInUseException();
    }

    public static AndroidStoreNeedAppUrlException androidStoreNeedAppUrlException() {
        return new AndroidStoreNeedAppUrlException();
    }

    public static AppStoreNeedAppUrlException appStoreNeedAppUrlException() {
        return new AppStoreNeedAppUrlException();
    }

    public static InvalidAppUrlException invalidAppUrlException() {
        return new InvalidAppUrlException();
    }

    public static class WebUrlIsAlreadyInUseException extends UrlShorteningFailureException {

        public WebUrlIsAlreadyInUseException() {
            super("WebUrl is already in use.");
        }
    }



    public static class InvalidUrlException extends UrlShorteningFailureException {

        public InvalidUrlException(String message) {
            super(message);
        }

    }

    public static class CustomPathIsAlreadyInUseException extends UrlShorteningFailureException {

        public CustomPathIsAlreadyInUseException() {
            super("customPath is already in use.");
        }

    }

    public static class AndroidStoreNeedAppUrlException extends UrlShorteningFailureException {
        public AndroidStoreNeedAppUrlException() {
            super("Need Android url");
        }
    }

    public static class AppStoreNeedAppUrlException extends UrlShorteningFailureException {
        public AppStoreNeedAppUrlException() {
            super("Need iOS url");
        }
    }

    public static class InvalidAppUrlException extends UrlShorteningFailureException {
        public InvalidAppUrlException() {
            super("Invalid App Url");
        }
    }

}