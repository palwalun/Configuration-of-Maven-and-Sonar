pipeline{
 agent any
 environment {
		ACR_LOGIN_SERVER = "devopsproject2.azurecr.io"
		IMAGE_NAME = 'javaapp'
		TAG = 'latest'
    }
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
  stage('Tag Image') {
     steps {
         sh '''
           docker tag ${IMAGE_NAME}:${TAG} \
           $ACR_LOGIN_SERVER/${IMAGE_NAME}:${TAG}
         '''
          }
        }
	stage('Deploy to k8s cluster'){
    steps{
	 sh 'kubectl apply -f deployment.yml'
	}
   }
  
  }



}