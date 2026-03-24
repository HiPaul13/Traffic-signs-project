# 🚗 Traffic Signs Clustering System

Backend-driven system for processing and clustering traffic sign observations based on geographic data.

The system imports raw observations (latitude, longitude, sign type) and groups them into clusters to approximate real-world traffic signs.

---

## Idea

Traffic sign observations often come from multiple sources and may contain duplicates or noise.  
This project processes raw observation data and clusters nearby points to identify actual traffic signs.

Focus: **data processing, backend architecture & geospatial clustering**

---

## Features

- Import of observation data via script (CSV → REST API → Database)
- Clustering of geo-based data points using configurable radius (**r**)
- Detection of traffic sign clusters from raw observations
- REST API for querying clusters and observations
- Dockerized PostgreSQL setup
- Lightweight frontend for visualization

---

## Architecture

- **Backend:** Spring Boot (Java 17)
- **Frontend:** React + TypeScript (Vite)
- **Database:** PostgreSQL (Docker)
- **Import:** Node.js script (data ingestion pipeline)

➡️ Clear separation between data ingestion, processing, and visualization

---

## Tech Stack

* **Backend:** Spring Boot (Java 17)
* **Frontend:** React + TypeScript (Vite)
* **Datenbank:** PostgreSQL (Docker Compose)
* **Import:** Node.js Script (CSV → REST → DB)

---

# Voraussetzungen

Bitte vor dem Start installieren:

* Java 17
* Node.js (inkl. npm)
* Docker Desktop

---

# Projektstruktur

```
Traffic-signs-project/
│
├── backend/                                Spring Boot Backend
├── frontend/                               React TypeScript Frontend
├── docker/                                 docker-compose.yml (PostgreSQL)
├── scripts/import-sign-data/index.js       Import Script (CSV → Backend)
└── README.md
```

---

# Projekt starten (lokal)

## 1️⃣ Datenbank starten (Docker)

Im Projekt-Root:

```bash
cd docker
docker compose up -d
```

Prüfen ob Container läuft:

```bash
docker ps
```

---

## 2️⃣ Backend starten (Spring Boot)

### Windows (PowerShell)

```bash
cd backend
.\mvnw.cmd clean spring-boot:run
```

### macOS / Linux

```bash
cd backend
./mvnw clean spring-boot:run
```

Backend läuft auf:

```
http://localhost:8080
```

---

## 3️⃣ Frontend starten (React + TypeScript)

```bash
cd frontend
npm install
npm run dev
```

Frontend läuft typischerweise auf:

```
http://localhost:5173
```

---

# Daten importieren (CSV → DB)

In neuem Terminal im Projekt-Root:

```bash
cd scripts/import-sign-data
npm install
node index.js
```

Das Script sendet Observations an:

```
POST http://localhost:8080/api/observations
```

---

# API Endpoints

### Anzahl Observations

```
GET /api/observations/count
```

---

### Alle Observations löschen

```
DELETE /api/observations
```

---

### Cluster berechnen

```
GET /api/observations/clusters?r=30
```

---

### Cluster in der Nähe einer Position

```
GET /api/observations/clusters/nearby
    ?lat=<latitude>
    &lon=<longitude>
    &radius=200
    &r=30
```

---

# Datenbank reset

## Kompletten DB Reset (inkl. Volume)

```bash
cd docker
docker compose down -v
docker compose up -d
```

---

# Hinweise

* Observations werden persistent in PostgreSQL gespeichert.
* Cluster werden zur Laufzeit berechnet.
* Docker Compose ermöglicht reproduzierbare lokale Umgebung.
* Backend nutzt Spring Data JPA.
* Frontend kommuniziert über REST mit Backend.

---
