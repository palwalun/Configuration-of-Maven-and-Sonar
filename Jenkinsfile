pipeline {
    agent any
      stages{
          stage('Checkout'){
              steps{
                      echo "Getting code from Github"
                      git "https://github.com/palwalun/Configuration-of-Maven-and-Sonar"}
                   }
         stage('Build') {
              steps{ echo "Building the code"
                      sh 'mvn clean compile'
                   }
               }
        }
post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed'
        }
    }
}
