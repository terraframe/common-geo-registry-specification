
/**
 * Custom Widget Map View exending the MapBox default MapView
 * 
 */
public class WidgetMapView extends MapView {

    /**
     * Activate or not the user localisation : G3.2
     * 
     * @param localisation
     */
    public setLocalisation(boolean localisation) {

    }
    
    /**
     * Activate or not the manual route recording : G1.2. G1.3 ? Add possibility to record without maps ?
     * 
     * @param manualRecording
     */
    public setManualRecording(boolean manualRecording) {
        // Allow user to tap on the map to create a polygon
    }

    /**
     * Activate or not the (GPS) route recording : G1.1
     * 
     * @param recording
     */
    public setRecording(boolean recording) {
        // A record button is added to the interface allowing the user to start / pause / stop the record
    }

     /**
     * Activate or not the possibility to split a polygon : G2.4
     * 
     * @param recording
     */
    public setPlittingPolygon(boolean splittingPolygon) {
       
    }


    /**
     * Define the listener for the Record Route
     * @param listener
     */
    public void setOnRecordRouteListener(OnRecordRouteListener listener) {
        
    }
    /**
     * On Record Route Interface for managing route recording events
     */
    public interface OnRecordRouteListener {
        void onStartRecording();
        void onPauseRecording();
        void onStopRecording();
        void onGetTrack();
    }


     /**
     * Define the listener for the Manual Record Route
     * @param listener
     */
    public void setOnManualRecordRouteListener(OnManualRecordRouteListener listener) {
        
    }
    /**
     * On Manual Record Route Interface for managing manual route recording events
     */
    public interface OnManualRecordRouteListener {
        void onStartManualRecording();
        void onPauseManualRecording();
        void onStopManualRecording();
        void onAddMarker();
        void onRemoveMarker();
        void onMarkerClick(Marker marker);
    }


    /// Listener for splitting Polygon ?
}