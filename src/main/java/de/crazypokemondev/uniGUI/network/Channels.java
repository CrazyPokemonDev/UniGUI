package de.crazypokemondev.uniGUI.network;

import lombok.Getter;

@Getter
public enum Channels {
    UNIGUI_MAIN("unigui:main");

    private final String id;

    Channels(String id) {
        this.id = id;
    }
}
