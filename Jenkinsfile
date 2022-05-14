pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/mgvunicamp/trabalho5'
                  
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
          
          post {
            success {
              junit '**/target/surefire-reports/TST-*.xml'
              archiveArtifacts 'target/*.jar'
            }
          }
        }
       
    }
}
