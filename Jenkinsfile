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
                steps{
                        echo "Running SonarQube Analysis"
                        withSonarQubeEnv('SonarQubeServer') {
                        sh """ mvn sonar:sonar -Dsonar.host.url=http://172.31.172.16:9000/ -Dsonar.login=Jenkins-Token-2 """
                        }      
               }  
         }     
         stage('Archive Artifacts') {
                steps {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
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
