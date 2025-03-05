package me.a8kj.wizardscrapper.structure.container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StringContainer implements Container<String> {
    private String content;
}
