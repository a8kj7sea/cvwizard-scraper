package me.a8kj.wizardscrapper.document.impl;

import java.nio.file.Path;

import lombok.NonNull;
import me.a8kj.wizardscrapper.document.SiteDocument;
import me.a8kj.wizardscrapper.document.query.QueryFetcher;
import me.a8kj.wizardscrapper.document.query.QueryFetcherImpl;
import me.a8kj.wizardscrapper.elements.CSSQuery;
import me.a8kj.wizardscrapper.file.File;
import me.a8kj.wizardscrapper.file.FileImpl;
import me.a8kj.wizardscrapper.file.services.FileWriteService;
import me.a8kj.wizardscrapper.structure.container.Container;

public class WizardCVDocument extends SiteDocument {

    public WizardCVDocument(@NonNull String url) {
        super(url);
    }

    @Override
    protected void onConnect(SiteDocument siteDocument, ConnectionResult result) {

        if (result == ConnectionResult.FAILED)
            throw new IllegalAccessError("Cannot connect to site!");

        QueryFetcher queryFetcher = new QueryFetcherImpl();

        Container<String> container = queryFetcher.fetch(new CSSQuery() {
            @Override
            public String getQuery() {
                return "div.relative";
            }
        }, siteDocument);

        if (container == null)
            throw new IllegalAccessError("Failed to fetch HTML lines!");

        if (container.getContent() == null || container.getContent().isEmpty()) {
            throw new IllegalStateException("Fetched content is empty or null!");
        }

        File file = new FileImpl(Path.of("index.html"));

        StringBuffer buffer = new StringBuffer();
        buffer.append("<!DOCTYPE html> <html>\n\n<body>");
        buffer.append(container.getContent());
        buffer.append("\n</body>\n</html>");

        file.serve(new FileWriteService(buffer.toString()));
    }
}
