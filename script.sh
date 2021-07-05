# Create Namespace
kubectl create namespace signavio

# Build and deploy json-server
echo "Build, Dockerize and deploy json-server project"
cd json-server
eval $(minikube docker-env)
kubectl delete -f k8s/.
mvn clean install && docker build -t json-server .
kubectl apply -f k8s/.

# Build and deploy json-reverser
echo "Build, Dockerize and deploy json-reverser project"
cd ../json-reverser
eval $(minikube docker-env)
kubectl delete -f k8s/. 
mvn clean install && docker build -t json-reverser .
kubectl apply -f k8s/.
cd ..

# Sleep for 5s for deployments to be ready to serve
echo "Sleeping for 10s"
sleep 20s

# Curl and test the api
# To test the message api
curl http://message.reverser/message

# To test the message reverser api
curl http://message.reverser/app/reverse

# Open browser
x-www-browser http://message.reverser/app/
