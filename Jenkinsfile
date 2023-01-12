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
        stage('Recupere le git des info') {
            steps {
                git 'https://github.com/adrienDespretz/msprApplication-ressources.git'
            }
        }
       stage('Recupere le git de lappli') {
            steps {
                git 'https://github.com/adrienDespretz/msprApplication-java.git'
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
        stage('Publish to nexus') {
            steps {
                script {
 // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps
                    pom = readMavenPom file: "pom.xml";
                    // Find built artifact under target folder
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    // Print some info from the artifact found
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    // Extract the path from the File found
                    artifactPath = filesByGlob[0].path;
                    // Assign to a boolean response verifying If the artifact name exists
                    artifactExists = fileExists artifactPath;
                    
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                // Artifact generated such as .jar, .ear and .war files.
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],

                                // Lets upload the pom.xml file for additional information for Transitive dependencies
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