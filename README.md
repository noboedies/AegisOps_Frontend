# AegisOps Frontend

AegisOps is an AI-powered Incident Management and Root Cause Analysis
platform. This repository contains the **Spring Boot MVC frontend**
currently being developed for the application.

## Current Status

The frontend foundation is working with Thymeleaf pages and communicates
with the backend REST API.

Implemented so far: - Home page - Signup and login pages - Login form
handling through a Spring MVC controller - Session-based user storage
after successful login - Protected user dashboard - Project Manager
registration flow initiated from the dashboard - Backend communication
using `RestTemplate` - Flash messages for registration and login
feedback

## Technology Stack

-   Java
-   Spring Boot
-   Spring MVC
-   Thymeleaf
-   `RestTemplate` for backend REST calls
-   HTML
-   Maven
-   Git / GitHub

## Ports and Related Service

-   **Frontend:** `http://localhost:2922`
-   **Backend API:** `http://localhost:2921`

Make sure the backend is running before testing frontend operations that
call it.

## Pages and Routes

  -----------------------------------------------------------------------
Route                   Method                  Purpose
  ----------------------- ----------------------- -----------------------
`/`                     GET                     Displays the home page
(`index.html`)

`/signup`               GET                     Displays the signup
page

`/login`                GET                     Displays the login page

`/user/register`        POST                    Submits user
registration

`/user/login`           POST                    Submits login
credentials to the
frontend controller

`/user-dashboard`       GET                     Displays the dashboard
only when a user is
stored in the session

`/user/addmanager`      GET                     Opens the Add Manager
page for a logged-in
user
  -----------------------------------------------------------------------

The frontend login controller stores the authenticated user in the HTTP
session. Dashboard access checks for `session.getAttribute("user")`;
unauthenticated requests are redirected to `/login`.

## Running the Frontend

1.  Start the backend service on port `2921`.
2.  Open this project in IntelliJ IDEA or another Java IDE.
3.  Confirm the frontend is configured to run on port `2922`.
4.  Run the Spring Boot application.
5.  Open `http://localhost:2922` in your browser.

If the frontend calls the backend through a configured base URL, verify
that it points to `http://localhost:2921`.

## Login Flow

1.  The user submits the login form with `username` and `password`.
2.  The frontend controller calls `UserService`.
3.  The frontend service sends the credentials to the backend login
    endpoint.
4.  The backend verifies the credentials and returns a response.
5.  On success, the frontend stores the returned user information in the
    HTTP session and redirects to `/user-dashboard`.
6.  On failure, the user is redirected to `/login` with an error
    message.

Each browser has its own session. Opening the dashboard in a different
browser does not reuse the first browser's login session.

## Project Manager Flow

The dashboard includes an **Add Manager** link. The frontend route
`/user/addmanager` checks that a user is logged in before showing the
manager form. The form submission and backend endpoint must match the
route configured in the backend project.

## Configuration Notes

-   Keep the backend base URL and frontend server port in application
    configuration rather than hard-coding them throughout the code.
-   Use absolute paths for navigation links, such as `/user-dashboard`
    and `/user/logout`, to avoid relative-path routing errors.
-   Ensure the logout route invalidates the current HTTP session.
-   Use HTTPS when deploying outside local development.
-   Do not store or log raw passwords.

## Planned Enhancements

The broader AegisOps vision includes incident tracking, AI-assisted
investigation, root-cause analysis, remediation recommendations, and
post-incident reports. These features should be documented as
implemented only after they are built and tested.
~~~~