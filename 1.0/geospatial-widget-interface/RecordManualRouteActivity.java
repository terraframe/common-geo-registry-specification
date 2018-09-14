/**
 * Activity displaying a map where user can record routes by clicking on the map
 * G1.2
 * 
 */
public class RecordManualRouteActivity implements WidgetMapView.OnManualRecordRouteListener {

   /**  */
   private WidgetMapView mapView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       // Mapbox Access token
       Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

       setContentView(R.layout.activity_main);

       mapView = findViewById(R.id.mapView);
       mapView.setManualRecording(true);          //  Activate the manual recording
       mapView.setActivity(this);

       mapView.onCreate(savedInstanceState);
   }
}
