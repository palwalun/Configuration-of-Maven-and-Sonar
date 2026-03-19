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
  
  }



}