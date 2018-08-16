//
// Single location
//
LocationModel {
  type : string;
  geometry : object;
  properties : object;
}

//
// Single Point location EXAMPLE
//
{
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [0, 0]
  },
  "properties": {
    "id": "EXAMPLE ID"
    "name": "EXAMPLE NAME"
  }
}

//
// Single Polygon location EXAMPLE
//
{
  "type": "Feature",
  "geometry": {
    "type": "Polygon",
    "coordinates": [
        [
            [100.0, 0.0],
            [101.0, 0.0],
            [101.0, 1.0],
            [100.0, 1.0],
            [100.0, 0.0]
        ]
    ]
  },
  "properties": {
    "id": "EXAMPLE ID"
    "name": "EXAMPLE NAME"
  }
}

//
// Multiple locations
//
MultiLocationModel {
  locations : location[];
}

//
// Multiple locations EXAMPLE
//
[
    {
        "type": "Feature",
        "geometry": {
            "type": "Point",
            "coordinates": [0, 0]
        },
        "properties": {
            "id": "EXAMPLE ID"
            "name": "EXAMPLE NAME"
        }
    },
    {
        "type": "Feature",
        "geometry": {
            "type": "Point",
            "coordinates": [0, 0]
        },
        "properties": {
            "id": "EXAMPLE ID"
            "name": "EXAMPLE NAME"
        }
    }
]

