# Spring service : IP lookup

use the gradle wrapper to build or your own gradle installation

`$./gradlew bootRun` will run the project with the wrapper

tests : 

    $ curl "http://localhost:8080/iplookup" --header "X-Forwarded-For: 128.101.101.101" -i
    $ curl "http://localhost:8080/iplookup" --header "X-Forwarded-For: 101.101.101.101, 128.101.101.101" -i
    $ curl "http://localhost:8080/iplookup?ip=101.101.101.101" -i
    $ curl "http://localhost:8080/iplookup"

to be continued...
