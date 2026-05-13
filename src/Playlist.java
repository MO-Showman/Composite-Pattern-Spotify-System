
package com.mycompany.spotifyapp;

import java.util.ArrayList;
import java.util.List;


public class Playlist implements Playable {
    private String playlistName;
    // Here is the aggregation: maintaining a list of children
    private List<Playable> components = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public void add(Playable component) {
        components.add(component);
    }

    public void remove(Playable component) {
        components.remove(component);
    }

    @Override
    public void play() {
        System.out.println("\n --- Opening Playlist: " + playlistName + " ---");
        // Uniformly treating both Leaf (Song) and Composite (Playlist)
        for (Playable component : components) {
            component.play(); 
        }
    }

    @Override
    public String getName() {
        return this.playlistName;
    }
}
