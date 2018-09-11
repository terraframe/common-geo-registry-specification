### EXAMPLE - GeoObject

```
{
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [0, 0]
  },
  "properties": {
    "uid": "123",
    "name": "Valley Health",
    "type" : "HEALTHFACILITY",
    "status" : "ACTIVE",
    "featureAttributes" : [{
      "facilityType" : "CLINIC",
      "numberOfBeds" : 32
    }]
  }
}
```

### EXAMPLE - TreeNode
```
{
  "geoObject" : geoObject_1,
  "hierarchyType" : 111,
  "children" : [
    {
      "geoObject" : geoObject_2,
      "hierarchyType" : 222,
      "children" : []
    },{
      "geoObject" : geoObject_3,
      "hierarchyType" : 333,
      "children" : [
        {
          "geoObject" : geoObject_4,
          "hierarchyType" : 444,
          "children" : []
        }
      ]
    }
  ]
}
```

### EXAMPLE - GeoObjectType
```
{
  "name" : "HEALTHFACILITY",
  "localizedLabel" : "Health Facility",
  "localizedDescription" : "Location of an organization classified as a health facility by ...",
  "attributes" : [attributeTermType, attributeNumericType, ...]
}
```

### EXAMPLE - HierarchyType
```
{
  "name" : "LOCATEDIN",
  "localizedLabel" : "Located In",
  "localizedDescription" : "Target GeoObjects are located in a parent GeoObject",
  "rootGeoObjectTypes" : [//TODO: HierarchyNode]
}
```

### EXAMPLE - HierarchyNode
```
{
  "geoObjectType" : geoObjectType, 
  "children" : [HierarchyNode ...]
}
```

### EXAMPLE - Term
```
{
  "name" : "FACILITYTYPE",
  "localizedLabel" : "Facility Type",
  children : [term ...]
}
```

### EXAMPLE - AttributeTermType
```
{
  "name" : "FACILITYtYPE",
  "localizedLabel" : "Facility Type",
  "type" : "TERM",
  "term" : "FACILITYTYPE"
}
```

### EXAMPLE - AttributeNumericType
```
{
  "name" : "NUMBEROFBEDS",
  "localizedLabel" : "Number Of Beds",
  "type" : "NUMBER"
}
```

### EXAMPLE - AttributeDateType
```
{
  "name" : "TREATMENTDATE",
  "localizedLabel" : "Treatment Date",
  "type" : "DATE"
}
```
