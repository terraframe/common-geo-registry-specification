# RESTful Geo-Object Mobile Interface Specification

The mobile host application (i.e. OpenSRP, DHIS2 Android App, etc.) is responsible for managing all business logic related to mobile mapping. This includes interacting with both the GeoWidget and the RESTful Geo-Object Mobile Interface, which is defined in this specification. This interface is responsible for managing interactions with the RESTful Geo-Object Server Specification. The primary duties of this interface focus on ensuring the transportation of Geo-Objects can be 

1. GET JSON metadata and geoJSON Geo-Objects from the RESTful Geo-Object server of choice and provide them to the mobile host application so they can be stored
2. POST/PUT geoJSON Geo-Objects that have been created in the mobile host application so they can be added to the common GeoRegistry.

The RESTful Geo-Object Mobile Interface will be made available as a library for mobile host applications to consume. This library will contain the RESTful services allowing for streamlined interactions with the GeoRegistry using the commonly defined API specifications.

## Assumptions

* The RESTful Geo-Object Mobile Interface is not responsible for storing Geo-Objects. That is the responsibility of the mobile host application.
* This interface will only be responsible for connecting to one GeoRegistry. Connecting to multiple GeoRegistries is out of scope of this specification.
* This interface will support the transportation layer only. The interface will return any HTTP errors to the mobile host applicatoin.
* The business logic for queuing and failures is in the event the GeoRegistry is unavailable is the responsibility of the mobile host application.

## Configuration
Below is a sample of configuration variables that are needed:
* GEOREGISTRY_BASEURL: This is the BaseURL of the GeoRegistry
* USERNAME: This is the username of the user who will have access to GET and POST/PUT to the GeoRegistry
* PASSWORD: This is the password of the user who will have access to GET and POST/PUT to the GeoRegistry

## RESTful API Definition
This section will be created in alignment with the RESTful Geo-Object Server Specification following common RESTFUL conventions.