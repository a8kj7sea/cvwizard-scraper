package me.a8kj.wizardscrapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import com.convertapi.client.ConvertApi;

import me.a8kj.wizardscrapper.document.SiteDocument;
import me.a8kj.wizardscrapper.document.impl.WizardCVDocument;

public class App {
    public static void main(String[] args)
            throws URISyntaxException, InterruptedException, ExecutionException, IOException {

        final String jarFileName = new java.io.File(
                App.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                .getName();

        if (args.length != 2) {
            System.err.println(
                    "Incorrect usage. Please provide a URL and a secret key as arguments. Example: java -jar " +
                            jarFileName
                            + " <url> <secret-key>");
            System.exit(0);
            return;
        }

        String url = args[0];
        String secretKey = args[1];

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("The URL cannot be null or empty.");
        }

        if (!isValidSecretKey(secretKey)) {
            System.err.println("Invalid secret key format. Please provide a valid secret key.");
            System.exit(1);
            return;
        }

        System.out.println("Secret key validated successfully.");

        SiteDocument document = new WizardCVDocument(url);
        document.connect();

        ConvertApi.convertFile("index.html", "output.pdf", secretKey);
    }

    public static boolean isValidSecretKey(String secretKey) {
        if (secretKey == null || secretKey.isEmpty()) {
            return false;
        }
        return secretKey.length() == 24;
    }
}
