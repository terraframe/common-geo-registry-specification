# Geospatial Widget (Kujaku) Specification

## What is a Geospatial Widget?

The Geospatial widget is an Android SDK designed to connect to the georegistry and other common geographical data sources like OSM and OGC servers. It also supports visualisation of geosptial data and inspection. It is designed to integrate into common mobile data collection tools used in global health.  It is expected to support the three elimination use cases including:
- Case Detection, Notification and Investigation
- Focus Investigation
- Routine and Reactive Intervention

The Geospatial widget library provides a map widget and has a map download service for offline support of map layers. It primarily uses the Mapbox SDK to implement its functionalities. The library also provides some helper util functions to support certain operations involving geospatial data.

# Specification

## MapActivity

The Geospatial widget SHOULD provide  a `MapActivity` activity that is used to display a map view given a Mapbox API access token and an array of Mapbox styles url. The `MapActivity` WILL be initialized through an intent request.
The constants below are required:

```java

    String PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN;  // Mapbox API access token
    String[] PARCELABLE_KEY_MAPBOX_STYLES;  // Mapbox Styles (https://www.mapbox.com/mapbox-gl-js/style-spec/)
```

The following is what should be sent in the `PARCELABLE_KEY_MAPBOX_STYLES`:

Index 0 should have either of the following:
- A file path on the local storage eg. `file:///sdcard/MapboxStyles/nairobi-city-view.json`
- A Mapbox style URL eg. `mapbox://styles/ona/ksdk909kkscd9023k`
- A string of the JSON Object of an existing Mapbox Style or adhering to the Mapbox Style Spec

The `MapActivity` should allow selection of a geospatial feature and post it back as a result. The geospatial feature SHOULD be in `GeoJSON` format.

Example usage:

1. Start an activity to show a Mapbox Style
```java
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                "file:///sdcard/MapboxStyles/nairobi-city-view.json"
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivity(intent);
```


2. Start an activity with data

```java
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                "file:///sdcard/MapboxStyles/nairobi-city-view.json"
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivity(intent);
```

3. Start an activity expecting callback in case a feature is selected

```java
        /*
        mapboxStyleWithKujakuConfigData is:
         - a String with the complete Mapbox Style or
         - a local path on the android device with the complete Mapbox Style
        */

        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                mapboxStyleWithKujakuConfigData
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivityForResult(intent, 43);
```

In case the user clicks on a feature, the info-window at the bottom is displayed to show more details on the feature. Clicking on the feature again is considered a `double-click` and this initiates the callback closing the activity. The activity returns a JSON Object accessible on `Intent` parameter of the `onActivityResult(int, int, Intent)` calling-activity method. The geoJSON feature is retrieved from the `String` extra with the key `geojson_feature`

For the `MapActivity` to respond to clicks on a feature, the feature requires to have:
- Specified in the **Kujaku config**
- Properties defined for it
- An `id` as one of the `properties`


## How to create a Mapbox style with Kujaku configuration

