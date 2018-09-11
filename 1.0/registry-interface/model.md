# Location Model Definitions

### GeoObject
A programming domain abstraction for a geographic feature that represents a location (point type objects) such as a village, household, or an area (polygon type object) such as a focus area that includes its geometry and attributes.

GeoObjects just contain data and not metadata. Metadata include localized labels and all possible select list options for a term attribute.

According to the HGLC specification, attributes on GeoObject Types can be defined at runtime using an administrative user interface. Metadata that describe a GeoObject's type is defined in the GeoObjecType JSON format.


```
{
  type : string,
  geometry : {
    type : string,
    coordinates : double[]
  }
  properties : {
    uid : string,
    code : string,
    type : string<GeoObjectType>, // maps to GeoObjectType name value
    status : string<Term>
    ... user defined and additional system defined attributes added to properties list.
  }
}
```
| Property | Description |Possible Values|Example|
|---|---|---|---|
|type | [GeoJSON standard type property](https://tools.ietf.org/html/rfc7946) |"Feature", "FeatureCollection"|
|geometry | [GeoJSON standard geometry object](https://tools.ietf.org/html/rfc7946) ||
|geometry.type | [GeoJSON standard geometry object type.](https://tools.ietf.org/html/rfc7946) |"Point", "MultiPoint", "LineString","MultiLineString", "Polygon", "MultiPolygon", "GeometryCollection"|
|geometry.coordinates | [GeoJSON standard geometry object coordinates array.](https://tools.ietf.org/html/rfc7946) ||
|properties | [GeoJSON standard properties object containing non-standard properties.](https://tools.ietf.org/html/rfc7946)||
|properties.uid | UID for the object. ||
|properties.code | Human Readable ID but not the UID. Not necessarily unique but should be unique within a subset of the hierarchy. ||A postal code|
|properties.type | GeoObjectType NAME which this object references. || "Village", "Household", "HealthFacility" |
|properties.status | Term NAME which this object references.  |||


### TreeNode
A TreeNode is the object type that is returned when a call is made to the Common Geo-Registry to fetch a tree of GeoObjects. For example, fetching all children of a GeoObject with a given UUID would return a TreeNode tree structure represending children of the given GeoObject. The Common Geo-Registry will provide a number of methods for fetching different kinds of GeoObject trees.

Note: Given that the Common Geo-Registry can model mulptiple hierarchies and a GeoObject can have multiple parents, the relationships between GeoObjects are actually a graph and not a tree. Consequently, when fetching a tree structure that represents transitive child relationships from different hierarchy paths, duplicate GeoObjects can occur in different parts of the tree representing different paths to the same GeoObject. For example, a given Villiage would be returned as a child of a District but would also be returned as a child of a Focus Area if all children of a Province that contains the District and the Focus Area are returned. Eventually the Common Geo-Registry and this specification will provide guidelines on how to filter out such duplicates so as to reduce the data footprint of fetching a large tree, but for the current interation this is not addressed. First let's get it working and then optimize.

```
{
  geoObject : GeoObject,
  hierarchyType : string<HierarchyType>,
  children : TreeNode[]
}

// OR

{
  geoObject : GeoObject,
  hierarchyType : string<HierarchyType>,
  parents : TreeNode[]
}
```
| Property | Description |Possible Values|Example|
|---|---|---|---|
|geoObject | A GeoObject object. ||
|hierarchyType | The name of the hierarchy type in the relationship || "Geopolitical"|
|children or parents | An array of TreeNode objects representing the children or parents of the GeoObject|||


# Meta Model Definitions

### GeoObjectType
Defines the metadata of a GeoObject Type, such as Village, Household, or Health Facility. It contains the localized label of the type (e.g. "Health Facility") as well as properties of the attributes it defines, including localized attribute labels. This object contains the metadata needed by the client, either mobile or server, for all GeoObjects of this type so that this information does not need to live on the GeoObject itself. The GeoOject just contains data values. The GeoObjectType contains information about the GeoObject's type and the attributes it defines.


```
{
  code : string,
  localizedLabel : string,
  localizedDescription : string,
  attributes : attributeType[]
}
``` 
| Property | Description |Possible Values|Example|
|---|---|---|---|
|code | Human readable code of the type. This is a human readable ID field.  ||"HeathFacility"|
|localizedLabel | Localized label for the object. ||"Health Facility" for English or "Facilidad de Salud" for Spanish, etc.|
|localizedDescription | Localized description of the object. || "Health Facilities are where people go to seek treatment..." |
|attributes | Array of metadata attribute objects that describe the attributes defined by this type.| AttributeNumericType, AttributeTermType ||

### HierarchyType
Defines a hierarchy type and specifies which GeoObjectTypes participate in that hierarchy. GeoObjects can relate to one another in different contexts. For example, a Village can be located within a Distruct but also be administered by a health administration zone. For example, a separate HierarchyType object would be defined for "GeoPolitical" and "HealthAdministrative" hierarchies.

```
{
  code : string,
  localizedLabel : string,
  localizedDescription : string,
  rootGeoObjectTypes : HierarchyNode[]
}
``` 
| Property | Description |Possible Values|Example|
|---|---|---|---|
|code | Human readable code of the hierarchy type. This is a human readable ID field.  ||"GeoPolitical", "HealthAdministrative"|
|localizedLabel | Localized label for the hierarchy type. ||"Geopolitical" for English or "Geopolítico" for Spanish, etc.|
|localizedDescription | Localized description of the object. || "The Geopolitical hierarchy represents relationships between Geopolitical units... " |
|rootGeoObjectTypes | The highest level GeoObjectTypes that participate in the hierarchy || Country would be the highest GeoObjectType that would participate in the Geopolitical hierarchy|   

### HierarchyNode
A HierarchyNode is an object used by HierarchyType that models the tree of GeoObjectTypes that participate in the hierarchy.  

```
{
  "geoObjectType" : GeoObjectType,
  "children" : HierarchyNode[]
}
```
| Property | Description |Possible Values|Example|
|---|---|---|---|
|geoObject | A GeoObject object. |||
|children | An array of HierarchyNode objects representing children GeoObjectTypes of the geoObject in the given hierarchy.|||


### Term
A term is a node in an ontology classification. A term can have a tree association with other terms. The Common Geo-Reigstry allows administrators to define attributes on GeoObject types at runtime. One can define an enumerated list (or select list) attribute and specify the possible values. For example, one could add the attribute "FacilityType" to HealthFacility with possible values "Clinic", "Maternity Ward", etc. Although most likely only single dimentional lists (i.e. list values with no children) will be defined, this design facilitates tree classifications that are useful for things like taxonomies. In the Health Facility example, it would allow for subcategories of Health Facility to be defined. These terms are located on the metadata attribute definition,

```
{
  code : string,
  localizedLabel : string,
  children : Term[]
}
```
| Property | Description | Possible Values | Example |
|---|---|---|---|
|code | Human readable identifier of the term || "CLINIC", "MAT_WARD"| 
|localizedLabel | Localized Label for the term. || "Clinic", "Maternity Ward" |
|children | Array of Term objects that are children to the current term in the hierarchy. | ||

## Attribute Types
Attributes store information that describes properties of an object. All GeoObjectType objects have a reference to an array of Attribute Type objects. All Attribute Types have a name and a localizedLabel property. Other Attribute Types have additional properties. For example, Attribute Term Types define a list of possible values (i.e. and enumerated list or tree) for a given attribute.

### AttributeTermType
Defines an object that contains localized descriptive data as well as a reference to a Term object. 
```
{
   code : string,
   localizedLabel : string,
   type : string,
   term : string<Term>
}
```
| Property | Description | Possible Values | Example |
|---|---|---|---|
|code | Human readable ID of the attribute || "FacilityType" |
|localizedLabel | Localized label for the term. ||"Facility Type", "Facilidad de Salud"  |
|type | Type of attribute. |"TERM"||
|term | Term NAME which this attribute references, which is the root Term whose children are possible values for this attribute || "FacilityType" with children terms "CLINIC", "MAT_WARD", etc. |

### AttributeNumericType
Defines a numeric attribute. 

```
{
   code : string,
   localizedLabel : string,
   type : string
}
```
| Property | Description | Possible Values | Example |
|---|---|---|---|
|code | Human readable ID of the attribute || "NumOfBeds" |
|localizedLabel | Localized label for the term. || "Number of Beds"|
|type | Type of attribute. |"NUMBER"||


### AttributeDateType
Defines a date attribute. 

```
{
   code : string,
   localizedLabel : string,
   type : string
}
```
| Property | Description | Possible Values | Example |
|---|---|---|---|
|code | Human readable ID of the attribute || "DateOpened" |
|localizedLabel | Localized label for the term. || "Date Opened"|
|format | format of the date |"yyyyy-mm-dd"||
