pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh '/home/ec2-user/apache-maven-3.6.1/bin/mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'rm -f /home/ec2-user/apache-tomcat-9.0.21/webapps/ROOT.war'
                sh 'cp /var/lib/jenkins/workspace/test/target/pactera-test-1.0.0.war /home/ec2-user/apache-tomcat-9.0.21/webapps/ROOT.war'
            }
        }
    }
}