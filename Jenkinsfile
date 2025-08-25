pipeline {
    agent any

    tools {
        maven 'Default'
        jdk 'Default'
    }

    stages {
        stage('Checkout') {
        maven 'Default'
        jdk 'Default'
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
