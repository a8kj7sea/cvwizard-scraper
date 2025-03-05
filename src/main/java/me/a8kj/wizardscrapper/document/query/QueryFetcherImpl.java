package me.a8kj.wizardscrapper.document.query;

import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import me.a8kj.wizardscrapper.document.SiteDocument;
import me.a8kj.wizardscrapper.elements.CSSQuery;
import me.a8kj.wizardscrapper.structure.container.Container;
import me.a8kj.wizardscrapper.structure.container.StringContainer;


public class QueryFetcherImpl implements QueryFetcher {

    @Override
    public Container<String> fetch(CSSQuery cssQuery, SiteDocument siteDocument) {
        Document document = siteDocument.getDocument();
        Elements divs = document.select(cssQuery.getQuery());

        if (divs.isEmpty())
            return null;


        String result = divs.stream()
                            .map(Element::outerHtml)
                            .collect(Collectors.joining());


        return new StringContainer(result);
    }
}
