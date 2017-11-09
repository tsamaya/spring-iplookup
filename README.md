# Spring service : IP lookup

use the gradle wrapper to build or your own

`$./gradlew bootRun` will build and run the project

tests : 

`$ curl "http://localhost:8080/iplookup" --header "X-Forwarded-For: 128.101.101.101" -i`
`$ curl "http://localhost:8080/iplookup" --header "X-Forwarded-For: 101.101.101.101, 128.101.101.101" -i`
`$ curl "http://localhost:8080/iplookup?ip=101.101.101.101" -i`
`$ curl "http://localhost:8080/iplookup"`

to be continued...