#   
#   ------------------------------------------------------
#   This script install all pre-requisites and configuration to run the project.
#   This script needs to be run with privileges

# Install Docker
echo "Installing Docker"
sudo apt-get update
sudo apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release -

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

echo \
  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null



sudo apt-get update
sudo apt-get install -y docker-ce docker-ce-cli containerd.io

# Post Docker Installation
sudo usermod -aG docker $USER
newgrp docker


# Install OpenJDK 11 and Maven to build the SpringBoot project
echo "Install OpenJDK11 and Maven"
sudo apt install -y openjdk-11-jdk
sudo apt install -y maven


# Install Minikube
echo "Installing Minikube"
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube_latest_amd64.deb
sudo dpkg -i minikube_latest_amd64.deb






#   Part 2
#   ---------------------------------------------
#   Starts Minikube build and deploy and run the 
#   Spring Boot project


# Start Minikube
echo "Starting Minikube"
minikube start
minikube addons enable ingress

# Use Minikube Docker 
eval $(minikube docker-env)

# Add minikube ip which also serves as ingress ip to hosts file
echo "$(minikube ip) message.reverser" | sudo tee -a /etc/hosts