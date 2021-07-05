
=================================
## Interpod Communication Example
=================================

The solution uses two Dockerized Spring Boot projects running on Minikube.

Overall Structure
1. json-server: serves the json message 
2. json-reverser: reverses the json message served by json-server
3. Solution uses Minikube Docker to build and deploy to docker, eliminiting need for docker registry
4. Kubernetes manifests are stored in k8s folder of project
5. Dockerfile is stored at root of the project
6. installprereq.sh isntall and sets up prerequisite for this project
7. script.sh builds and deploys the spring boot project into Minikube
8. Project is deployed in "signavio" namespace
9. Post deployment access the project at http://message.reverser/app/

### Version and Compatibility
1. Ubuntu 18.04 
2. Docker Version - CE 20.10.6
3. Minikube v1.9.2 
4. Kubernetes Version: v1.18.0
5. Kubectl Version: v1.18.2

### Install Pre-requisites
1. Please run installprereq.sh if Docker and Minikube are not installed and Docker context is not set to Minikube
    ```
    cd coding-challenge-priya-ranjan
    sh installprereq.sh
    ```
2. Run the setup.sh script after preq-requisites are installed
    ```
    cd coding-challenge-priya-ranjan
    sh setup.sh
3. To see the message
    ```
    curl http://message.reverser/message 
    ```
4. To see the reverse message
    ```
    curl http://message.reverser/app/reverse
    ```
    or open the browser to test both backend and javascript version 
    of reversing

    http://message.reverser/app/
5. To see the k8s status
    ```
    kubectl get all -n signavio
    ```