pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build message'
      }
    }

    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo 'Testing'
          }
        }

        stage('DB Build') {
          steps {
            echo 'Building Database'
          }
        }

        stage('Nest Unit Testing') {
          steps {
            echo 'Nest Testing'
          }
        }

        stage('Angular Unit Testing') {
          steps {
            echo 'Angular Running Tests'
          }
        }

      }
    }

    stage('Staging') {
      parallel {
        stage('Staging') {
          steps {
            echo 'Staging'
          }
        }

        stage('Containerization') {
          steps {
            echo 'containerization'
          }
        }

      }
    }

    stage('Production') {
      steps {
        echo 'In production'
      }
    }

  }
}