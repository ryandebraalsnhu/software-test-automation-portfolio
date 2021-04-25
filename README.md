# Software Test Automation Portfolio
https://github.com/ryandebraalsnhu/software-test-automation-portfolio

## How can I ensure that my code, program, or software is functional and secure?

When writing code it is important to validate the data you are working with on every level.
When you receive the data from an external source, validate that it is not null and that it 
is in the expected format. When iterating across a collection validate that the collection 
itself is not null and that it has conents. When working with objects, be sure to validate 
each field's data type.

## How do I interpret user needs and incorporate them into a program?

To properly identify a user's needs you need to establish well defined user stories early on 
in the SDLC. Each and every feature a user wants needs to be documented and clearly defined. 
Each user story needs to have acceptence criteria and an estimation of how much effort 
incorporating the feature will take.

It is standard practice in the industry to seperate the software developers from the users 
by employing a business analyst whose expertise allows them to gather the proper information 
from the users and use that to create meaningful user stories which the developers can execute 
against.

## How do I approach designing software?

Personally, I always employee a "fail fast" philosophy, which is sometimes known as 
"defensive programming". (Contieri, 2020) Whenever I write code, I immedietly try to determine 
if the data is valid. If it isn't, I stop working with it immediately and return a well 
formatted exception. It is pointless to try to "shove bad data" through the business logic.


Very often I see code which looks like this:

```
if (collection != null) {
    if (collection.Data != null || collection.Data.length < 1) {
        for (var d in collection.Data) {
	        if (d != null) {	        
 	            if (d.ID != null && d.ID > 0) {
		            //Business logic goes here...
                } else {
					//Invalid ID...
				}
	        } else {
				//Data in loop is null...
			}
        }		
	} else {
		//Data in collection is null...
	}	
} else {
    //Collection is null...
}
```

This is needlessly convoluted "spagetti code". This same logic could be refactored to read 
more cleanly and be more robust by simply testing the data and stopping progress (fail fast) 
as soon as the data isn't viable:

```
if (collection == null || collection.Data == null || !collection.Data.Any())
    return Error("An invalid collection has been specified.");

for (var d in collection.Data) {
    if (d == null || d.ID == null || d.ID < 1)
        continue; 

    //Business logic goes here...  	
}
```



## Citations

Contieri, M. (2020, May 26). Fail fast PHILOSOPHY, Explained. Retrieved April 25, 2021, from https://hackernoon.com/fail-fast-philosophy-explained-si963vk9
