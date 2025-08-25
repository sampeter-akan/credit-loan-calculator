pipeline {
    agent any

    tools {
        maven 'Maven 3.8.9'
        jdk 'JDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token', url: 'git@github.com:sampeter-akan/credit-loan-calculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
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
