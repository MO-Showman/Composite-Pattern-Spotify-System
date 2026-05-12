# C2: Design Pattern Justification Document

## 1. Selected Design Pattern
The selected pattern for the Spotify Playlist System is the **Composite Design Pattern**, which falls under the category of Structural Design Patterns.

## 2. Why it Fits the Identified Problem
The Composite pattern is perfectly suited for this scenario because:
* **Handles Tree Structures:** A playlist system is naturally a tree structure, consisting of individual items (Songs) and collections (Playlist Folders). The Composite pattern is specifically designed to represent "part-whole" hierarchies.
* **Uniform Treatment:** It provides a common interface (`Playable`), allowing the system to treat an individual `Song` (Leaf) and a nested `Playlist` (Composite) exactly the same way.
* **Eliminates Conditional Complexity:** When executing a command like `play()`, the client does not need to write complex type-checking code (e.g., `if (item instanceof Song)`) to figure out how to process the object. The pattern handles the recursive iteration automatically.

## 3. Reasoning Based on Design Principles
The selection of the Composite pattern is heavily supported by core object-oriented design principles (SOLID):

### A. Open/Closed Principle (OCP)
The system is open for extension but closed for modification. If the streaming platform decides to introduce a new playable format (e.g., a `PodcastEpisode` or `Audiobook`), we simply create a new class that implements the `Playable` interface. We **do not** need to modify the existing `Playlist` container class or the client execution code.

### B. Dependency Inversion Principle (DIP)
The client code (e.g., the Main execution class or the media player API) does not depend on concrete implementations like `Song` or `Playlist`. Instead, it depends entirely on the abstract `Playable` interface. This decoupling significantly reduces the complexity of the client code.

### C. Liskov Substitution Principle (LSP)
Because both the `Song` class and the `Playlist` class implement the same `Playable` interface, the client can seamlessly substitute a single audio track with a massive nested playlist folder without breaking the application logic. The application will execute `.play()` flawlessly regardless of the underlying object's complexity.
