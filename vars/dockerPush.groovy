def call(String Project, String ImageTag){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    sh "sudo docker image tag ${Project}:${ImageTag} ${env.dockerHubUser}/${Project}:${ImageTag}"
    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
  }
  
}
