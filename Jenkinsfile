pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6' // name of Maven tool configured in Jenkins
    }
    
    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-credentials'
        DOCKER_IMAGE = 'vinayak1999/pipeline-app'
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
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}:latest")
                }
            }
        }
        
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKERHUB_CREDENTIALS}") {
                        docker.image("${DOCKER_IMAGE}:latest").push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Docker image creation, and push to Docker Hub succeeded!'
        }
        failure {
            echo 'Something went wrong.'
        }
    }
}
