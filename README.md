# Online Test – Java Swing Quiz Application

A simple desktop quiz application built with **Java Swing (AWT + Swing)** that presents 10 multiple-choice Java questions, one at a time, with a bookmarking/review feature.

## Features

- **10 fixed multiple-choice questions** on core Java concepts (datatypes, `Object` class, packages, keywords, Swing components, etc.)
- **Single-select radio buttons** per question, grouped using `ButtonGroup`
- **Next** button to move sequentially through questions and record the score
- **Bookmark** button to flag the current question for later review — it:
  - Adds a numbered "BookmarkN" button to the window
  - Records the bookmarked question's index
  - Advances to the next question
- **Review mode** — clicking a bookmark button jumps back to that bookmarked question; after answering it, the app returns to where you left off, and the bookmark button is disabled
- **Result** — once all 10 questions are done, the **Bookmark** button becomes a **Result** button, showing your final correct-answer count in a popup dialog

## Requirements

- Java Development Kit (JDK) 8 or later
- No external libraries — uses only `java.awt`, `java.awt.event`, and `javax.swing`

## How to Compile & Run

```bash
javac OnlineTest.java
java OnlineTest
```

A window titled **"Online Test Of Java"** will open (600×350, positioned at 250,100).

## File Structure

```
OnlineTest.java   → Single-file application (UI + logic combined)
```

## Class Overview

| Component | Purpose |
|---|---|
| `OnlineTest` | Main `JFrame` class; builds the UI and handles events via `ActionListener` |
| `set()` | Loads the label text and answer options for the current question index |
| `check()` | Validates whether the currently selected radio button is the correct answer |
| `actionPerformed()` | Handles Next, Bookmark, dynamic Bookmark-N, and Result button clicks |

## Known Limitations

- Questions and answers are **hardcoded** (not loaded from a file or database)
- Uses `null` layout with manually set pixel bounds — not responsive to window resizing
- No input validation preventing skipping a question without selecting an answer
- Bookmark buttons are placed with a fixed offset (`480, 20 + 30*x`) and can overflow the window if many questions are bookmarked
- Exiting via the Result dialog calls `System.exit(0)` directly

## Possible Improvements

- Load questions from an external file (JSON/CSV) instead of hardcoding
- Use `GridBagLayout` or a modern layout manager for responsiveness
- Add a timer/countdown for the test
- Persist bookmarks and results between sessions
- Migrate to JavaFX for a more modern UI
