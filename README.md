
# Credit Loan Calculator

## Project Overview
This project is a Java-based web application for calculating credit loan values. It uses Maven for build automation, Selenium for automated browser testing, and is managed with a professional CI/CD pipeline using Jenkins and GitHub.

---

## How to Build
1. **Clone the repository:**
	 ```sh
	 git clone https://github.com/sampeter-akan/credit-loan-calculator.git
	 cd credit-loan-calculator
	 ```
2. **Build with Maven:**
	 ```sh
	 mvn clean compile
	 ```

---

## How to Test
- **Run all tests:**
	```sh
	mvn test
	```
- Selenium tests are included and will run automatically. They use a headless Chrome browser and expect the app to be served at `http://localhost:8000/index.html`.

---

## How to Deploy (Example)
- For demonstration, the app can be served locally:
	```sh
	python3 -m http.server 8000
	```
- In a real deployment, copy the web files to your web server or hosting environment.

---

## CI/CD Pipeline (Jenkins)
- **Source Control:** GitHub (private repository)
- **Continuous Integration:** Jenkins pulls code from GitHub on every push to `main`.
- **Pipeline Steps:**
	1. **Checkout:** Jenkins pulls the latest code from GitHub.
	2. **Build:** Runs `mvn clean compile` to build the project.
	3. **Test:**
		 - Starts a local web server (`python3 -m http.server 8000 &`).
		 - Waits a few seconds for the server to start.
		 - Runs all tests (`mvn test`), including Selenium browser tests.
	4. **Archive Logs:** Test logs are archived for review.
	5. **Notify:** Jenkins outputs build status.
- **Automation:** All steps are defined in the `Jenkinsfile` at the project root.

---

## Notes for Assessors
- The repository is private for academic integrity.
- All build, test, and CI/CD steps are fully automated and reproducible.
- The project demonstrates best practices in build automation, testing, and DevOps for a Java web application.

---

## Contact
- Project by: Samuel Peter
- GitHub: https://github.com/sampeter-akan/credit-loan-calculator
