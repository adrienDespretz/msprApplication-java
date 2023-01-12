pipeline {
    agent any
    tools{
        maven 'MAVEN'
    }
    environment {
        NEXUS_VERSION = "nexus2"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "localhost:8081/nexus"
        NEXUS_REPOSITORY = "TPJenkins"
        NEXUS_CREDENTIAL_ID = "NEXUS_ID"
    }
    stages {
        stage('Pull Git Ressource') {
            steps {
                git 'https://github.com/adrienDespretz/msprApplication-ressources.git'
            }
        }
       stage('Pull Git Appli') {
            steps {
                git 'https://github.com/adrienDespretz/msprApplication-java.git'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
         stage('Build') {
            steps {
                bat 'mvn package'
            }
        }
        stage('Generate website'){
            steps{
                dir('target'){
                    bat 'java -jar  mspr-1.0.0.jar '
                }
            }
        }
        stage('Deploy Website'){
            steps{
                dir('target'){
                    bat 'java -jar  mspr-1.0.0.jar '
                }
            }
        }
        stage('Publish to nexus') {
            steps {
                script {

                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    
                    if(artifactExists) {
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],

                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );

                    } else {
                        error "*** File: ${artifactPath}, could not be found or File version exist";
                    }
                }
            }
        }
    }
}