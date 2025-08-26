        stage('Deploy') {
            script {
                if (env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main') {
                    sh 'mkdir -p /tmp/credit-loan-deploy && cp -r * /tmp/credit-loan-deploy/'
                }
            }
        }
pipeline {
    agent any

    tools {
        maven 'Maven 3.8.9'
        jdk 'JDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/sampeter-akan/credit-loan-calculator.git', branch: 'main', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Start a local web server to serve index.html for Selenium tests
                sh 'python3 -m http.server 8000 &'
                // Wait a moment to ensure the server is up
                sh 'sleep 3'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Archive Logs') {
            steps {
                archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
            }
        }

        stage('Notify') {
            steps {
                echo "Build completed: ${currentBuild.currentResult}"
            }
        }
    }

    post {
        success {
            echo '✅ Build and tests passed!'
        }
        failure {
            echo '❌ Build or tests failed!'
        }
    }
}
