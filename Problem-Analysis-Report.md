# 📝 Problem Analysis & Trade-offs Report
**Case Study 2: Spotify Playlist System**

---

## 1. Real-World Software Problem
In modern music streaming applications like **Spotify** or **Apple Music**, users interact with audio content through a highly hierarchical structure. A user can create a **Playlist** that contains individual **Songs**. Furthermore, the system allows creating **Playlist Folders** (Nested Playlists), which means a playlist can contain other sub-playlists alongside individual songs (e.g., A "My Favorites 2024" folder containing a "Pop" playlist, a "Rock" playlist, and a single track).

## 2. Main Design Challenges
When designing the architecture for this system, the primary challenge is **Structural Complexity and Uniformity**:
* **Complex Type-Checking:** If a user clicks `play()` on a folder, the system must iterate through its contents. Without a proper design, the code would require complex `if-else` or `instanceof` checks to determine if the current item is a `Song` (which just plays) or a `Playlist` (which needs further iteration).
* **Code Duplication & Maintenance:** Writing separate logic to handle individual songs versus collections of songs violates the **Open/Closed Principle**. Adding a new type of playable item (e.g., an "Audiobook" or "Podcast") would require modifying the core logic everywhere.
* **The "Part-Whole" Hierarchy:** The system needs a way to represent a tree structure where a folder is a "Whole" and a song is a "Part," but both need to respond to the same commands (like `play()`, `getSize()`, or `getDuration()`).

---

## 3. Comparing Possible Design Patterns (Trade-offs)
To solve this problem, we analyzed two Structural Design Patterns: **Flyweight** and **Composite**.

### Option A: Flyweight Pattern
The Flyweight pattern is used to minimize memory usage or computational expenses by sharing as much as possible with related objects.
* **How it works here:** It would separate intrinsic state (e.g., song title, artist) from extrinsic state (e.g., user's specific volume or playlist position) and cache the song objects.
* **Trade-offs:**
  * **Pros:** Highly effective if the system creates millions of identical song objects, saving RAM.
  * **Cons:** It completely **fails** to solve the structural hierarchy problem. Flyweight does not provide a way to treat single objects and collections of objects uniformly. Implementing it would add massive complexity (Factory classes, caching) without fixing the `if-else` nightmare when iterating through nested playlists.

### Option B: Composite Pattern (Selected)
The Composite pattern is used to compose objects into tree structures to represent part-whole hierarchies.
* **How it works here:** We create a common interface (`Playable`). The `Song` class implements it as a **Leaf** (no children), and the `Playlist` class implements it as a **Composite** (contains children of type `Playable`).
* **Trade-offs:**
  * **Pros:** Elegantly solves the hierarchy problem. The client code can simply call `item.play()` without caring whether the item is a single song or a massive playlist folder. It eliminates type-checking and makes the system highly scalable.
  * **Cons:** It can make the design overly general. For example, if we want to restrict a specific playlist to *only* contain songs and not other playlists, the Composite pattern makes it harder to enforce such rules at compile-time.

---

## 4. Conclusion
Given that the primary challenge is managing a nested, tree-like data structure and executing uniform operations across its elements, the **Flyweight Pattern** is discarded as it addresses memory optimization rather than structural hierarchy. The **Composite Pattern** is the perfect fit, as it simplifies the client code and naturally represents the Spotify Playlist architecture.
