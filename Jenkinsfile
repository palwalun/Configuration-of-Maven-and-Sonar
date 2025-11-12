pipeline {
    agent any
      stages{
          stage('Checkout'){
              steps{
                      echo "Getting code from Github"
                      git url: 'https://github.com/palwalun/Configuration-of-Maven-and-Sonar.git' , 
                      branch: 'main' 
                    }
                   }
         stage('Build') {
              steps{ echo "Building the code"
                      sh 'mvn clean compile'
                   }
               }
         stage('Test') {
              steps{ echo "Running Unit Tests"
                      sh 'mvn test'
                   }
               }
         stage('SonarQube Analysis') {
              steps{ echo "Running SonarQube Analysis"
              archieveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true
                      withSonarQubeEnv('SonarQubeServer') {
                      sh 'mvn sonar:sonar'
                   }
               }      
        }
post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Please check the logs'
        }
    }
}
