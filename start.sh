echo '#################### STARTING ENVIRONMENT #############################'
echo ''
echo 'Starting environment by docker-compose.'
mvn clean package
docker build --no-cache -t stock-market .
docker-compose up -d
echo 'Started environment successfully.'
echo ''
echo 'Listing all running containers.'
docker ps
echo ''
echo '#################### FINISHED STARTING ENVIRONMENT ####################'