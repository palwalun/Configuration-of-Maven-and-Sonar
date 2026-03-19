pipeline{
 agent any
 
  stages{
   stage('Checkout'){
    steps{
	 checkout scm
	}
   }
   stage('Build'){
    steps{
	 sh 'mvn clean package'
	}
   }
   stage('Build Docker Image'){
    steps{
	 sh 'docker build -t javaapp:latest .'
	}
   }
   stage('Login to ACR') {
       steps {
         withCredentials([usernamePassword(
             credentialsId: 'acr-creds',
             usernameVariable: 'ACR_USER',
             passwordVariable: 'ACR_PASS'
         )]) {
             sh '''
               echo $ACR_PASS | docker login $ACR_LOGIN_SERVER \
               -u $ACR_USER --password-stdin
             '''
           }
          }
         }
  
  }



}