pipeline {
    agent any

    stages {
        stage("build") {
            steps {
                echo 'Building application....'
            }
        }
        stage("test") {
            steps {
                echo 'Testing application....'
            }
        }
        stage("deploy") {
            steps {
                echo 'Deploing application....'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
            
           emailext body: 'This is notification from Jenkins about your application build', subject: 'Notification for build', to: 'stevche2121@gmail.com'
            
        }
    }
}
