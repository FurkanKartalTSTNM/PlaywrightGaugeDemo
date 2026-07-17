Playwright cases
================

Open Google
-----------
tags: playwright, google
* I open the Google page
* I should see Google in the title

Complete login form
-------------------
tags: playwright, login
* I prepare the login page
* I enter login credentials
* I submit the login form
* I should see the login success message

Add a todo item
---------------
tags: playwright, todo
* I prepare the todo page
* I add a todo item
* I should see the todo item in the list

Select test preferences
-----------------------
tags: playwright, preferences
* I prepare the preferences page
* I choose Firefox and enable headless mode
* I should see the selected preferences

Handle a JavaScript confirm dialog on a live site
--------------------------------------------------
tags: playwright, live-site, dialogs
* I open the JavaScript alerts page
* I trigger the confirm dialog and accept it
* I should see the confirm result message

Interact with content opened in a new tab
------------------------------------------
tags: playwright, live-site, tabs
* I open the multiple windows page
* I click the link that opens a new tab
* I should see the new tab content

Type inside an iframe on a live site
--------------------------------------
tags: playwright, live-site, iframes
* I open the rich text editor page
* I type text inside the editor iframe
* I should see my text inside the editor iframe

Wait for dynamically loaded content
--------------------------------------
tags: playwright, live-site, waits
* I open the dynamic loading page
* I start the dynamic loading process
* I should see the dynamically loaded text

Reveal hidden content on hover
---------------------------------
tags: playwright, live-site, hover
* I open the hovers page
* I hover over the first user avatar
* I should see that user's profile link

Reveal hidden content on hover error
---------------------------------
tags: playwright, live-site, error
* I open the hovers page
* I hover over the first user avatar error
* I should see that user's profile link

Reveal hidden content on hover wait
---------------------------------
tags: live-site, hover, wait
* I open the hovers page
* I hover over the first user avatar wait
* I should see that user's profile link

Reveal hidden content on hover undefined
---------------------------------
tags: live-site, hover, undefined
* I open the hovers page undefined
* I hover over the first user avatar wait
* I should see that user's profile link

Reveal hidden content on hover exception
---------------------------------
tags: live-site, hover, exception
* I open the hovers page
* It should throw runtime exception
* I should see that user's profile link

Complete a multi-step user journey
-------------------------------------
tags: playwright, live-site, journey
* I open the login page
* I should see "The Internet" in the page title
* I enter the username "tomsmith"
* I enter the password "SuperSecretPassword!"
* I submit the site login form
* I should see the login success message "You logged into a secure area"
* I open the checkboxes page
* the first checkbox should be unchecked
* I check the first checkbox
* the first checkbox should be checked
* the second checkbox should be checked
* I uncheck the second checkbox
* the second checkbox should be unchecked
* I open the dropdown page
* I select dropdown option "2"
* the selected dropdown option should be "2"
* I open the add remove elements page
* I add a new element
* I should see "1" as the added elements count
* I delete the added element
* I should see "0" as the added elements count
