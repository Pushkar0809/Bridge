package org.bridge.bridgeEnums;

public enum Environment {

    DEV("https://dev-bridge.bloomhotels.in/"),
    QA("https://qa-bridge.bloomhotels.in/");
//    PROD("https://bridge.bloomhotels.in/");

    private final String url;

    Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static Environment fromString(String env) {
        for (Environment environment : values()) {
            if (environment.name().equalsIgnoreCase(env)) {
                return environment;
            }
        }
        return DEV; // default environment
    }
}