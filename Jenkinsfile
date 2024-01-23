pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
              git branch: 'master', url: 'https://github.com/aitnacer-nabil/LabXpert-'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean '
            }
        }

        stage('Test ') {
            steps {
                bat 'mvn test '
            }
        }


    }

    post {
        success {
            echo 'Test succeeded!'

        }

        failure {
             echo 'Test failed!'
        }
    }
}