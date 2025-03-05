package me.a8kj.wizardscrapper.document.query;

import me.a8kj.wizardscrapper.document.SiteDocument;
import me.a8kj.wizardscrapper.elements.CSSQuery;
import me.a8kj.wizardscrapper.structure.container.Container;

public interface QueryFetcher {

    Container<String> fetch(CSSQuery cssQuery, SiteDocument document);
}
