# 🎵 Spotify Playlist System - Design Patterns Project

## 📌 Project Overview
This project is developed as part of the **Design Patterns Course (Case 2)**. The main objective is to analyze a real-world software problem, compare design approaches, and implement a suitable design pattern. 

**Selected Pattern:** Composite Pattern (Structural)

## 🎯 The Real-World Problem
In modern music applications like Spotify, creating a playlist system involves complex hierarchical data structures. A `Playlist` can contain individual `Song` objects, but it can also contain nested `Playlist` folders (e.g., a "Favorites" folder containing "Rock" and "Pop" playlists). Without a proper design pattern, executing an action like `play()` requires complex type-checking and `if-else` statements to differentiate between a single song and a playlist folder, making the code rigid and hard to maintain.

## 🛠️ The Solution (Composite Pattern)
To solve this structural complexity, we implemented the **Composite Design Pattern**. It composes objects into tree structures to represent part-whole hierarchies. By providing a unified `Playable` interface, the pattern allows the client code to treat individual objects (`Song`) and compositions of objects (`Playlist`) uniformly. This eliminates the need for type-checking and makes the system highly scalable.

## 📂 Project Deliverables
- 📝 **[Problem Analysis & Trade-offs](#)**
- 🎯 **[Pattern Selection & Justification](#)**
- 📊 **[UML Class Diagram](#)**
- 💻 **[Source Code Implementation](#)**
- 📄 **[Presentation Slides (PDF)](#)**
- 🎬 **[Presentation Video (Watch Here)](#)**
- 📋 **[Project Management Board (Kanban)](#)**

## 👨‍💻 Authors
- **Names:** [ Mohammad shoman , Ibrahim Al-Balawi ,Ahmed Al-Ajmi ]
- **Role:** Full Project Implementation & Design
