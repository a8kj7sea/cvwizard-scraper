package me.a8kj.wizardscrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.net.URISyntaxException;
import com.convertapi.client.Config;
import com.convertapi.client.ConvertApi;
import com.convertapi.client.Param;
import me.a8kj.wizardscrapper.document.SiteDocument;
import me.a8kj.wizardscrapper.document.impl.WizardCVDocument;

public class WizardScraperApp {
    public static void main(String[] args)
            throws URISyntaxException, IOException, InterruptedException, ExecutionException {

        if (args.length != 2) {
            System.err.println(
                    "Incorrect usage. Please provide a URL and a secret key as arguments. Example: java -jar <jar-file> <url> <secret-key>");
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

        SiteDocument document = new WizardCVDocument(url);
        document.connect();

        Config.setDefaultSecret(secretKey);

        Path outputDir = Paths.get("output");

        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }

        Path inputFile = Paths.get("index.html");

        ConvertApi.convert("html", "pdf",
                new Param("File", inputFile),
                new Param("PageRange", "1-8"),
                new Param("FileName", "resume"),
                new Param("AdBlock", "true"),
                new Param("FixedElements", "relative"),
                new Param("RespectViewport", "false"),
                new Param("Scale", ""),
                new Param("PageSize", "a4"),
                new Param("MarginBottom", "0")).get().saveFilesSync(outputDir);

        Files.delete(inputFile);

        System.out.println("DONE GOODBYE!");
    }

    public static boolean isValidSecretKey(String secretKey) {
        return secretKey != null && !secretKey.isEmpty();
    }
}
