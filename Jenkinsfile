
pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK 17'
    }

    environment {
        REPORT_DIR = "target/surefire-reports"
        EXTENT_REPORT_DIR = "reports"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/moriyasb/Opencart_V1.0'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Selenium + TestNG tests...'
                sh 'mvn test'
            }
        }

        stage('Publish TestNG XML Reports') {
            steps {
                publishHTML(target: [
				reportDir: 'reports',
				reportFiles: 'index.html',
				reportName: 'Extent Report',
				keepAll: true
					]
				)
            }
        }

        stage('Archive Extent Reports') {
            steps {
                archiveArtifacts artifacts: "${EXTENT_REPORT_DIR}/**/*.*", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo '✅ Build and tests succeeded!'
        }
        failure {
            echo '❌ Build or tests failed. Check reports and logs.'
        }
    }
}
