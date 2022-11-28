package org.example.model;

public enum ROT13 {
    CYPHER("abcdefghijklmnopqrstuvwxyz");

    public final String hash;
    private ROT13(String hash) {
        this.hash = hash;
    }

}
