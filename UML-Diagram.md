# 📊 C2: UML Class Diagram

## Composite Design Pattern - Spotify Playlist System

This UML class diagram illustrates the implementation of the **Composite Pattern** based on standard GoF design principles, perfectly matching our Spotify Playlist scenario.

### 🏛️ Architecture Breakdown:
1. **Component (`Playable` Interface):** Declares the common operations for both simple and complex objects in the composition.
2. **Leaf (`Song`):** Represents individual objects in the composition. A leaf has no children.
3. **Composite (`Playlist`):** Represents complex components that may have children. It implements the component interface and maintains a collection of child components (`List<Playable>`).
4. **Client (`SpotifyApp`):** Manipulates objects in the composition through the `Playable` interface.

---

### 📈 The Class Diagram

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
