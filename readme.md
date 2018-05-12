# Android Meal Tracker Application

## Project Objectives
After two weeks of Java and one week of Android, I was tasked with consolidating my learnings via a project brief set by CodeClan instructors. The goal of the project was to practice OO and UI design.

I decided to focus on an Android application, as less time had been spent on this framework and I felt it was a big learning opportunity.

### MVP

I was required to write an Android app that allows a user to track the food they eat. Users should be able to enter what they eat and when (date/time) and for what type of meal.

### Extensions

- The app should show the user a record of what they have eaten over a given period.
- Meals are sorted by date consumed.
- Each logged meal has a detail page.
- User can delete meals.

## Design Process

Before coding, I planned out my Java classes and relationships using UML diagrams. I looked at other meal tracking applications to get an idea of core functionality, and wrote personas, user journeys and user stories to assist with UX.

I created wireframes and realised that I would only require four navigational elements. I decided to use a bottom navigational menu so the user would have a familiar and consistent experience.

![alt text](https://github.com/claire-c/Meal_Tracker_App/blob/master/screenshots/main_activity.png)

I wrote and tested my Java classes in around half a day, leaving me the rest of the week to focus on the Android framework using Android Studio. I used a Trello board to plan and manage the build.

## What I learned

As I had decided to use a bottom navigational menu, I spent a significant amount of the week learning how to build an app using a bottom nav with [fragments](https://developer.android.com/guide/components/fragments).

I built the entire application using fragments instead of activities.  As well as this, I learned about:
- Java date class
- Java comparators
- Dialogs
- Spinners
- Bundles
- Data persistence  
- Programmatically working with the UI

![alt text](https://github.com/claire-c/Meal_Tracker_App/blob/master/screenshots/add_meal_fragment.png)

There was a lot of learning for me during this application build, and I feel pleased that I had a working app at the end of a week. It was an enjoyable week feeling my way around Android and I felt much happier with the framework after building my project.

This was a different process to my [Ruby web application](https://github.com/claire-c/Biked_Web_App) - the Ruby functionality was built using some skills I had already learned (except CSS), where as this Android project's functionality was built in tandem with the learning process.

## If I had more time

As I spent the week learning fragments, I did not have enough time to explore databases. I would have liked to explore SQLite as a solution to data persistence.

You can read more about my experiences building this app [via my Linkedin article.](https://www.linkedin.com/pulse/weeks-8-9-building-android-app-claire-connachan/) 
