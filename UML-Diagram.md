

```mermaid
classDiagram
    direction TB

    class Playable {
        <<interface>>
        +play() void
        +getName() String
    }

    class Song {
        -title: String
        -artist: String
        +Song(title: String, artist: String)
        +play() void
        +getName() String
    }

    class Playlist {
        -playlistName: String
        -components: List~Playable~
        +Playlist(playlistName: String)
        +add(component: Playable) void
        +remove(component: Playable) void
        +play() void
        +getName() String
    }

    class SpotifyApp {
        +main(args: String[]) void
    }

    %% Relationships
    Playable <|.. Song : Implements
    Playable <|.. Playlist : Implements
    Playlist o-- Playable : Aggregates (Children)
    SpotifyApp ..> Playable : Uses
