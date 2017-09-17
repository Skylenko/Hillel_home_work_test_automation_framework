Narrative:
In order to perform search correctly
As a user
I want to be able to see the list of found hotels, located in NY

Scenario: User should have possibility to see the list of found hotels, using own searching criterias

Given user has opened 'Booking.com' site

When user selects 'Destination' by using following value: 'New York, New York State, USA'
And user selects 'Check In' date by using following date: '14 September 2017'
And user selects 'Check Out' date by using following date: '16 September 2017'
And user clicks on 'Search' button

Then each item from 'Search Result' list contains 'New York'

