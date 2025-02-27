package com.reajason.javaweb.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

/**
 * @author ReaJason
 */
public class CommonUtil {
    public static byte[] gzipCompress(byte[] data) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(data);
        }
        return out.toByteArray();
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private static final String[] PACKAGE_NAMES = {
            "org.springframework",
            "org.apache.commons",
            "org.apache.logging",
            "org.apache",
            "com.fasterxml.jackson",
            "org.junit",
            "org.apache.commons.lang",
            "org.apache.http.client",
            "com.google.gso",
            "ch.qos.logback"
    };

    private static String getRandomPackageName() {
        return PACKAGE_NAMES[new Random().nextInt(PACKAGE_NAMES.length)] + "." + getRandomString(5);
    }

    public static String generateShellClassName() {
        return getRandomPackageName() + ".ErrorHandler";
    }

    public static final String[] INJECTOR_CLASS_NAMES = new String[]{"SignatureUtils", "NetworkUtils", "KeyUtils", "EncryptionUtils", "SessionDataUtil", "SOAPUtils", "ReflectUtil", "HttpClientUtil", "EncryptionUtil", "XMLUtil", "JSONUtil", "FileUtils", "DateUtil", "StringUtil", "MathUtil", "HttpUtil", "CSVUtil", "ImageUtil", "ThreadUtil", "ReportUtil", "EncodingUtil", "ConfigurationUtil", "HTMLUtil", "SerializationUtil"};

    public static String generateInjectorClassName() {
        return getRandomPackageName() + "." + INJECTOR_CLASS_NAMES[new Random().nextInt(INJECTOR_CLASS_NAMES.length)];
    }
}
