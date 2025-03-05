package me.a8kj.wizardscrapper.document;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

@RequiredArgsConstructor
@Getter
public abstract class SiteDocument {

    private @NonNull final String url;
    private Document document;

    public enum ConnectionResult {
        FAILED, SUCCESS
    }

    public void connect() {
        try {
            document = Jsoup.connect(url).get();
            onConnect(this, ConnectionResult.SUCCESS);
        } catch (IOException e) {
            onConnect(this, ConnectionResult.FAILED);
        }
    }

    protected abstract void onConnect(SiteDocument document, ConnectionResult result);
}
