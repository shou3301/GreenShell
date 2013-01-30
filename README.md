# Protocol

All the data transferred between front end and back end is using [json](http://en.wikipedia.org/wiki/JSON). 

## Input

There are two types of input.

__Simulation Input__

The form data submitted should be in the following format:

	module : module_name_selected

For the web page supports custom input data, the format is the same:

	comment_name : value_set

The __comment_name__ here is the global identifier for the position of the value needed to be changed. Details about naming of __comment_name__ please refer to Freeze.

An example:

	var userOption = {
				"door" : door_name,
				"door_value" : value1
				"place" : place_name
			};

Here, __"door"__ is the name of the module, __door_name__ is the selected name; __"door_value"__ is the __comment_name__ for model module, and __value1__ is the user input for that value.

__Module Info Input__

When an option (for a certain module) is selected, the corresponding information for that module should be presented. For example, if a user selects "super door", then the detailed information of the "super door" will be shown. The input of module info is the follower:

	var dataString = { "Info" : module + model_name_selected };

__"Info"__ has to be there for any selected option. __model__ is the name of the module (e.g. door), and __model_name_selected__ is the selected name (e.g. super door). __model_name_selected__ can be easily extracted from the selected option text.

## Output

There are three types of output.

__Initialization Info Output__

The information to initialize the web page. More specifically, the module names. The data is a list of \<key, a list of \<key, value\>\> pairs. The following sample code can iterate the values:

	$.each(response, function(key, value) {
         // Here "key" is the name of the module
         // just like the "door" above
        $.each(value, function(idx, inner_value) {
        	// ignore "idx"
        	// "inner_value" is the text for module options
      	});

	});

My original code is simple and rough:

	$.each(response, function(key, value) {   
         	
         // the id for the <select> tag
        var selectName = "#" + key + "_option";
         	            	
        $.each(value, function(idx, inner_value) {
        	// append the <option> to the <select>
			var appendVal = "<option value='" + inner_value 
				+ "'>" + inner_value + "</option>";
        	$(selectName).append(appendVal);
      	});

	});

__Module Info Output__

The corresponding output for module info. The output is a list of \<key, value\> pairs. __key__ is the name of a property, and __value__ is the value of the property. The following sample code can iterate the values:

	$.each(response, function(key, value) {
         	// key for property name
     		// value for property value
    });

__Simulation Output__

The output for simulation results. The output is also a list of \<key, a list of \<key, value\>\> pairs. The first __key__ is the name of a property (e.g. power consumption), ignore the second __key__. And __value__ is the value of the property (e.g. power consumption of each month in a year). The following sample code can iterate the values:

	$.each(response, function(key, value) {   
		// "key" - property name          	
       	$.each(value, function(idx, inner_value) {
        	// "inner_value" - value
        });

    });

_There are some JavaScript plotting tools out there which support json. But I haven't looked into them. If the format here is not good, I can change them._

## Servlet Name

__InitServlet__ \- servlet to call to initialize a page (getting all module options)

Sample code:
	
	$.get("InitServlet", function(response) { 
		if (response) {

	    	$.each(response, function(key, value) {   
	         	            	
	        	$.each(value, function(idx, inner_value) {

	      		});

			});
		}
		else {
			// initialization failed
			// give user some feedback
		}
	}

__InfoServlet__ \- servlet to call to get a module option's information

Sample code:

	$.ajax({
      	type: "GET",
      	url: "InfoServlet",
      	success: function (response) {
         	if (response) {
         					
         		$.each(response, function(key, value) {
         			// show info
         		});
         	}
        	else {
            	// add some alert info
         	}
      	},
      	data: dataString	// json input string
   	});

__SimulatorServlet__ \- servlet to call to execute simulation

Sample code:

	$.ajax({
      	type: "POST",
      	url: "SimulatorServlet",
      	success: function (response) {
         	if (response) {

         	    $.each(response, function(key, value) {   
         	        // do something
         	    	$.each(value, function(idx, inner_value) {
         	    		// do something
         	    	});

         	    });
         	}
        	else {
            	// simulation failed
            	// give some feedback to user
            }
      	},
      	data: dataString	// json input string
   	});

## Module Names

I've hard coded this part at back-end. So the module name to generate the input of simulation and initialization must follow.

	module : module_name_selected
	"Info" : module + model_name_selected

For both __module__ above.

| Moduel  			| Name for it 	|
| -----------------	| ------------- |
| Model    			| model    		|
| Schedule    		| schedule    	|
| Window			| window 		|
| Wall				| wall 			|
| Floor				| floor 		|
| Roof 				| roof 			|
| Lighting			| lighting 		|
| Air conditioner 	| air 			|
| HVAC 				| hvac 			|
| Heat 				| heat 			|
| Place 			| place 		|

_This table can be extended in the future._

## Other Things to Do at Front-end

- User input validation: make sure each module has a selected value; each user input values are digits.















