pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build message'
      }
    }

    stage('Test') {
      steps {
        mail(subject: 'Testing Alert', body: 'This is a test', charset: 'utf-8', from: 'luismendoza.samuel@gmail.com', to: 'luismendoza.samuel@gmail.com')
      }
    }

    stage('Staging') {
      steps {
        echo 'Staging'
      }
    }

    stage('Production') {
      steps {
        echo 'In production'
      }
    }

  }
}