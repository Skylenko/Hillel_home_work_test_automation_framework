Narrative:
In order to perform search flights correctly
As a user
I want to be able to see the list of found flights, from Kiev to Tel Aviv

Scenario: User should have possibility to see the list of found flights, using own searching criterias

Given user has opened 'BookingFlights.com' site
When user click on 'Flights' button
And user selects 'Departure from' by using following value: 'Kiev'
And user selects 'Arrival to' by using following value: 'Tel Aviv'
And user selects 'Departure' date by using following date: '09/18/2017'
And user selects 'Arrival' date by using following date: '09/23/2017'
And user clicks on 'Search' button

Then each item from 'Search Result' list contains 'TLV'