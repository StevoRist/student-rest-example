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
            
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            
        }
    }
}
