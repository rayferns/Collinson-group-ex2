Feature: As a biker I would like to know the exact location of city bikes around the world in a given application

    Background: Given I set sample REST API url to http://api.citybik.es/v2/networks

    Scenario:  As a user I want to verify that the city Frankfurt is in Germany and return their corresponding latitude and longitude

        Given a city bike exist within a company
        When a user retrieves the city by location
        Then the status code is 200
        And Response includes the following
            | totalItems | Company         |
            | 131        | "Nextbike GmbH" |
        And response includes the following in order
            | Location.city | Location.country | Location.latitude | Location.longitude |
            | Frankfurt     | DE               | 50.1072           | 8.66375            |