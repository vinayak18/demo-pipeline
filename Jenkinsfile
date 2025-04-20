pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6' // name of Maven tool configured in Jenkins
    }

    triggers {
        pollSCM('* * * * *') // fallback in case webhook fails
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/vinayak18/demo-pipeline.git', branch: "${env.BRANCH_NAME}"
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
