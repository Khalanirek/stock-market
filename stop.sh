echo '#################### CLOSING ENVIRONMENT #############################'
echo ''
echo 'Closing environment by docker-compose.'
docker-compose stop
echo 'Closed environment successfully.'
echo ''
echo 'Listing all running containers.'
docker ps
echo ''
echo '#################### FINISHED CLOSING ENVIRONMENT ####################'