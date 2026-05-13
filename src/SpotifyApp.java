
package com.mycompany.spotifyapp;

public class SpotifyApp {
    public static void main(String[] args) {
        // 1. Create individual songs (Leaves)
        Song song1 = new Song("Shape of You", "Ed Sheeran");
        Song song2 = new Song("Blinding Lights", "The Weeknd");
        Song song3 = new Song("Hotel California", "Eagles");
        Song song4 = new Song("Bohemian Rhapsody", "Queen");
        Song song5 = new Song("Perfect", "Ed Sheeran");

        // 2. Create a basic playlist and add songs to it
        Playlist popPlaylist = new Playlist("Pop Hits");
        popPlaylist.add(song1);
        popPlaylist.add(song2);

        // 3. Create another basic playlist
        Playlist rockPlaylist = new Playlist("Classic Rock");
        rockPlaylist.add(song3);
        rockPlaylist.add(song4);

        // 4. Create a Master Playlist (Nested Folders / Composite of Composites)
        Playlist myFavorites = new Playlist("My Favorites 2024");
        myFavorites.add(popPlaylist);   // Adding a playlist
        myFavorites.add(rockPlaylist);  // Adding a playlist
        myFavorites.add(song5);         // Adding an individual song directly to the master folder

        // 5. Execute the system uniformly
        System.out.println("️ SYSTEM START: Playing the Master Playlist...");
        // The client simply calls play() once, and the Composite pattern handles the rest!
        myFavorites.play();
    }
}
