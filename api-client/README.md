# API Client Dashboard (Vite + React)

This repository contains **React frontend** built using **Vite + React** that consumes three REST APIs provided by a Spring Boot backend.  
The application focuses on clarity, correctness, and a professional UI while keeping the codebase simple and maintainable.

---

## Features

- Calculate the number of days between two dates
- Convert numbers into words
- Fetch temperature statistics for Dhaka
- Clean and responsive UI
- Direct API integration using Fetch

---

## Backend APIs

 Feature           | Endpoint                           | Method 
-------------------|------------------------------------|--------
 Number of Days    | `/api/number-of-days`              | POST   
 Number to Words   | `/api/number-to-words`             | POST   
 Temperature Stats | `/api/temperature-stats-for-dhaka` | POST   

**Backend Base URL**
```
http://localhost:8080
```

---

## Tech Stack

- **React (Vite)** 
- **JavaScript (ES6+)**
- **Fetch API**
- **Inline styling (JS objects)**
- **Spring Boot backend**

---

## Project Structure

```
src/
├── api/
│   └── api.js
│
├── components/
│   ├── DaysCalculator.jsx
│   ├── NumberToWords.jsx
│   └── TemperatureStats.jsx
│
├── styles/
│   └── styles.js
│
├── App.jsx
├── main.jsx
└── index.css
```

---

## Getting Started

### Prerequisites

- Node.js (v18 or higher)
- Backend service running on `http://localhost:8080`

---

### Install Dependencies

```bash
npm install
```

---

### Run the Frontend

```bash
npm run dev
```

The application will be available at:

```
http://localhost:5173
```

---


## DockerHub Support

**Image Pull**
``` bash
docker pull swaraj66/api-client:latest
```

**Run Container**
``` bash
docker run -p 5173:80 swaraj66/api-client
```
---
## Docker Support

**Build Image**

``` bash
docker build -t api-client .
```

**Run Container**

``` bash
docker run -p 5173:80 api-client
```
---

## Notes

- All validation is handled by the backend
- Frontend focuses on usability and clean integration

