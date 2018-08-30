# Geospatial Widget (Kujaku) Specification

## What is a Geospatial Widget?

The Geospatial widget is an Android SDK designed to connect to the georegistry and other common geographical data sources like OSM and OGC servers. It is designed to integrate into common mobile data collection tools used in global health.  It is expected to support the three elimination use cases including:
    - Case Detection, Notification and Investigation
    - Focus Investigation
    - Routine and Reactive Intervention

The Geospatial widget library provides a map widget and has a map download service for offline support of map layers. It primarily uses the Mapbox SDK to implement its functionalities. The library also provides some helper util functions to support certain operations involving geospatial data.

# Specification

## MapActivity

The Geospatial widget SHOULD provide  a `MapActivity` activity that is used to display a map view given a Mapbox API access token and an array of Mapbox styles url. The `MapActivity` WILL be initialized by through an intent request.
The constants below are required:

```java

    String PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN;  // Mapbox API access token
    String[] PARCELABLE_KEY_MAPBOX_STYLES};  // Mapbox Styles (https://www.mapbox.com/mapbox-gl-js/style-spec/)
```

Example usage:


## Offline Map support

The Geospatial widget SHOULD provide the `MapboxOfflineDownloaderService` service that is used to download map layers for offline use. This service should also support the deletion of the offline map layers and resuming map layer download.
The service will accept the following cnstants:

- `PARCELABLE_KEY_SERVICE_ACTION` - Required for all
- `PARCELABLE_KEY_NETWORK_STATE` - Required for `SERVICE_ACTION#NETWORK_RESUME`



## Helper Functions

The following helper functions will provide additional functionality to manipulate the data.

