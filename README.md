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
- In CI/CD, the deployment stage copies all project files to `/tmp/credit-loan-deploy` on the Jenkins server after a successful build on the `main` branch.
- You can find the deployed files in `/tmp/credit-loan-deploy` on the Jenkins server.
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
	6. **Deploy:** Copies all project files to `/tmp/credit-loan-deploy` on the Jenkins server (local deployment for demonstration).
- **Automation:** All steps are defined in the `Jenkinsfile` at the project root.

---

## Logging and Monitoring
The project integrates logging and monitoring using SLF4J and Logback:

- **SLF4J/Logback Integration:**
  - All test classes use SLF4J for structured logging.
  - Logback is configured as the logging backend via Maven dependencies.
- **Test Logging:**
  - During test execution (including Selenium tests), log messages are generated for key actions and outcomes.
  - Log output includes browser startup, page load, assertions, and test results.
- **Monitoring in CI/CD:**
  - Jenkins console output displays all log messages from SLF4J during build and test stages.
  - Test logs are archived for review after each pipeline run.
- **How to View Logs:**
  - After running a Jenkins build, check the console output for SLF4J log entries.
  - Archived test logs can be downloaded from Jenkins for detailed analysis.

This setup ensures visibility into test execution and application behavior, supporting monitoring and troubleshooting.

---

## Security Best Practices
This project follows practical, transferable security guidelines:

- **No Secrets in Code:** Never commit passwords, API keys, or sensitive data to the repository.
- **.gitignore Usage:** Build artifacts, logs, and sensitive files are excluded from version control.
- **Environment Variables:** Use environment variables for secrets and credentials in local and CI/CD environments.
- **Secret Management:** For production, use tools like GitHub Secrets, Jenkins Credentials, or HashiCorp Vault.
- **Automated Security Checks:** Use Maven plugins or GitHub Actions (e.g., Dependabot) to scan for vulnerable dependencies.
- **Repository Hygiene:** Regularly remove large or unnecessary files and branches to stay within storage limits.
- **Reporting Vulnerabilities:** Contributors should report security issues privately to the project maintainer.

For more details or to contribute securely, see the SECURITY.md file (if present) or contact the maintainer.

---

## Git CLI: Commit and Push Changes
To save your changes and upload them to GitHub, use the following commands:

1. **Stage all changes:**
   ```sh
   git add .
   ```
2. **Commit with a message:**
   ```sh
   git commit -m "Update README with logging and monitoring section"
   ```
3. **Push to the remote repository:**
   ```sh
   git push origin main
   ```

Replace the commit message with a description of your changes as needed.

---

## Notes for Assessors
- The repository is private for academic integrity.
- All build, test, and CI/CD steps are fully automated and reproducible.
- The project demonstrates best practices in build automation, testing, and DevOps for a Java web application.

---

## Contact
- Project by: Samuel Peter
- GitHub: https://github.com/sampeter-akan/credit-loan-calculator
