//
// Location properties
//
LocationPropertiesModel {
  id : string,
  name : string,
  hierarchyPositionName : string,
  hierarchyPosition : integer
}

//
// Geometry properties
//
GeometryModel {
  type : string,
  coordinates : double[]
}

//
// Single location
//
LocationModel {
  type : string;
  geometry : GeometryModel;
  properties : LocationPropertiesModel;
}

//
// Multiple locations
//
MultiLocationModel {
  locations : LocationModel[];
}






