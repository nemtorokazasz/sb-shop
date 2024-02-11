pipeline{
    agent any
    tools{
        maven '3.9.6'
    }
    environment {
        LASTIMAGE = sh(script: 'docker images --filter=reference=\'ordog/sb-shop-be*\' --format \'{{.Repository}}:{{.Tag}}\' | head -n 1', returnStdout: true).trim()
        PROJECT_VERSION = null
    }
    stages{
        stage('Clone repository'){
            steps{
                script{
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nemtorokazasz/sb-shop.git']])

                    // Kinyerjük a projektverziót a pom.xml-ből
                    PROJECT_VERSION = sh(script: "grep '<finalName>' pom.xml | head -n 1 | awk -F'>' '{print \$2}' | awk -F'<' '{print \$1}'", returnStdout: true).trim()

                    // Globális változóba mentjük a projektverziót
                    env.PROJECT_VERSION = PROJECT_VERSION
                }
            }
        }
        stage('Display Project Version'){
            steps{
                script {
                    echo "Project version: ${PROJECT_VERSION}"
                }
            }
        }
        stage('Stop&Remove docker container') {
            steps {
                script {
                    def existingContainerId = sh(script: 'docker ps -q -a -f "ancestor=${LASTIMAGE}"', returnStdout: true).trim()

                    // Ellenőrizzük, hogy van-e már futó konténer
                    if (existingContainerId) {
                        echo "Stopping and removing existing container with ID: ${existingContainerId}"
                        // Próbálja meg leállítani az esetlegesen futó konténert
                        sh "docker stop ${existingContainerId}"
                        // Várjon a konténer leállására
                        sh "docker wait ${existingContainerId}"
                        // Törölje a leállított konténert
                        sh "docker rm ${existingContainerId}"
                    }
                }
            }
        }
        stage('Build Maven'){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }
        stage('Run Test'){
            steps{
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Build Docker Image'){
            steps{
                script {
                    sh "sed -i 's/\${project.version}/${PROJECT_VERSION}/g' Dockerfile"
                    sh "docker build -t ordog/sb-shop-be:${PROJECT_VERSION} ."
                }
            }
        }
        stage('Run Docker Image'){
            steps {
                script {
                    sh "docker run -d --name sb-shop-be -p 8082:8082 ordog/sb-shop-be:${PROJECT_VERSION}"
                }
            }
        }
    }
}