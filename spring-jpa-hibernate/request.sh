#!/usr/bin/env bash

echo "loop to create 10 players:"
for((i=0;i<10;i++)); \
  do \
    curl --location --request POST 'http://localhost:8080/player/' --header 'Content-Type: application/json' --data-raw '[{"coins":100,"goods":20}]'; \
  done

printf "\n\n"
echo "get player 1:"
curl --location --request GET 'http://localhost:8080/player/1'

printf "\n\n"
echo "get players by limit 3:"
curl --location --request GET 'http://localhost:8080/player/limit/3'

printf "\n\n"
echo "get first players:"
curl --location --request GET 'http://localhost:8080/player/page?index=0&size=2'

printf "\n\n"
echo "get players count:"
curl --location --request GET 'http://localhost:8080/player/count'

printf "\n\n"
echo "trade by two players:"
curl --location --request PUT 'http://localhost:8080/player/trade' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'sellID=1' \
  --data-urlencode 'buyID=2' \
  --data-urlencode 'amount=10' \
  --data-urlencode 'price=100'
