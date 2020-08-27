# About
The registry interface defines the standard API interface to an implementation of a server side common geo-registry. This includes two communication APIs and formal data model definitions.

### Supporting Documentation
1. The REST API docs can be found [here](https://terraframe.github.io/common-geo-registry-specification-rest-api-docs/#)

### Updating Rendered REST API Docs
The [rendered REST API docs](https://terraframe.github.io/common-geo-registry-specification-rest-api-docs/#) are hosted in a seperate repository to keep this specification repository clean from the web implementation artifacts used to render and host the docs. The repository for hosting the REST API docs can be found [here](https://github.com/terraframe/common-geo-registry-specification-rest-api-docs). See that project repository for information of re-building the rendered documentation.

https://travis-ci.com/terraframe/common-geo-registry-specification-rest-api-documentation

### Communication APIs
1.  Server side Java API. 
2.  HTTP RESTful API. 

### RESTful API Response Data Model Definitions

![Object Model Diagram](https://github.com/terraframe/common-geo-registry-specification/blob/master/1.0/registry-interface/docs/registry-interface-data-model.png)

## File Inventory
|  File  |  Description  |
|---|---|
|  Interface.java  |  Defines the server side Java API to the common geo-registry.  |
|  rest-api.md  |  Defines the HTTP RESTful API used to interact with the common geo-registry.  |
|  rest-api.yaml  |  Defines the HTTP RESTful API fit to the OpenAPI specification.  |
|  model.md  |  Defines the data models used in the common geo-registry.  |
|  model-examples.md  |  Provides examples of the objects that adhere to the data model definitions.  |
| docs/registry-interface-data-model.png | Object model diagram for objects returned from the registry interface |
| docs/registry-interface-data-model.svg | Object model diagram source file for objects returned from the registry interface |


## Change Log
1. Added rest-api.yaml to define the REST API with OpenAPI. 
