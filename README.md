# WordProcesssor
Count Words Coding Assignment
Write a program called Count Words that processes a List of Strings and applies the following business rules:
- Counts and returns the NUMBER of words (i.e. Strings) that start with "M" or "m"
- Returns all the words longer than 5 characters
  
Hints
- Make sure you implement this test like you would all your production code (Documentation, unit tests, build/packaging, etc.).
- Business rules change and new ones pop up all the time; how will you account for this?
- Please don't input words from standard input, no one likes to type long list of names manually.
Endpoint->http://localhost:8080/words
Method-Post

Palyload Details:
-words:  Contains List of words
-filter: Contains String by which we can filter.
-length: Conatins numberic value for word length filter.

-Success Request Sample:
{
	"words":[
"JaiShanker",
"Pandey",
"Man",
"monu",
"Rohit",
"Maichle",
"Zebra",
"Man",
"Rohit"
],
	"filter":"M",
	"length":2
}
Response Details:
-countWords: will provide key value pair where key is filtered word and value is the count.
-words:  will provide list of words based on length.

-Success Response Sample:
{
    "countWords": {
        "Man": 2,
        "Maichle": 1
    },
    "words": [
        "JaiShanker",
        "Pandey",
        "Man",
        "monu",
        "Rohit",
        "Maichle",
        "Zebra",
        "Man",
        "Rohit"
    ]
}