The aim is to stick to a certain spec i.e. add the Kujaku configuration as close to the Mapbox specification. [Here](https://github.com/onaio/common-geo-registry-specification/blob/master/1.0/geospatial-widget-interface/sample_mapbox_style_with_kujaku_config.json) is a sample style with the Kujaku configuration.
The Kujaku Config enables the following capabilities:

1. Showing the information window - Activated on clicking a feature
2. Arranging the order of features in the information windows i.e. the order in which the features are listed
3. Specify which properties of a geoJSON feature to show in the information window and the labels to use for each feature
4. It also enables the callback in case a feature is double clicked by making the widget aware of the relevant data sources


Steps:

1. Add layers with preferred visual properties and name them appropriately(as per the Mapbox style spec)
2. Add your geospatial data to the Mapbox style in the form of geoJSON as per the Mapbox style spec
3. Add the Kujaku config

The Kujaku config is a JSON Object with the following:
1. `data_sources` JSON Array of `name`-only JSON Objects - The name points to the data source name in the style
```json
"data_sources": [
        {
          "name": "opensrp-custom-data-source-0"
        },
        {
          "name": "opensrp-custom-data-source-1"
        },
        {
          "name": "opensrp-custom-data-source-2"
        },
        {
          "name": "opensrp-custom-data-source-3"
        }
      ]
```

2. `sort_fields` JSON Array of JSON Objects(`type`, `data_field`). THe types can be `number`, `date` or `string`
```json
"sort_fields": [
        {
          "type": "date",
          "data_field": "client_reg_date"
        }
      ]
```

3. `info_window` JSON Object. This JSON Object contains a JSON Array with key `visible_properties`. The visibile properties array contains JSON Objects of `id` and `label` properties. The `id` is the key of the property in the feature while the label is what is shown on the info window as the property label
```json
"info_window": {
        "visible_properties": [
          {
            "id": "first_name",
            "label": "First Name"
          },
          {
            "id": "Birth_Weight",
            "label": "Birth Weight"
          },
          {
            "id": "Place_Birth",
            "label": "Place of Birth"
          },
          {
            "id": "zeir_id",
            "label": "ZEIR ID"
          }
        ]
      }
```


## MapboxOfflineDownloaderService

The Geospatial widget SHOULD provide the `MapboxOfflineDownloaderService` service that is used to download map layers for offline use. This service should also support the deletion of the offline map layers and resuming map layer download.
The service intent extras are as follows:

KEY | Type | Required | Description
--- | --- | --- | ---
`map_downloader_service` | `io.ona.kujaku.service.MapboxOfflineDownloaderService.SERVICE_ACTION` enum | Yes | Action to be performed. The service can either download(MapboxOfflineDownloaderService.SERVICE_ACTION.DOWNLOAD_MAP) or delete(MapboxOfflineDownloaderService.SERVICE_ACTION.DELETE_MAP) a downloaded map
`offline_map_unique_name` | String | Yes | Unique name for which the map will be referenced by
`mapbox_access_token` | String | Yes | This is required to access the Mapbox API
`offline_map_mapbox_style_url` | String | Yes | Required to access to download the map from the Mapbox API
`offline_map_max_zoom` | Double | Only for downloads | Specifies the max zoom level for the map assets to be downloaded
`offline_map_min_zoom` | Double | Only for downloads | Specifies the min zoom level for the map assets to be downloaded
`offline_map_top_left_bound` | Only for downloads | Yes | Specifies the top left bound of the map
`offline_map_bottom_right_bound` | Only for downloads | Yes | Specifies the bottom right bound of the map


The `MapboxOfflineDownloaderService` SHOULD post updates through a local broadcast with action `io.ona.kujaku.service.map.downloader.updates``(Constants.INTENT_ACTION_MAP_DOWNLOAD_SERVICE_STATUS_UPDATES)`. The updates SHOULD have:


KEY | Mandatory | Constant in Library | Type | Description
--- | --- | --- | --- | ---
`RESULT STATUS` | Yes | `io.ona.kujaku.service.MapboxOfflineDownloaderService.KEY_RESULT_STATUS` | `io.ona.kujaku.service.MapboxOfflineDownloaderService.SERVICE_ACTION_RESULT` enum | which is either `io.ona.kujaku.service.MapboxOfflineDownloaderService.SERVICE_ACTION_RESULT.SUCCESSFUL` or `io.ona.kujaku.service.MapboxOfflineDownloaderService.SERVICE_ACTION_RESULT.FAILED`
`RESULT MESSAGE` | Yes | `io.ona.kujaku.service.MapboxOfflineDownloaderService.KEY_RESULT_MESSAGE` | String | a simple message, for example, the download percentage or task failure message.
`offline_map_unique_name`| Yes | `PARCELABLE_KEY_MAP_UNIQUE_NAME` | String | the map name
`RESULTS PARENT ACTION` | Yes | `KEY_RESULTS_PARENT_ACTION` |  `io.ona.kujaku.service.MapboxOfflineDownloaderService.SERVICE_ACTION` enum | Operation being performed on the map which is either a download or deletion

The `MapActivity` will request some permissions(during runtime & in the manifest) for it to work. The following are the permissions:

- `android.permission.ACCESS_FINE_LOCATION`- For the location to center to the user's current location
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.ACCESS_WIFI_STATE`
- `android.permission.READ_EXTERNAL_STORAGE` - Read cached mapbox styles on the device
- `android.permission.WRITE_EXTERNAL_STORAGE` - Cache mapbox styles on the device for offline use
- `android.permission.INTERNET` - Automatically permitted

## Helper Functions

The following helper functions will provide additional functionality to manipulate the data.


