package com.saucedemo.automation.web.util;

/**
 * Small utility to centralize access to runtime configuration used in tests.
 * Reads `base.url` from system properties (populated by Serenity from serenity.conf)
 * and provides a single place to change the default value if needed.
 */
public final class AppConfig {

    private AppConfig() {}

    public static String baseUrl() {
        return System.getProperty("base.url", "https://www.saucedemo.com/");
    }
}

