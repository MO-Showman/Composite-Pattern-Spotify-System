# C2: Problem Analysis & Trade-off Report

## 1. The Real-World Software Problem
In the context of a modern music streaming platform (like Spotify), the system must handle the creation and execution of highly hierarchical audio collections. The user's library consists of:
* **Individual Items:** Single `Song` or track objects.
* **Collections (Compositions):** A `Playlist` that contains multiple songs, or even **Nested Playlist Folders** (e.g., a "Favorites" folder containing a "Rock" playlist, a "Pop" playlist, and some individual songs).

## 2. Design Challenges
The primary challenge is managing structural complexity when executing common operations (like `play()` or calculating total `duration`) across a nested, tree-like data structure. 

If standard iteration and type-checking are used, it leads to **Tight Coupling and Conditional Complexity**. The developer is forced to write messy recursive loops to determine the type of the object before acting on it. Alternatively, ignoring a unified design results in code that is:
* **Unmaintainable:** `if (item instanceof Song) { item.play(); } else if (item instanceof Playlist) { iterateAndPlay(item); }`
* **Violating the Open/Closed Principle:** Adding a new playable type (e.g., `Podcast` or `Audiobook`) requires modifying the core playback logic everywhere in the system to add new `if-else` branches.

## 3. Comparing Design Approaches (Trade-offs)
To resolve this structural complexity, we evaluate two patterns from Case 2: **Flyweight** and **Composite**.

### Option A: Flyweight Pattern
* **Purpose:** Minimizes memory usage by sharing as much data as possible among similar objects.
* **Pros:** Excellent if the system needed to load millions of identical track objects, allowing the separation of intrinsic state (audio data) from extrinsic state (user's playlist position).
* **Cons:** It completely ignores the structural "Tree" problem. It does not provide a mechanism to treat individual items and collections uniformly. We would still face the severe `if-else` complexity when iterating through nested playlists.

### Option B: Composite Pattern (Selected)
* **Purpose:** Composes objects into tree structures to represent part-whole hierarchies.
* **Pros:** Solves the conditional complexity by providing a unified interface (`Playable`). It allows the client code to treat a single song and a complex nested playlist exactly the same way. The client simply calls `play()` without caring about the underlying structure.
* **Cons:** It can make the design overly general. For example, if we want to restrict a specific playlist to *only* contain songs and not other folders, the Composite pattern makes it harder to enforce such rules at compile-time.

## 4. Conclusion
While the Flyweight pattern optimizes memory consumption, the primary design challenge here is managing structural hierarchy and executing uniform operations across nested elements. Therefore, the **Composite Pattern** is the superior solution to eliminate type-checking bloat and provide a clean, maintainable, and scalable API for audio playback.
