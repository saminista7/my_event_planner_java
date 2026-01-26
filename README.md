# My Event Planner (Java Event Management System)

My Event Planner is a Java based Desktop event management application designed for professional event management agencies to manage client events, resources, and schedules through a centralized, user-friendly system.

The application focuses on real-world domain modeling, database-driven workflows, and interactive user interfaces, and was developed as part of an undergraduate software development project.

---

## Overview
The system enables event management agencies to store, manage, and manipulate client event information digitally instead of relying on manual record keeping. Agencies can register events, assign resources, manage schedules, and perform advanced searches and filtering using a structured database-backed application.

The application emphasizes usability, data integrity, and modular object-oriented design.

---

## Core Functionality
-jFrame for a friendly UI experience
- Client event registration with date selection using **JCalendar**
- Event scheduling with start date, duration, and metadata
- Assignment of resources such as musicians, themes, and services
- Interactive dashboards for managing all entities
- Full CRUD (Create, Read, Update, Delete) operations for:
  - Events
  - Musicians
  - Themes
  - Associated services
- Advanced filtering and search by:
  - Event date
  - Client name
  - Event ID
- Centralized dashboard aggregating all event-related components

---

## System Design
The application follows an object-oriented design where each real-world entity is modeled as a separate Java class. Examples include:
- Event
- Musician
- Theme
- Client
- Agency dashboard components

Each entity maintains its own attributes (e.g., name, cost, duration) and database operations, and all components are integrated into a final dashboard-driven workflow.

---

## Database & Querying
- Relational database used for persistent storage
- Complex SQL queries written manually to support:
  - Multi-criteria filtering
  - Record searching and sorting
  - CRUD operations across multiple entities
- Strong focus on data consistency and query efficiency

---

## UI/ UX
- Desktop-based Java UI
- Interactive forms for data input and editing
- Date selection via JCalendar
- Clean and structured dashboards for agency users
- Designed with usability and clarity in mind

---

## Technologies Used
- **Language:** Java
- **UI:** Java Swing / AWT, jFrame (with JCalendar integration)
- **Database:** SQL-based relational database
- **Architecture:** Object-Oriented Design
- **IDE:** Java-compatible IDE

---

## Academic Context
This project was developed as part of an undergraduate **Software Development / Database Systems** course and demonstrates practical application of Java programming, database integration, and system design principles.

---

## Notes
This repository is maintained for academic reference and demonstration purposes. While not production-deployed, the system reflects a realistic event management workflow used by professional agencies.
