# Clinical Report Generator

A full-stack web application designed to streamline respiratory therapy patient reporting in an inpatient healthcare setting.

Inspired by my experience as a respiratory therapist, this project allows users to search for patients by unit or floor, select patients, 
and generate organized, printable reports containing relevant clinical and respiratory information.

The application uses fictional patient data for demonstration purposes.

## Features

- **User Authentication:** Login using Spring Security with session-based authentication and CSRF protection.
- **Patient Search:** Search for patients by hospital unit or floor.
- **Patient Selection:** Select multiple patients using checkboxes.
- **Report Generation:** Generate organized reports containing patient information and associated respiratory modalities.
- **Respiratory Modalities:** Support for ventilators, tracheostomies, oxygen therapy, and noninvasive ventilation.
- **Print Functionality:** Print formatted reports using a dedicated print layout.

## Technologies Used

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Gradle (Kotlin DSL)

### Frontend
- React
- JavaScript
- Vite
- HTML
- CSS

## Application Architecture

The application uses a React frontend