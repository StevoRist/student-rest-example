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
            emailext body: 'Build status', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'App Bild Status'
        }
    }
}
