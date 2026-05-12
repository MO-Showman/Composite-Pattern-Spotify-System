# 🎵 Spotify Playlist System - Composite Design Pattern (Case 2)

## 📌 Project Overview
This project is part of the **Design Patterns Course (Case 2)**. It demonstrates the application of the **Composite Design Pattern** to solve a real-world software architecture problem related to hierarchical data structures, specifically building a Spotify-like Playlist System.

---

## 🛑 1. Problem Analysis (The Challenge)
In modern music applications like Spotify, users can create **Playlists**. A playlist can contain individual **Songs**, but it can also contain **Nested Playlists** (e.g., a "90s Music" folder containing "Rock" and "Pop" playlists). 

**The Design Challenge:** If we want to calculate the total duration or simply `play()` a playlist, the system must iterate through all elements. Without a proper design pattern, developers would write complex `if-else` statements to check the type of each element (Is it a single song? Or a playlist folder?). We need a way to treat individual songs and playlist folders uniformly.

---

## ⚖️ 2. Trade-offs: Composite vs. Flyweight
Before selecting the pattern, we evaluated two structural patterns:

* **Flyweight Pattern:** Focuses on minimizing memory usage by sharing as much data as possible among similar objects. 
  * *Trade-off:* It does not solve the hierarchical "Tree" structure problem. Implementing it here would add unnecessary complexity without addressing the core requirement of nested playlists.
* **Composite Pattern:** Focuses on composing objects into tree structures to represent part-whole hierarchies.
  * *Trade-off:* It perfectly solves our problem by allowing the client to treat individual objects (Songs) and compositions of objects (Playlists) uniformly.

---

## ✅ 3. Pattern Selection & Justification
**Selected Pattern: Composite Pattern**
* **Why it fits:** The playlist system is fundamentally a **Tree Structure** (Part-Whole Hierarchy). The Composite pattern provides a unified interface (`Playable`) for both the `Leaf` (Song) and the `Composite` (Playlist). 
* **Design Principle Applied:** It adheres to the **Open/Closed Principle** (we can add new types of playable components without changing existing code) and simplifies the client code significantly.

---

## 🗂️ 4. Project Deliverables
* 💻 **Source Code:** Contains the Java implementation of the Component, Leaf, Composite, and Client.
* 📊 **UML Diagram:** Visual representation of the Composite tree structure.
* 📋 **Project Management Board:** [Link to your GitHub Board here]
* 🎥 **Presentation & Video:** Detailed explanation of the trade-offs and code execution.

---

## 🛠️ 5. How to Run
1. Clone the repository.
2. Open the project in your preferred Java IDE (NetBeans, IntelliJ, Eclipse).
3. Run the `SpotifyApp.java` main class to see the uniform execution of nested playlists.
