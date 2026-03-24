# Traffic Signs Clustering System

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

# Requirements

Please install before starting:

* Java 17
* Node.js (inkl. npm)
* Docker Desktop

---

# Project structure

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

# start Project (lokal)

## 1️⃣ start Database (Docker)

In Projekt-Root:

```bash
cd docker
docker compose up -d
```

Check if the container is running:

```bash
docker ps
```

---

## 2️⃣ start Backend (Spring Boot)

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

Backend runs on:

```
http://localhost:8080
```

---

## 3️⃣ start Frontend (React + TypeScript)

```bash
cd frontend
npm install
npm run dev
```

The frontend typically runs on:

```
http://localhost:5173
```

---

# import Data (CSV → DB)

In a new terminal at the project root:

```bash
cd scripts/import-sign-data
npm install
node index.js
```

The script sends observations to:

```
POST http://localhost:8080/api/observations
```

---

# API Endpoints

### Number of observations

```
GET /api/observations/count
```

---

### Delete all observations

```
DELETE /api/observations
```

---

### Calculate clusters

```
GET /api/observations/clusters?r=30
```

---

### Clusters near a location

```
GET /api/observations/clusters/nearby
    ?lat=<latitude>
    &lon=<longitude>
    &radius=200
    &r=30
```

---

# Database reset

## Complete database reset (including volume)

```bash
cd docker
docker compose down -v
docker compose up -d
```

---

# Notes

* Observations are stored persistently in PostgreSQL.
* Clusters are calculated at runtime.
* Docker Compose enables a reproducible local environment.
* Backend uses Spring Data JPA.
* The frontend communicates with the backend via REST.

---
